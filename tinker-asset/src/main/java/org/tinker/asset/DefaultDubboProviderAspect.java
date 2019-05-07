package org.tinker.asset;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.CodeSignature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class DefaultDubboProviderAspect extends AbstractAspectWatcher {

	@Override
	public void beforeProceed(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		String[] parameterNames = ((CodeSignature)signature).getParameterNames();
		if(!ArrayUtils.isEmpty(parameterNames)){
			Object[] args = joinPoint.getArgs();
			if(!ArrayUtils.isEmpty(args)){
				for (int i = 0; i < parameterNames.length; i++) {
					log.info("parameter {} : {}", parameterNames[i], args[i]);
				}
			}
		}		
	}

	@Override
	public void afterProceed(Object result, ProceedingJoinPoint joinPoint) throws Throwable {
		if(null != result){
			log.info("response : {}", result);
		}
	}

}
