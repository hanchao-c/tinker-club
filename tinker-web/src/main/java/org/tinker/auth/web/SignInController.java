package org.tinker.auth.web;

import javax.validation.constraints.NotBlank;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.util.Propagater;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SignInController {
	
	/**
	 * 用户登录操作
	 * @param account
	 * @param password
	 * @return
	 */
	@PostMapping("signIn")
	public void loginon(@NotBlank String account, @NotBlank String password) {
		log.info("用户账号 account : {} 登录", account);
		Subject subject = SecurityUtils.getSubject();
		//用户是否已经授权
		if(subject.isAuthenticated()){
			//退出登录
			subject.logout();
		}
		try {
			//登录
			subject.login(new UsernamePasswordToken(account, password));
		} catch (IncorrectCredentialsException | UnknownAccountException e) {
			throw Propagater.throwOf("账号或者密码错误");
		} catch (LockedAccountException e) {
			throw Propagater.throwOf("当前账号已被锁定,请联系管理人员");
		} catch (DisabledAccountException e) {
			throw Propagater.throwOf("当前账号已被禁用,请联系管理人员");
		} finally {
		}
	}
	

}
