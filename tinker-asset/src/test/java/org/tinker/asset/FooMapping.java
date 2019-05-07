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
public class FooMapping {
	
	private String foo;
	private String box;
	private Long long1;
	private BigDecimal bigdecimal1;
	private LocalDate localDate1;
	private LocalDateTime localDateTime1;
	private LocalTime localTime1;
	private FooEnum fooEnum;
}