package org.tinker.order.provider;

import java.io.IOException;

public interface TestExceptionProvider {

	
	void testRuntimeException();
	
	/**
	 * 当有可能抛出异常时, 尽量声明 (推荐)
	 * @throws RuntimeException
	 */
	void testRuntimeExceptionWithThrow() throws RuntimeException;
	
	
	void testUncheckedException() throws IOException;
	
}
