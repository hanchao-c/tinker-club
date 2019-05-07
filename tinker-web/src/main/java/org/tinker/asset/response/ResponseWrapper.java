//package org.tinker.asset.response;
//
//import org.springframework.http.HttpStatus;
//import org.tinker.component.Template.Responsive;
//
//public class ResponseWrapper {
//
//	/**
//	 * 200
//	 * @param subject
//	 * @return
//	 */
//	public static <T> SubjectReponse<T> success(T subject) {
//		return wrapSubject(HttpStatus.OK, subject);
//	}
//
//	/**
//	 * 200
//	 * @return
//	 */
//	public static DefaultResponse success() {
//		return wrap(HttpStatus.OK, null);
//	}
//
//	/**
//	 * 400
//	 * @return
//	 */
//	public static DefaultResponse badRequest() {
//		return badRequest(null);
//	}
//
//	/**
//	 * 400
//	 * @param message
//	 * @return
//	 */
//	public static DefaultResponse badRequest(String message) {
//		return wrap(HttpStatus.BAD_REQUEST, message);
//	}
//
//	/**
//	 * 401
//	 * @return
//	 */
//	public static DefaultResponse unauthorized() {
//		return unauthorized(null);
//	}
//
//	/**
//	 * 401
//	 * @param message
//	 * @return
//	 */
//	public static DefaultResponse unauthorized(String message) {
//		return wrap(HttpStatus.UNAUTHORIZED, message);
//	}
//
//	/**
//	 * 404
//	 * @return
//	 */
//	public static DefaultResponse notFound() {
//		return notFound(null);
//	}
//
//	/**
//	 * 404
//	 * @param message
//	 * @return
//	 */
//	public static DefaultResponse notFound(String message) {
//		return wrap(HttpStatus.NOT_FOUND, message);
//	}
//
//	/**
//	 * 500
//	 * @return
//	 */
//	public static DefaultResponse serverError() {
//		return wrap(HttpStatus.INTERNAL_SERVER_ERROR, null);
//	}
//
//	/**
//	 * 500
//	 * @param message
//	 * @return
//	 */
//	public static DefaultResponse serverError(String message) {
//		return wrap(HttpStatus.INTERNAL_SERVER_ERROR, message);
//	}
//	
//	/**
//	 * 503
//	 * @return
//	 */
//	public static DefaultResponse serviceUnavailable() {
//		return serviceUnavailable(null);
//	}
//	
//	/**
//	 * 503
//	 * @param message
//	 * @return
//	 */
//	public static DefaultResponse serviceUnavailable(String message) {
//		return wrap(HttpStatus.SERVICE_UNAVAILABLE, null);
//	}
//
//	public static DefaultResponse wrap(Responsive responsive) {
//		return wrap(responsive.getCode(), responsive.getMessage());
//	}
//
//	public static DefaultResponse wrap(HttpStatus httpStatus) {
//		return wrap(String.valueOf(httpStatus.value()), httpStatus.getReasonPhrase());
//	}
//
//	public static DefaultResponse wrap(HttpStatus httpStatus, String message) {
//		return wrap(String.valueOf(httpStatus.value()), null == message ? httpStatus.getReasonPhrase() : message);
//	}
//
//	public static DefaultResponse wrap(String code, String message) {
//		return new DefaultResponse(code, message);
//	}
//
//	public static <T> SubjectReponse<T> wrapSubject(HttpStatus httpStatus, T subject) {
//		return wrapSubject(String.valueOf(httpStatus), httpStatus.getReasonPhrase(), subject);
//	}
//
//	public static <T> SubjectReponse<T> wrapSubject(String code, String message, T subject) {
//		return new SubjectReponse<>(code, message, subject);
//	}
//
//	private ResponseWrapper() {
//	}
//
//}
