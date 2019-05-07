package org.tinker.asset.spring;

import static java.util.stream.Collectors.toMap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.executable.ExecutableValidator;

import org.apache.commons.collections4.EnumerationUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.tinker.asset.AbstractAspectWatcher;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;

/**
 * WEB入口AOP 
 */
@Component
@Aspect
@Slf4j
public class ContorllerAspect extends AbstractAspectWatcher {

	private final ExecutableValidator validator = Validation
			.byProvider(HibernateValidator.class)
			.configure()
			.failFast(true)
			.buildValidatorFactory()
			.getValidator()
			.forExecutables();
	
	private final LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
	
	@Pointcut("execution(public * org.tinker.*.web..*.*(..)) && !execution(public * org.tinker.auth.web.PageRedirectController.*(..))")
    private void aspect() {
	}
	
	
	@Around("aspect()")
	public Object aspectContorllerProceed(ProceedingJoinPoint joinPoint) throws Throwable {
		return super.aspectProceed(joinPoint);
	}
	
	@Override
	public String getSeparation() {
		return " *********************** ";
	}
	
	@Override
	public void beforeProceed(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		StringBuffer requestUrl = request.getRequestURL();
		//请求地址
		log.info("request url--- : {}", requestUrl);
		//请求参数
		log.info("request param- : {}", getParamStringFromRequest(request));
		//请求头信息
		log.info("request header : {}", getHeaderStringFromRequest(request));
		//参数验证
		validateIfApplicable(joinPoint);
	}

	@Override
	public void afterProceed(Object result, ProceedingJoinPoint joinPoint) {
		if(null != result){
			log.info("response : {}", result);
		}
	}
	
	/**
	 * 参数验证过程
	 * @param joinPoint
	 * @throws BindException 
	 */
	private void validateIfApplicable(ProceedingJoinPoint joinPoint) throws BindException {
		Object[] args = joinPoint.getArgs();
		if(!ArrayUtils.isEmpty(args)){
			Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
			if(hasConstraintsAnnotation(method)){
				//参数验证
				Set<ConstraintViolation<Object>> constraintViolations = this.validator.validateParameters(joinPoint.getThis(), method, args);
				if(!CollectionUtils.isEmpty(constraintViolations)){
					String[] parameterNames = this.parameterNameDiscoverer.getParameterNames(method);
					for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
						PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
		                String parameterName = parameterNames[pathImpl.getLeafNode().getParameterIndex()];
		                String errorMessage = new StringBuilder(64)
								.append("Parameter [")
								.append(parameterName)
								.append("] ")
								.append(constraintViolation.getMessage())
								.toString();
		                throw new ValidationException(errorMessage);
					}
				}
			}
		}
	}
	
	
	/**
	 * 是否存在JSR 303规范注解
	 * @param method
	 * @return
	 */
	private boolean hasConstraintsAnnotation(Method method) {
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		for (Annotation[] annotations : parameterAnnotations) {
			for (Annotation annotation : annotations) {
				Class<? extends Annotation> annotationType = annotation.annotationType();
				if(annotationType.isAnnotationPresent(Constraint.class)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 参数信息
	 * @param request
	 * @return
	 */
	private String getParamStringFromRequest(final HttpServletRequest request) {
		return parseEnumerationToString(request.getParameterNames(), request::getParameter);
	}

	/**
	 * 请求头信息
	 * @param request
	 * @return
	 */
	private String getHeaderStringFromRequest(final HttpServletRequest request) {
		return parseEnumerationToString(request.getHeaderNames(), request::getHeader);
	}

	private String parseEnumerationToString(Enumeration<String> enumerations, Function<String, String> function) {
		List<String> list = EnumerationUtils.toList(enumerations);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		Map<String, String> map = list.stream().collect(toMap(Function.identity(), function));
		return Joiner.on("&").withKeyValueSeparator("=").join(map);
	}
	
}