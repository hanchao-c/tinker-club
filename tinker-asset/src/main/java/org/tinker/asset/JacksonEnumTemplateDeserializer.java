package org.tinker.asset;

import java.io.IOException;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.tinker.asset.Template.EnumTemplate;
import org.tinker.asset.util.EnumTemplateUtil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import lombok.extern.slf4j.Slf4j;

/**
 * 枚举code值 -> 枚举
 * @param <T>
 */
@Slf4j
public class JacksonEnumTemplateDeserializer<T extends Enum<T> & EnumTemplate> extends JsonDeserializer<T> implements ContextualDeserializer {

	private Class<T> targetClass;

	public JacksonEnumTemplateDeserializer() {
	}

	public JacksonEnumTemplateDeserializer(Class<T> targetClass) {
		this.targetClass = targetClass;
	}
	
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
		@SuppressWarnings("unchecked")
		Class<T> rawClass = (Class<T>) ctxt.getContextualType().getRawClass();
		return new JacksonEnumTemplateDeserializer<>(rawClass);
	}

	@Override
	public T deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String text = parser.getText();
		if (StringUtils.isBlank(text)) {
			return null;
		}
		if(this.targetClass.isEnum()) {
			//根据枚举的名称获取枚举
			T enumInstance = EnumUtils.getEnum(this.targetClass, text);
			if(null == enumInstance) {
				if(ClassUtils.isAssignable(this.targetClass, EnumTemplate.class)) {
					//根据枚举的code值获取枚举
					return EnumTemplateUtil.getByCode(text, this.targetClass);
				}
			}
			return enumInstance;
		}else {
			log.error("被映射类型必须为枚举类型");
		}
		log.error("类型转换失败 无法将  [{}] 映射为 [{}] 失败", text, targetClass.getName());
		throw new IllegalJsonDeserializeException("类型转换失败");
	}

	public static class IllegalJsonDeserializeException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public IllegalJsonDeserializeException(String message) {
			super(message);
		}

	}

}