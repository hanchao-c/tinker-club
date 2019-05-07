package org.tinker.asset.spring;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.tinker.asset.response.DefaultResponse;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.util.Propagater.OperablePropagateException;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 *
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerBean {

	/**
	 * SpringMVC + hibernate-validator
	 * 未使用BindingResult的异常处理
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({BindException.class, ValidationException.class})
	public ResponseEntity<DefaultResponse> bindException(Exception exception) {
		if(exception instanceof BindException) {
			BindException bindException = (BindException) exception;
			String errorMessage = null;
			List<ObjectError> allErrors = bindException.getAllErrors();
			for (ObjectError objectError : allErrors) {
				if(objectError instanceof FieldError) {
					FieldError fieldError = (FieldError) objectError;
					errorMessage = new StringBuilder(50)
							.append("Parameter [")
							.append(fieldError.getObjectName())
							.append(".")
							.append(fieldError.getField())
							.append("] ")
							.append(fieldError.getDefaultMessage())
							.toString();
					log.error("target : {}", bindException.getTarget());
				} else {
					errorMessage = objectError.getDefaultMessage();
				}
				log.error(errorMessage);
				break;
			}
			return ResponseEntityWrapper.badRequest(errorMessage);
		}
		return ResponseEntityWrapper.badRequest(exception.getMessage());
	}
	
	/**
	 * 自定义操作失败传递异常的处理
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(OperablePropagateException.class)
	public ResponseEntity<DefaultResponse> operablePropagaterException(OperablePropagateException exception) {
		final HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
		log.error(exception.toString());
		return ResponseEntityWrapper.wrap(serverError, exception.getCode(), exception.getMessage());
	}
	
	/**
	 * 全局异常处理
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<DefaultResponse> exception(Exception exception) {
		log.error("系统错误", exception);
		return ResponseEntityWrapper.serverError("系统错误");
	}

}
