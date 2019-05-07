package org.tinker.asset.util;

import java.util.List;
import java.util.Map;

import org.tinker.asset.Foo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;

import junit.framework.TestCase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonUtilTest extends TestCase {

	public void testToJSONString() {
		Foo foo = Foo.make();
		log.info(JacksonUtil.toJSONString(foo));
	}

	public void testToJavaObjectStringClassOfT() {
		Foo foo = Foo.make();
		String jsonString = JacksonUtil.toJSONString(foo);
		Foo javaObject = JacksonUtil.toJavaObject(jsonString, Foo.class);
		log.info(javaObject.toString());
	}

	public void testToJavaObjectStringTypeReferenceOfT() {
		Tag<Foo> tag = new Tag<>(Foo.make());
		String jsonString = JacksonUtil.toJSONString(tag);
		Tag<Foo> javaObject = JacksonUtil.toJavaObject(jsonString, new TypeReference<Tag<Foo>>() { });
		log.info(javaObject.toString());
		
	}

	public void testToList() {
		List<Foo> foos = Lists.newArrayList(Foo.make(), Foo.make(), Foo.make());
		String jsonString = JacksonUtil.toJSONString(foos);
		List<Foo> list = JacksonUtil.toList(jsonString, Foo.class);
		log.info(list.toString());
	}

	public void testToMap() {
		Foo foo = Foo.make();
		String jsonString = JacksonUtil.toJSONString(foo);
		Map<String, Object> map = JacksonUtil.toMap(jsonString, String.class, Object.class);
		log.info(map.toString());
	}

	public void testDoReadValueIntoComplexJavaType() {
	}
	
	@Getter
	@Setter
	@ToString
	public static class Tag<T> {
		
		private T t;
		
		public Tag() {
		}
		
		public Tag(T t) {
			this.t = t;
		}
		
	}
	
}
