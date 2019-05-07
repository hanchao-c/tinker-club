package org.tinker.auth.web;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.auth.service.UserService;

/**
 * 所有登陆用户都可以访问的controller
 */
@RestController
public class AuthcController {
	
	@Autowired
	private UserService userService;

	/**
	 * 修改密码
	 * @param password 密码
	 * @return
	 */
	@PatchMapping("authc/password")
	public void refreshPassword(@NotBlank String password) {
		userService.refreshPassword(null, password);
	}
	
}
