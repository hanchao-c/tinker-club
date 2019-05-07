package org.tinker.order.server.provider.impl;

import org.springframework.stereotype.Service;
import org.tinker.order.model.ValidationParameter;
import org.tinker.order.provider.TestValidationProvider;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestValidationProviderImpl implements TestValidationProvider {

	@Override
	public void testSimpleConstraint(String name) {
		log.info("method testSimpleConstraint start!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	public void testObject(ValidationParameter validationParameter) {
		log.info("method testObject start!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}
