package org.tinker.asset.util;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.tinker.asset.Java8ModuleObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;

import lombok.extern.slf4j.Slf4j;

/**
 * Jackson Util
 */
@Slf4j
public class JacksonUtil {
	
	private static final ObjectMapper objectMapper = new Java8ModuleObjectMapper();
	
	/**
	 * JavaObject to JSONString
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object) {
		if (null == object) {
			return null;
		}
		try {
			return getObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			log.error("toJSONString error", e);
			log.error("object : {}", object.toString());
			Throwables.throwIfUnchecked(e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * JSONString to javaObject
	 * 
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T toJavaObject(String source, Class<T> clazz) {
		if (isBlank(source)) {
			return null;
		}
		try {
			return getObjectMapper().readValue(source, checkNotNull(clazz));
		} catch (Exception e) {
			log.error("toJavaObject error", e);
			log.error("source :　{}, class : {}", source, clazz);
			Throwables.throwIfUnchecked(e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * JSONString to complex javaObject
	 * 
	 * @param source
	 * @param typeReference
	 * @return
	 */
	public static <T> T toJavaObject(String source, TypeReference<T> typeReference) {
		if (isBlank(source)) {
			return null;
		}
		try {
			return getObjectMapper().readValue(source, checkNotNull(typeReference));
		} catch (Exception e) {
			log.error("toJavaObject error", e);
			log.error("source :　{}, type : {}", source, typeReference.getType());
			Throwables.throwIfUnchecked(e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Java type convert
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T convertJavaObject(Object source, Class<T> clazz) {
		if(null == source) {
			return null;
		}
		String jsonString;
		if(source instanceof String) {
			jsonString = (String) source;
		}else {
			jsonString = toJSONString(source);
		}
		return toJavaObject(jsonString, clazz);	
	}

	/**
	 * JSONString to list
	 * 
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toList(String source, Class<T> clazz) {
		return doReadValueIntoComplexJavaType(source, List.class, clazz);
	}

	/**
	 * JSONString to map
	 * 
	 * @param source
	 * @param keyClazz
	 * @param valueClazz
	 * @return
	 */
	public static <K, V> Map<K, V> toMap(String source, Class<K> keyClazz, Class<V> valueClazz) {
		return doReadValueIntoComplexJavaType(source, Map.class, keyClazz, valueClazz);
	}

	/**
	 * JSONString to complex javaObject
	 * 
	 * @param source
	 * @param parametrized
	 * @param parameterClasses
	 * @return
	 */
	public static <T> T doReadValueIntoComplexJavaType(String source, Class<?> parametrized, Class<?>... parameterClasses) {
		try {
			JavaType javaType = getObjectMapper().getTypeFactory().constructParametricType(parametrized, parameterClasses);
			return getObjectMapper().readValue(source, javaType);
		} catch (IOException e) {
			log.error("doReadValueIntoComplexJavaType error", e);
			log.error("source :　{}, parametrized : {}, parameterClasses : {}", source, parametrized, ArrayUtils.toString(parameterClasses));
			Throwables.throwIfUnchecked(e);
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T doReadValueIntoComplexJavaType(String source, Type type) {
		try {
			JavaType javaType = getObjectMapper().getTypeFactory().constructType(type);
			return getObjectMapper().readValue(source, javaType);
		} catch (IOException e) {
			log.error("doReadValueIntoComplexJavaType error", e);
			log.error("source :　{}, type : {}", source, type.getTypeName());
			Throwables.throwIfUnchecked(e);
			throw new RuntimeException(e);
		}
	}
	

	
	
	private JacksonUtil() {
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	
}
