package org.tinker.util;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.tinker.asset.Responsive;
import org.tinker.asset.Template;

import com.google.common.base.Throwables;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 */
public class Propagater {

	public static OperablePropagateException throwOf(Responsive responsive) {
		checkNotNull(responsive);
		throw new OperablePropagateException(responsive.getCode(), responsive.getMessage());
	}

	public static OperablePropagateException throwOf(String message) {
		checkNotNull(message);
		throw new OperablePropagateException(message);
	}

	public static OperablePropagateException throwOf() {
		throw new OperablePropagateException();
	}

	public static RuntimeException interrupt(Throwable throwable) {
		checkNotNull(throwable);
		Throwables.throwIfUnchecked(throwable);
		throw new RuntimeException(throwable);
	}

	public static RuntimeException interrupt() {
		throw new RuntimeException();
	}

	/**
	 * 行为传递异常（主要返回给前端错误信息）
	 * 自定义可返回错误信息的异常
	 */
	@Getter
	@ToString
	public static class OperablePropagateException extends RuntimeException implements Template {

		private static final long serialVersionUID = 1L;

		private final static HttpStatus ERROR_RESPONSE = HttpStatus.INTERNAL_SERVER_ERROR;

		private final String code;

		private OperablePropagateException(String code, String message) {
			super(StringUtils.defaultIfBlank(message, String.valueOf(ERROR_RESPONSE.getReasonPhrase())));
			this.code = StringUtils.defaultIfBlank(code, String.valueOf(ERROR_RESPONSE.value()));
		}

		private OperablePropagateException(String message) {
			this(null, message);
		}

		private OperablePropagateException() {
			this(null, null);
		}
		
	}
}
