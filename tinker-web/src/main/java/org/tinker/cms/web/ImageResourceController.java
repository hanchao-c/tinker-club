package org.tinker.cms.web;

import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.util.Base64;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.asset.webplugin.dropzone.DropzoneImagePaser;
import org.tinker.cms.util.SimpleHttpClientUtil;

import com.google.common.collect.Maps;
import com.google.common.io.Files;

import lombok.extern.slf4j.Slf4j;

/**
 */
@RestController
@Slf4j
public class ImageResourceController {

	/**
	 * 前端控件 dropzone 图片上传
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping("images")
	public ResponseEntity<?> imageUpload(ShiroHttpServletRequest request) {
		
		DropzoneImagePaser imagePaser = new DropzoneImagePaser(request);
		return imagePaser.parse(multipartFile -> {
			return uploadToTestServer(multipartFile);
		});
	}
	
	/**
	 * 
	 * 上传作者自己的测试服务器
	 * 实际开发过程中,要根据自己的需要处理图片,可以保存到本地或者上传到某文件服务器
	 * !!!流要关闭
	 * @param multipartFile
	 * @return
	 */
	@Deprecated
	public String uploadToTestServer(MultipartFile multipartFile) {
		Map<String, String> data = Maps.newHashMap();
		InputStream inputStream = null;
		try {
			//图片流
			inputStream = multipartFile.getInputStream();
			//图片流转数组
			byte[] byteArray = IOUtils.toByteArray(inputStream);
			//数组转base64
			data.put("encodeBase64String", Base64.encodeBase64String(byteArray));
			//文件后缀
			data.put("endfix", "." + Files.getFileExtension(multipartFile.getOriginalFilename()));
			//base64传递到测试服务器
			String resultString = SimpleHttpClientUtil.post("http://139.199.107.128:8088/uploader/upload", data);
			//获取图片访问地址
			Map<String, String> map = JacksonUtil.toMap(resultString, String.class, String.class);
			return map.get("result");
		} catch (Exception e) {
			log.error("文件上传失败", e);
			throw new RuntimeException("上传失败");
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}
}
