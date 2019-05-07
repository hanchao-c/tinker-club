package org.tinker.payment.server.provider;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tinker.order.model.ValidationParameter;
import org.tinker.order.provider.TestValidationProvider;
import org.tinker.payment.server.ApplicationTestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParameterValidationTest extends ApplicationTestContext {

	@Autowired
	private TestValidationProvider provider;
	
	@Test(expected = ConstraintViolationException.class)
	public void testSimpleConstraint() {
		try {
			provider.testSimpleConstraint("");
		} catch (Exception e) {
			log.error("参数校验失败_1", e);
			throw e;
		}
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testObjcetParams() {
		try {
			provider.testObject(null);
		} catch (Exception e) {
			log.error("参数校验失败_2", e);
			throw e;
		}
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testObjcetInnerParams() {
		try {
			ValidationParameter validationParameter = new ValidationParameter();
			provider.testObject(validationParameter);
		} catch (Exception e) {
			log.error("参数校验失败_3", e);
			throw e;
		}
	}
	
}
