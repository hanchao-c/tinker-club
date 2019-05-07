package org.tinker.asset;

import java.time.Duration;
import java.time.Instant;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.MDC;
import org.tinker.asset.util.IDUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractAspectWatcher {
	
	private final String LOG_REQUEST_ID = "requestId";
	
	private final String separation = getSeparation();

	public Object aspectProceed(ProceedingJoinPoint joinPoint) throws Throwable {
		MDC.put(LOG_REQUEST_ID, IDUtil.uuid());
		Instant methodBefore = Instant.now();
		Signature signature = joinPoint.getSignature();
		String declaringTypeName = signature.getDeclaringType().getSimpleName();
		String methodName =  signature.getName();
		
		try {
			log.info(StringUtils.wrap(getMethodName(declaringTypeName, methodName), separation));
			beforeProceed(joinPoint);
			Object result = proceed(joinPoint);
			afterProceed(result, joinPoint);
			return result;
		} finally {
			Instant methodDone = Instant.now();
			long consume = Duration.between(methodBefore, methodDone).toMillis();
			String consumeResult = consume < 1 ? " < 1" : String.valueOf(consume);
			log.info("consume : {} ms", consumeResult);
			log.info(StringUtils.wrap(getMethodName(declaringTypeName, methodName), separation));
			MDC.remove(LOG_REQUEST_ID);
		}
	}
	
	public String getMethodName(String declaringTypeName, String declaringMethodName) {
		return new StringBuilder(declaringTypeName).append(".").append(declaringMethodName).toString();
	}
	
	public String getSeparation(){
		return " ======================= ";
	}
	
	public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}

	public abstract void beforeProceed(ProceedingJoinPoint joinPoint) throws Throwable;
	
	public abstract void afterProceed(Object result, ProceedingJoinPoint joinPoint)  throws Throwable;

	
}
