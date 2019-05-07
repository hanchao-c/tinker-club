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

public class EnumTemplateDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer {

	@SuppressWarnings("rawtypes")
	private Class targetClass;

	public EnumTemplateDeserializer() {
	}

	public EnumTemplateDeserializer(Class<?> targetClass) {
		this.targetClass = targetClass;
	}
	
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
		this.targetClass = ctxt.getContextualType().getRawClass();
		return new EnumTemplateDeserializer(this.targetClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String text = parser.getText();
		if (StringUtils.isBlank(text)) {
			return null;
		}
		if(this.targetClass.isEnum()) {
			Enum<?> enumInstance = EnumUtils.getEnum(this.targetClass, text);
			if(null == enumInstance) {
				if(ClassUtils.isAssignable(this.targetClass, EnumTemplate.class)) {
					return EnumTemplateUtil.getByCode(text, this.targetClass);
				}
			}
			return enumInstance;
		}
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