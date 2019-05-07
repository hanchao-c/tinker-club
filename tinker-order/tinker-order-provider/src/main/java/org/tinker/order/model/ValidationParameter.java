package org.tinker.order.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ValidationParameter implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @Size(min = 1, max = 20)
    private String name;
 
    @Min(18)
    @Max(100)
    private int age;
 
 
}