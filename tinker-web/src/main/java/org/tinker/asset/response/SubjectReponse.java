//package org.tinker.asset.response;
//
//import com.google.common.base.MoreObjects;
//
//public class SubjectReponse<T> extends DefaultResponse {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	/**
//	 * 
//	 */
//
//	private final T subject;
//
//	public SubjectReponse(String code, String message, T subject) {
//		super(code, message);
//		this.subject = subject;
//	}
//
//	public T subject() {
//		return subject;
//	}
//
//	public T getSubject() {
//		return subject;
//	}
//
//	@Override
//	public String toString() {
//		return MoreObjects.toStringHelper(this)
//				.add("code", this.getCode())
//				.add("message", this.getMessage())
//				.add("subject", this.getSubject())
//				.toString();
//	}
//
//}
