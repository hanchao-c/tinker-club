package org.tinker.asset.util;

import org.tinker.asset.FooEnum;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumTemplateUtilTest extends TestCase {

	public void testGetInstanceByCodeIfPosible() {
		assertNotNull(EnumTemplateUtil.getByCode("OK__", FooEnum.class));
		assertNull(EnumTemplateUtil.getByCode("OK__&&", FooEnum.class));
	}

	public void testGetInstanceIfPosible() {
		assertNotNull(EnumTemplateUtil.getIfPosible("NOT_OK", FooEnum.class));
		assertNotNull(EnumTemplateUtil.getIfPosible("OK__", FooEnum.class));
		assertNull(EnumTemplateUtil.getIfPosible("OK__&&", FooEnum.class));
		assertNull(EnumTemplateUtil.getIfPosible("XX", FooEnum.class));
	}

	public void testToEnumStringEnumOfQextendsEnumTemplate() {
		log.info("FooEnum.NOT_OK : {}", EnumTemplateUtil.toEnumString(FooEnum.NOT_OK));
		log.info("FooEnum.OK : {}", EnumTemplateUtil.toEnumString(FooEnum.OK));
		log.info("FooEnum.OK default method toString : {}", FooEnum.OK.toString());
		assertNotSame(EnumTemplateUtil.toEnumString(FooEnum.OK), FooEnum.OK.toString());
	}

	public void testToEnumStringClassOfTString() {
		log.info("FooEnum.NOT_OK : {}", EnumTemplateUtil.toEnumString(FooEnum.class, "NOT_OK"));
		log.info("FooEnum.NOT_OK : {}", EnumTemplateUtil.toEnumString(FooEnum.class, "NOT_OK___"));
	}

}
