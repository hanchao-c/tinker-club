package org.tinker.asset.util;

import java.util.Arrays;
import java.util.List;

import org.tinker.asset.Foo;
import org.tinker.asset.FooEnum;

import junit.framework.TestCase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanCopyUtilTest extends TestCase {

	
	public void testCopyProperties() {
		log.info("test CopyProperties");
		TestOfStringTarget stringTarget = BeanCopyUtil.copyProperties(new TestOfStringSource(), new TestOfStringTarget());
		log.info("properties * to string : {}", stringTarget);
		TestOfPrimitiveTarget primitiveTarget = BeanCopyUtil.copyProperties(new TestOfPrimitiveSource(), new TestOfPrimitiveTarget());
		log.info("properties * to primitive : {}", primitiveTarget);
	}

	public void testCopyPropertiesByClass() {
		log.info("test copyPropertiesByClass");
		TestOfStringTarget stringTarget = BeanCopyUtil.copyPropertiesByClass(new TestOfStringSource(), TestOfStringTarget.class);
		log.info("properties * to string : {}", stringTarget);
		TestOfPrimitiveTarget primitiveTarget = BeanCopyUtil.copyPropertiesByClass(new TestOfPrimitiveSource(), TestOfPrimitiveTarget.class);
		log.info("properties * to primitive : {}", primitiveTarget);
	}
	
	public void testCopyList() {
		log.info("test copyList");
		List<TestOfStringSource> listStringSource = Arrays.asList(new TestOfStringSource(), new TestOfStringSource());
		List<TestOfStringTarget> stringTarget = BeanCopyUtil.copyList(listStringSource, TestOfStringTarget.class);
		log.info("properties * to string of list : {}", stringTarget);
		List<TestOfPrimitiveSource> listStringPrimitive = Arrays.asList(new TestOfPrimitiveSource(), new TestOfPrimitiveSource());
		List<TestOfPrimitiveTarget> primitiveTarget = BeanCopyUtil.copyList(listStringPrimitive, TestOfPrimitiveTarget.class);
		log.info("properties * to primitive of list : {}", primitiveTarget);
	}
	
	@Getter
	@Setter
	@ToString
	public static class TestOfStringSource {
		private String a ="TEST";
		private Boolean b = Boolean.TRUE;
		private Byte c;
		private Character d = Character.valueOf('d');
		private Short e;
		private Integer f = 1;
		private Long g;
		private Double h;
		private Float i;
		private boolean j;
		private byte k = 'k';
		private char l = 'l';
		private short m;
		private int n = 3;
		private long o;
		private double p;
		private float q = 1.0F;
		private Foo foo = Foo.make();
		private FooEnum fooEnum = FooEnum.NOT_OK;
		private FooEnum fooEnum1 = FooEnum.NOT_OK;
		private String fooEnum2 = FooEnum.NOT_OK.getCode();
		private String fooEnum3 = FooEnum.NOT_OK.name();
	}
	
	@Getter
	@Setter
	@ToString
	public static class TestOfStringTarget {
		private String a;
		private String b;
		private String c;
		private String d;
		private String e;
		private String f;
		private String g;
		private String h;
		private String i;
		private String j;
		private String k;
		private String l;
		private String m;
		private String n;
		private String o;
		private String p;
		private String q;
		private Foo foo;
		private String fooEnum;
		private FooEnum fooEnum1;
		private FooEnum fooEnum2;
		private FooEnum fooEnum3;
		
	}
	
	@Getter
	@Setter
	@ToString
	public static class TestOfPrimitiveSource {
		private String a ="1";
		private Boolean b;
		private Long c = 15L;
		private Character d = Character.valueOf('d');
		private Short e = 13;
		private Integer f = 100;
		private Long g = 5L;
		private Double h;
		private Float i;
		private String j;
		private String k;
		private Character l;
		private String m = "13";
		private long n = 3;
		private long o;
		private Double p;
		private String q = "1.0F";
	}
	
	@Getter
	@Setter
	@ToString
	public static class TestOfPrimitiveTarget {
		private int a;
		private Integer b;
		private Integer c;
		private char d;
		private Short e;
		private Integer f;
		private Long g;
		private Double h;
		private Float i;
		private boolean j;
		private byte k;
		private char l;
		private short m;
		private int n;
		private long o;
		private double p;
		private float q;
	}
	
	
}
