package org.tinker.asset.util;

import java.util.EnumSet;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.EnumUtils;
import org.tinker.asset.Template;
import org.tinker.asset.Template.EnumTemplate;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * 
 */
public class EnumTemplateUtil {

	/**
	 * 根据枚举的 code 获取当前实例
	 * @param code
	 * @param clz
	 * @return
	 */
	public static <T extends Enum<T> & EnumTemplate> T getByCode(String code, Class<T> clz){
		if(null == clz || clz.isInterface() || !clz.isEnum()){
			throw new IllegalArgumentException();
		}
		EnumSet<T> enums = EnumSet.allOf(clz);
		if(!CollectionUtils.isEmpty(enums)){
			for (T enumInstance : enums) {
				EnumTemplate template = (EnumTemplate) enumInstance;
				if (Objects.equal(template.getCode(), code)) {
					return enumInstance;
				}
			}
		}
		return null;
	}
	
	/**
	 * 根据枚举的 name或者 code 获取当前实例
	 * @param nameOrCode
	 * @param clz
	 * @return
	 */
	public static <T extends Enum<T> & EnumTemplate> T getIfPosible(String nameOrCode, Class<T> clz){
		T enumInstance = EnumUtils.getEnum(clz, nameOrCode);
		return null == enumInstance ? getByCode(nameOrCode, clz) : enumInstance;
	}
	
	/**
	 * 枚举类型的toString
	 * @param enumInstance
	 * @return
	 */
	public static String toEnumString(Enum<? extends EnumTemplate> enumInstance) {
		if(null == enumInstance){
			return null;
		}
		String classSimpleName = enumInstance.getClass().getSimpleName();	
		String enumInstanceName = enumInstance.name();						
		EnumTemplate template = (EnumTemplate) enumInstance;
		StringBuilder stringBuilder = new StringBuilder(classSimpleName)
				.append(".")
				.append(enumInstanceName);
		String enumQualifiedName = stringBuilder.toString();
		return fullIntoString(enumQualifiedName, template);
	}
	
	/**
	 * 枚举类型的toString
	 * @param clazz
	 * @param code
	 * @return
	 */
	public static <T extends Enum<T> & EnumTemplate> String toEnumString(Class<T> clazz, String nameOrcode) {
		T enumInstance = getIfPosible(nameOrcode, clazz);
		if(null != enumInstance){
			return toEnumString(enumInstance);
		}
		return null;
	}
	
	private static String fullIntoString(String name, Template template) {
		return MoreObjects.toStringHelper(name)
		.add("code", template.getCode())
		.add("message", template.getMessage())
		.toString();
	}
	
}
