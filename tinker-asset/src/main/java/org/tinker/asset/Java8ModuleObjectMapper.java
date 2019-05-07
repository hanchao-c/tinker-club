package org.tinker.asset;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class Java8ModuleObjectMapper extends ObjectMapper {
	
	private static final long serialVersionUID = 1L;
	
	public Java8ModuleObjectMapper() {
		super();
		this.registerModule(this.getJava8TimeModule())
			.registerModule(new ParameterNamesModule())
			.registerModule(new Jdk8Module())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
	private JavaTimeModule getJava8TimeModule() {
		DateTimeFormatter LOCAL_TIME_PARTTEN = DateTimeFormatter.ofPattern("HH:mm:ss");
		DateTimeFormatter LOCAL_DATE_TIME_PARTTEN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		JavaTimeModule timeModule = new JavaTimeModule();
		timeModule
				.addDeserializer(LocalTime.class, new LocalTimeDeserializer(LOCAL_TIME_PARTTEN))
				.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(LOCAL_DATE_TIME_PARTTEN))
				.addSerializer(LocalTime.class, new LocalTimeSerializer(LOCAL_TIME_PARTTEN))
				.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(LOCAL_DATE_TIME_PARTTEN));
		return timeModule;
	}
	
}
