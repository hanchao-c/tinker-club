package org.tinker.order.server.provider.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.tinker.order.provider.TestExceptionProvider;

@Service
public class TestExceptionProviderImpl implements TestExceptionProvider {

	@Override
	public void testRuntimeException() {
		throw new RuntimeException("error!!!");
	}

	@Override
	public void testRuntimeExceptionWithThrow() throws RuntimeException {
		throw new RuntimeException("someting wrong!!!");
	}

	@Override
	public void testUncheckedException() throws IOException {
		throw new IOException("File not found");
	}
	
	

}
