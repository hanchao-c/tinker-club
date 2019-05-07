package org.tinker.order.provider;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.tinker.order.model.ValidationParameter;

/**
 * 测试参数校验 JSR-303
 */
public interface TestValidationProvider {

	
	void testSimpleConstraint(@NotBlank(message = "姓名不能为空") String name);
	
	void testObject(@NotNull ValidationParameter validationParameter);
	
}
