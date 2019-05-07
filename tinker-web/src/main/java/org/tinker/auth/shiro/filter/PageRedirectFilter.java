package org.tinker.auth.shiro.filter;

import java.util.Objects;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RegExUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import org.tinker.asset.constant.SystemUser;

import lombok.extern.slf4j.Slf4j;

/**
 * PAGE访问控制filter
 *
 */
@Component
@Slf4j
public class PageRedirectFilter extends AccessControlFilter{
	
	/**
	 */
	protected final String ERROR_PAGE_404 = "/extra_404_error.html";
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		String principal = (String)subject.getPrincipal();
		boolean isAdmin = Objects.equals(principal, SystemUser.SYSTEM_OWNER_ACCOUNT);
		if(isAdmin) {
			String rawSubUrl = getPathWithinApplication(request);
			return !Objects.equals("/", rawSubUrl);
		}
		return isAdmin;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String rawSubUrl = getPathWithinApplication(request);
		String realSubUrl = RegExUtils.replaceFirst(rawSubUrl, "/forward/", "");
		if(Objects.equals(realSubUrl, "index")) {
			return true;
		}
		Subject subject = SecurityUtils.getSubject();
		boolean permitted = subject.isPermitted(realSubUrl);
		if(!permitted) {
			log.error("PAGE 账户 {} 没有对应页面访问权限(页面可能不存在), 页面子链接  : {}", subject.getPrincipal(), realSubUrl);
			HttpServletRequest httpRequest = WebUtils.toHttp(request);
			HttpServletResponse httpResponse = WebUtils.toHttp(response);
			if(isAjax(httpRequest)) {
				 WebUtils.issueRedirect(httpRequest, httpResponse, "/error/404");
			} else{
				 WebUtils.issueRedirect(httpRequest, httpResponse, ERROR_PAGE_404);
			}
			return false;
		}
		return true;
	}
	
	protected boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}

}
