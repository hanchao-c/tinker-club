package org.tinker.cms.web;

import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.webplugin.dropzone.DropzoneImagePaser;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("dropzone")
@Slf4j
public class PluginDropzoneController {

	/**
	 * 前端控件 dropzone 图片上传
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping("upload")
	public ResponseEntity<?> imageUpload(ShiroHttpServletRequest request) {
		DropzoneImagePaser imagePaser = new DropzoneImagePaser(request);
		return imagePaser.parse(multipartFile -> {
			//multipartFile.getInputStream() 获取文件stream进行其他操作
			//multipartFile.transferTo(targetFile) 转换成targetFile
			if(RandomUtils.nextBoolean()) {
				throw new RuntimeException("自定义错误信息,多试几次肯定会成功的");
			}
			//当前只返回文件的名称 作为上传文件成功的标示
			log.info("图片上传  图片名称 : {}", multipartFile.getOriginalFilename());
		    return "UPLOAD-SUCCESS IMAGE NAME : " + multipartFile.getOriginalFilename();
		});
	}
	
}
