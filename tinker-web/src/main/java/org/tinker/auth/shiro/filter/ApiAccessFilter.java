package org.tinker.auth.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.tinker.auth.shiro.realm.AuthorizingRealmBeanProvider;

import lombok.extern.slf4j.Slf4j;


/**
 * API访问控制filter
 */
@Component
@Slf4j
public class ApiAccessFilter extends PageRedirectFilter {

	@Autowired
	AuthorizingRealmBeanProvider provider;
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		String subUrl = getPathWithinApplication(request);
		String auth = getAuthFromUrl(subUrl);
		Subject subject = SecurityUtils.getSubject();
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		HttpServletResponse httpResponse = WebUtils.toHttp(response);
		if(null == auth) {
			if(subject.isAuthenticated()) {
				WebUtils.issueRedirect(httpRequest, httpResponse, "/forward/index");
			} else {
				WebUtils.issueRedirect(httpRequest, httpResponse, "/login");
			}
			
			return false;
		}
		boolean hasRole = subject.hasRole(auth);
		if(!hasRole) {
			log.error("API 账户 {} 没有对应[后台权限] : {}, 请求子链接  : {}", subject.getPrincipal(), auth, subUrl);
			if(isAjax(httpRequest)) {
				httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
			} else {
				WebUtils.issueRedirect(httpRequest, httpResponse, ERROR_PAGE_404);
			}
			return false;
		}
		return true;
	}
	
	private String getAuthFromUrl(String url) {
		String[] path;
		try {
			path = StringUtils.split(url, "/");
		} catch (Exception e) {
			return null;
		}
		if(path.length > 0) {
			return path[0];
		} else {
			return null;
		}
	}
	

}
