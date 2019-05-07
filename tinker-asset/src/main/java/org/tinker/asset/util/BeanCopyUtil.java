package org.tinker.asset.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.EnumUtils;
import org.tinker.asset.Template.EnumTemplate;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.google.common.collect.ImmutableMap;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

public class BeanCopyUtil {

	private static final Map<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();
	private static final Converter DEFAULT_CONVERTER = new DefaultConverter();
	
	/**
	 * 对象属性copy
	 * @param source 源对象
	 * @param target 目标对象
	 * @return 目标对象
	 */
	public static <T extends Object> T copyProperties(Object source, T target) {
		return copyProperties(source, target, null);
    }
	
	/**
	 * 对象属性copy
	 * @param source 源对象
	 * @param target 目标对象
	 * @param converter 自定义converter
	 * @return 目标对象
	 */
	public static <T extends Object> T copyProperties(Object source, T target, Converter converter) {
		if(null == source) {
			return null;
		}
		checkNotNull(target);
		BeanCopier copier = getCacheBeanCopier(source.getClass(), target.getClass(), true);
        copier.copy(source, target, null == converter ? DEFAULT_CONVERTER : converter);
		return target;
    }

	/**
	 * 对象属性copy
	 * @param source 源对象
	 * @param targetClass 目标对象类型
	 * @return 目标对象
	 */
    public static <T> T copyPropertiesByClass(Object source, Class<T> targetClass) {
    	return copyPropertiesByClass(source, targetClass, null);
    }
    
    /**
     * 对象属性copy
     * @param source 源对象
     * @param targetClass 目标对象类型
     * @param converter 自定义converter
     * @return 目标对象
     */
    public static <T> T copyPropertiesByClass(Object source, Class<T> targetClass, Converter converter) {
    	if(null == source) {
    		return null;
    	}
		ConstructorAccess<T> constructorAccess = ConstructorAccess.get(checkNotNull(targetClass));
		T target = constructorAccess.newInstance();
    	return copyProperties(source, target, converter);
    }

    /**
     * 集合对象属性copy
     * @param collection 源对象集合
     * @param targetClass 目标对象类型
     * @return 目标对象集合
     */
    public static <T> List<T> copyList(Collection<?> collection, Class<T> targetClass) {
       return copyList(collection, targetClass, null);
    }
    
