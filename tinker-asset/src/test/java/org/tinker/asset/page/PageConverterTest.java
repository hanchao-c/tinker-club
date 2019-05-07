package org.tinker.asset.page;

import java.time.Duration;
import java.time.Instant;

import org.tinker.asset.Foo;
import org.tinker.asset.FooMapping;
import org.tinker.asset.ObjectConverter;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PageConverterTest extends TestCase {

	public void testBeanCopy() {
		Foo foo = ObjectConverter.CGLIB_BEAN_COPIER.convert(Foo.make(), Foo.class);
		assertNotNull(foo);
		log.info(foo.toString());
		FooMapping fooMapping = ObjectConverter.CGLIB_BEAN_COPIER.convert(Foo.make(), FooMapping.class);
		assertNotNull(fooMapping);
		log.info(fooMapping.toString());
	}

	public void testJackson() {
		Foo foo = ObjectConverter.JACKSON_CONVERTER.convert(Foo.make(), Foo.class);
		assertNotNull(foo);
		log.info(foo.toString());
		FooMapping fooMapping = ObjectConverter.JACKSON_CONVERTER.convert(Foo.make(), FooMapping.class);
		assertNotNull(fooMapping);
		log.info(fooMapping.toString());
	}
	
	//#########################################################################################################################
	//#########################################################################################################################
	//#########################################################################################################################
	
	private final ObjectConverter beanCopyConverter = ObjectConverter.CGLIB_BEAN_COPIER;
	
	private final ObjectConverter jacksonConverter = ObjectConverter.JACKSON_CONVERTER;
	
	private final int times = 1000;
	
	public void testJacksonConvertPerformance() {
		Instant methodBefore = Instant.now();
		for (int i = 0; i < times; i++) {
			jacksonConverter.convert(Foo.make(), FooMapping.class);
		}
		Instant methodDone = Instant.now();
		long consume = Duration.between(methodBefore, methodDone).toMillis();
		log.info("jacksonConverter : {} ms", consume );
	}
	
	public void testBeanCopyConvertPerformance() {
		Instant methodBefore = Instant.now();
		for (int i = 0; i < times; i++) {
			beanCopyConverter.convert(Foo.make(), FooMapping.class);
		}
		Instant methodDone = Instant.now();
		long consume = Duration.between(methodBefore, methodDone).toMillis();
		log.info("beanCopyConverter : {} ms", consume );
	}
}
