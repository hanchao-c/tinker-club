package org.tinker.order.server.asset.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.tinker.asset.DefaultDubboProviderAspect;

@Component
@Aspect
public class ProviderAspect extends DefaultDubboProviderAspect {
	
	@Pointcut("execution(* org.tinker.order.provider.*.*(..))")
	private void aspect() {
	}

	@Around("aspect()")
	public Object providerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		return super.aspectProceed(joinPoint);
	}
	
}
