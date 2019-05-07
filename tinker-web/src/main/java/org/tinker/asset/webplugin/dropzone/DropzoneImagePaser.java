package org.tinker.asset.webplugin.dropzone;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.tinker.asset.response.ResponseEntityWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 图片上传
 *
 */
@Slf4j
public class DropzoneImagePaser {
	
	private final ShiroHttpServletRequest request;
	
	public DropzoneImagePaser(ShiroHttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 图片解析 处理过程
	 * @param function
	 * @return
	 */
	public ResponseEntity<?> parse(ImageParseFunction function) {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(); 
		HttpServletRequest httpServletRequest = (HttpServletRequest) request.getRequest();
	    MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(httpServletRequest);  
	    MultipartFile multipartFile = multipartRequest.getFile("file");
		try {
			String result = function.apply(multipartFile);
			return ResponseEntityWrapper.OK(UploadResponse.success(result));
		} catch (Exception e) {
			log.info("图片处理过程异常", e);
			return ResponseEntityWrapper.body(HttpStatus.INTERNAL_SERVER_ERROR, UploadResponse.error(e.getMessage()));
		}
	}
	
	/**
	 * 图片处理function
	 */
	@FunctionalInterface
	public interface ImageParseFunction extends Function<MultipartFile, String>{
		
	}
	
	/**
	 * 图片上传结果信息
	 */
	public static class UploadResponse extends HashMap<String, String> implements Map<String, String>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		public static UploadResponse success(String resourceId) {
			UploadResponse uploadResponse = new UploadResponse();
			uploadResponse.put("resourceId", resourceId);
			return uploadResponse;
		}
		
		public static UploadResponse error(String message) {
			UploadResponse uploadResponse = new UploadResponse();
			uploadResponse.put("error", message);
			return uploadResponse;
		}
		
	}

}


