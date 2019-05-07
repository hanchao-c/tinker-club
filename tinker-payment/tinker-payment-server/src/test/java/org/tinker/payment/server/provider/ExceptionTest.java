package org.tinker.payment.server.provider;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tinker.order.provider.TestExceptionProvider;
import org.tinker.payment.server.ApplicationTestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionTest extends ApplicationTestContext {

	@Autowired
	private TestExceptionProvider testExceptionProvider;
	
	@Test(expected = RuntimeException.class)
	public void testRuntimeException() {
		try {
			testExceptionProvider.testRuntimeException();
		} catch (RuntimeException e) {
			log.error("RuntimeException occured", e);
			throw e;
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testRuntimeExceptionWithThrow() {
		try {
			testExceptionProvider.testRuntimeExceptionWithThrow();
		} catch (RuntimeException e) {
			log.error("RuntimeException occured", e);
			throw e;
		}
	}
	
	@Test(expected = IOException.class)
	public void testUncheckedException() throws IOException {
		try {
			testExceptionProvider.testUncheckedException();
		} catch (IOException e) {
			log.error("UncheckedException occured", e);
			throw e;
		}
	}
}
