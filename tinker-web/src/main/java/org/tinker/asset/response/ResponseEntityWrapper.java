package org.tinker.asset.response;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SimplePageResult;

/**
 * SpringMVC 返回对象包装工具
 */
public class ResponseEntityWrapper {

	/**
	 * 200
	 * @return
	 */
	public static ResponseEntity<Void> OK() {
		return status(HttpStatus.OK);
	}
	
	/**
	 * 200
	 * @param body 返回的数据
	 * @return
	 */
	public static <T> ResponseEntity<T> OK(T body) {
		return body(HttpStatus.OK, body);
	}
	
	
	/**
	 * 200
	 * 构造datatable分页结果
	 * @param pagination 分页对象信息
	 * @return
	 */
//	public static <T> ResponseEntity<Page<T>> wrapPage(Page<T> page) {
//		return wrapPage(page.getTotal(), page.getContent());
//	}
	
	/**
	 * 200
	 * 构造datatable分页结果
	 * @param total 数据总数量
	 * @param data 分页数据
	 * @return
	 */
	public static <T> ResponseEntity<Page<T>> wrapPage(Integer total, List<T> content) {
		return OK(new SimplePageResult<>(total, content));
	}
	
	/**
	 * 200
	 * 构造空的datatable分页结果
	 * @return
	 */
	public static <T> ResponseEntity<SimplePageResult<T>> wrapEmptyPagination() {
		return OK(SimplePageResult.empty());
	}
	
	/**
	 * 400
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> badRequest() {
		return badRequest(null);
	}

	/**
	 * 400
	 * @param message 错误信息
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> badRequest(String message) {
		return wrap(HttpStatus.BAD_REQUEST, message);
	}

	/**
	 * 401
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> unauthorized() {
		return unauthorized(null);
	}

	
	/**
	 * 401
	 * @param message 错误信息
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> unauthorized(String message) {
		return wrap(HttpStatus.BAD_REQUEST, message);
	}
	
	/**
	 * 404
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> notFound() {
		return notFound(null);
	}
	
	/**
	 * 404
	 * @param message 错误信息
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> notFound(String message) {
		return wrap(HttpStatus.NOT_FOUND, message);
	}
	
	/**
	 * 500
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> serverError() {
		return serverError(null);
	}

	/**
	 * 500
	 * @param message 错误信息
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> serverError(String message) {
		return wrap(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}
	
	/**
	 * 503
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> serviceUnavailable() {
		return serviceUnavailable(null);
	}

	/**
	 * 503
	 * @param message 错误信息
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> serviceUnavailable(String message) {
		return wrap(HttpStatus.SERVICE_UNAVAILABLE, message);
	}
	
	
	/**
	 * 构造一个具有http状态 和 信息的返回结果
	 * @param httpStatus
	 * @param message
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> wrap(HttpStatus httpStatus, String message) {
		return wrap(httpStatus, null, message);
	}
	
	/**
	 * 构造一个具有http状态 , 编码以及信息的返回结果
	 * @param httpStatus
	 * @param message
	 * @return
	 */
	public static ResponseEntity<DefaultResponse> wrap(HttpStatus httpStatus, String code, String message) {
		message = StringUtils.defaultIfBlank(message, httpStatus.getReasonPhrase());
		code = StringUtils.defaultIfBlank(code, String.valueOf(httpStatus.value()));
		DefaultResponse response = new DefaultResponse(code, message);
		return body(httpStatus, response);
	}
	
	/**
	 * 构造一个只有http状态的返回对象
	 * 
	 * @param httpStatus
	 * @return
	 */
	public static ResponseEntity<Void> status(HttpStatus httpStatus) {
		return ResponseEntity.status(httpStatus).build();
	}
	
	/**
	 * 构造一个只有http状态和数据对象的返回结果
	 * @param httpStatus
	 * @param body
	 * @return
	 */
	public static <T> ResponseEntity<T> body(HttpStatus httpStatus, T body) {
		return ResponseEntity.status(httpStatus).body(body);
	}
	
	private ResponseEntityWrapper() {
	}
	
}
