package org.tinker.auth.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.EnumerationUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tinker.asset.constant.SystemUser;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.service.PermissionService;
import org.tinker.auth.service.UserService;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

/**
 * 所有页面跳转控制
 *
 */
@Controller
public class PageRedirectController {

	/**
	 * session中用户菜单对应的key
	 */
	private final String USER_MENU = "USER_MENUS";
	/**
	 * session中用户信息对应的key
	 */
	private final String USER_BASE_INFO = "USER_BASE_INFO";
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserService userService;
	
	/**
	 * 登录页
	 * @return
	 */
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@GetMapping("logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "login";
	}
	
	/**
	 * 错误页面
	 * @param code
	 * @return
	 */
	@GetMapping("error/{code}")
	public String error(@PathVariable String code) {
		return "error-" + code;
	}
	
	/**
	 * 首页跳转
	 * @param path
	 * @return
	 */
	@GetMapping("forward/index")
	public String index() {
		Subject subject = SecurityUtils.getSubject();
		String account = (String)subject.getPrincipal();
		//session中添加用户对应菜单
		if(null == getAttribute(USER_MENU)) {
			//系统管理员则查询所有菜单, 非系统管理员则查找当前角色对应菜单
			List<PermissionCascade> cascade;
			if(Objects.equal(account, SystemUser.SYSTEM_OWNER_ACCOUNT)) {
				cascade = permissionService.getCascade("root");
			}else {
				cascade = permissionService.getAcitveCascadeByAccount(account);
			}
			setAttribute(USER_MENU, JacksonUtil.toJSONString(cascade));
		}
		//session中添加用户信息
		if(null == getAttribute(USER_BASE_INFO)) {
			User user = userService.getByAccount(account);
			//用户id、用户名称
			Map<String, String> userBaseInfo = ImmutableMap.of("userId", user.getId(), "userName", user.getName());
			setAttribute(USER_BASE_INFO, JacksonUtil.toJSONString(userBaseInfo));
		}
		return "index";
	}
	
	/**
	 * 业务页面
	 * @param dir
	 * @param fileName
	 * @return
	 */
	@GetMapping("forward/**")
	public ModelAndView forward(HttpServletRequest request, ModelAndView modelAndView) {
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		if (null == principal) {
			modelAndView.setViewName("error-404");
		} else {
			//获取实际业务路径
			String extractPath = getExtractPath(request);
			//将HttpServletRequest中的参数放入Model
			putParamsIntoModel(request, modelAndView);
			modelAndView.setViewName(extractPath);
		}
		return modelAndView;
	}
	
	/**
	 * 获取实际业务路径
	 * @param request
	 * @return
	 */
	private String getExtractPath(HttpServletRequest request) {
		//请求路径
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		//匹配路径
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		//实际路径
		return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}
	
	/**
	 * 获取session中属性
	 * @param attributeName 属性名称
	 * @return
	 */
	private Object getAttribute(String attributeName) {
		Subject subject = SecurityUtils.getSubject();
		return subject.getSession().getAttribute(attributeName);
	}
	
	/**
	 * session设置属性及属性值
	 * @param attributeName 属性名称
	 * @param attributeValue 属性值
	 */
	private void setAttribute(String attributeName, Object attributeValue) {
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().setAttribute(attributeName, attributeValue);
	}
	

	/**
	 * 请求参数放入model
	 */
	private void putParamsIntoModel(HttpServletRequest request, ModelAndView modelAndView) {
		//获取所有参数名称
		List<String> parameterNamesList = EnumerationUtils.toList(request.getParameterNames());
		//参数名称以及参数值放入Model中
		parameterNamesList.stream().forEach(parameterName -> 
			modelAndView.addObject(parameterName, request.getParameter(parameterName))
		);
	}

}