    /**
     * 集合对象属性copy
     * @param collection 源对象集合
     * @param targetClass 目标对象类型
     * @param converter 自定义converter
     * @return 目标对象集合
     */
    public static <T> List<T> copyList(Collection<?> collection, Class<T> targetClass, Converter converter) {
        if (CollectionUtils.isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().map(source ->  {
        	return copyPropertiesByClass(source, targetClass, converter);
        }).collect(Collectors.toList());
    }
    
	/**
	 * BeanCopier对象缓存（创建代价有点大, 缓存处理）
	 * @param sourceClass 源对象类型
	 * @param targetClass 目标对象类型
	 * @param useConverter 是否使用converter
	 * @return BeanCopier对象
	 */
	private static BeanCopier getCacheBeanCopier(Class<?> sourceClass, Class<?> targetClass, boolean useConverter) {
		String copierKey = sourceClass.getName().concat(targetClass.getName()).concat(String.valueOf(useConverter));
		return BEAN_COPIER_CACHE.computeIfAbsent(copierKey, e -> BeanCopier.create(sourceClass, targetClass, useConverter));
	}
	
	private BeanCopyUtil() {
	}
	
	/**
	 * 默认的converter
	 * 
	 * 特殊处理源对象与目标对象属性类型不一致时的转换
	 * 
	 * ~[* to String]
	 * ~[* to primitive]
	 * 
	 * 针对系统的EnumTemplat的特殊处理
	 * 如果枚举实现了EnumTemplate接口,在copy的过程中,自动进行String与Enum的转换
	 * ~[EnumTemplate to String]
	 * ~[* to EnumTemplate]
	 */
	@Slf4j
	public static class DefaultConverter implements Converter, Serializable {

		private static final long serialVersionUID = 1L;

		/**
		 * 基础类型默认值
		 */
		private final static Map<Class<?>, Object> PRIMITIVES_DEFAULT_VALUES;
		
		/**
		 * 基础类型值的解析过程
		 */
		private final static Map<Class<?>, Function<String, Object>> PRIMITIVES_VALUE_FUNCTIONS;
		
		/**
		 * 包装类型值的解析过程
		 */
		private final static Map<Class<?>, Function<String, Object>> PRIMITIVES_WRAPPER_VALUE_FUNCTIONS;
		
		static {
			PRIMITIVES_DEFAULT_VALUES = ImmutableMap.<Class<?>, Object>builder()
					.put(byte.class, 0)
					.put(short.class, 0)
					.put(int.class, 0)
					.put(long.class, 0L)
					.put(float.class, 0.0f)
					.put(double.class, 0.0d)
					.put(char.class, '\u0000')
					.put(boolean.class, false)
					.build();
			
			PRIMITIVES_VALUE_FUNCTIONS = ImmutableMap.<Class<?>, Function<String, Object>>builder()
					.put(byte.class, Byte::parseByte)
					.put(short.class, Short::parseShort)
					.put(int.class, Integer::parseInt)
					.put(long.class, Long::parseLong)
					.put(float.class, Float::parseFloat)
					.put(double.class, Double::parseDouble)
					.put(boolean.class, Boolean::parseBoolean)
					.put(char.class, str -> Character.valueOf(str.charAt(0)))
					.build();
			
			PRIMITIVES_WRAPPER_VALUE_FUNCTIONS = ImmutableMap.<Class<?>, Function<String, Object>>builder()
					.put(Byte.class, Byte::valueOf)
					.put(Short.class, Short::valueOf)
					.put(Integer.class, Integer::valueOf)
					.put(Long.class, Long::valueOf)
					.put(Float.class, Float::valueOf)
					.put(Double.class, Double::valueOf)
					.put(Boolean.class, Boolean::valueOf)
					.put(Character.class, str -> Character.valueOf(str.charAt(0)))
					.build();
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public Object convert(Object value, @SuppressWarnings("rawtypes") Class targetClass, Object context) {
			if(null == value) {
				//基本类型的默认值处理
				if(targetClass.isPrimitive()) {
					return toPrimitiveValue(targetClass, value);
				}
				return null;
			}
			Class<?> sourceClass = value.getClass();
			//如果映射类型不变,则直接返回
			if(Objects.equals(value.getClass(), targetClass)) {
				return value;
			}
			//映射类型 字符串
			if(Objects.equals(String.class, targetClass)) {
				//基本及包装类型
				if(ClassUtils.isPrimitiveOrWrapper(sourceClass)) {
					return String.valueOf(value);
				//引用类型
				}else {
					//枚举
					if(sourceClass.isEnum()) {
						if(ClassUtils.isAssignable(sourceClass, EnumTemplate.class)){
							EnumTemplate template = (EnumTemplate) value;
							return template.getCode();
						}
						return ((Enum<?>)value).name();
					}else {
						//其他类型
						log.error("不建议将非枚举的引用类型转换为字符串  value : {} ", value);
						return value.toString();
					}
				}
			}
			//映射类型为 基本及包装类型
			if(ClassUtils.isPrimitiveOrWrapper(targetClass)) {
				if(targetClass.isPrimitive()) {
					//基本数据类型
					return toPrimitiveValue(targetClass, value);
				}else {
					//包装类型
					return toPrimitiveWrapperValue(targetClass, value);
				}
			}
			//*********************************************************
			//******************* Enumtemplate ************************
			//*********************************************************
			if(targetClass.isEnum()) {
				String enumIdentity = String.valueOf(value);
				Enum<?> enumInstance = EnumUtils.getEnum(targetClass, enumIdentity);
				if(null == enumInstance) {
					if(ClassUtils.isAssignable(targetClass, EnumTemplate.class)) {
						return EnumTemplateUtil.getByCode(enumIdentity, targetClass);
					}
				}
				return enumInstance;
			}
			return value;
		}
		
		/**
		 * 基础映射值处理
		 * @param clazz
		 * @param value
		 * @return
		 */
		private Object toPrimitiveValue(Class<?> clazz, Object value) {
			if(null == value) {
				return PRIMITIVES_DEFAULT_VALUES.get(clazz);
			}
			return PRIMITIVES_VALUE_FUNCTIONS.get(clazz).apply(String.valueOf(value));
		}
		
		/**
		 * 包装类型值出库
		 * @param clazz
		 * @param value
		 * @return
		 */
		private Object toPrimitiveWrapperValue(Class<?> clazz, Object value) {
			return PRIMITIVES_WRAPPER_VALUE_FUNCTIONS.get(clazz).apply(String.valueOf(value));
		}
		
	}
}