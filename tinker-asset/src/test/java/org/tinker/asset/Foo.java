package org.tinker.asset;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Foo {
	private String foo;
	private Long box;
	private Long long1;
	private BigDecimal bigdecimal1;
	private LocalDate localDate1;
	private LocalDateTime localDateTime1;
	private LocalTime localTime1;
	private FooEnum fooEnum;
	
	public static Foo make() {
		Foo foo = new Foo();
		foo.setFoo("foo1");
//		foo.setBox(1L);
		foo.setLong1(2L);
		foo.setBigdecimal1(BigDecimal.TEN);
		foo.setLocalDateTime1(LocalDateTime.now());
		foo.setLocalDate1(LocalDate.now());
		foo.setLocalTime1(LocalTime.now());
		foo.setFooEnum(FooEnum.NOT_OK);
		return foo;
	}
}
