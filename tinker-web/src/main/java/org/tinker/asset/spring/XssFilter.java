package org.tinker.asset.spring;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.shiro.web.servlet.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * XSS攻击过滤
 *
 */
@Slf4j
public class XssFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HtmlEscapeRequestWrapper xssRequest = new HtmlEscapeRequestWrapper((HttpServletRequest) request);
		chain.doFilter(xssRequest, response);
	}
	
	private class HtmlEscapeRequestWrapper extends HttpServletRequestWrapper {

		public HtmlEscapeRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {
			return escapeHtml(super.getParameter(name));
		}

		@Override
		public String[] getParameterValues(String name) {
			return escapeHtml(super.getParameterValues(name));
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			Map<String, String[]> parameterMap = super.getParameterMap();
			if (MapUtils.isEmpty(parameterMap)) {
				return parameterMap;
			}
			parameterMap.entrySet().stream().forEach(entry -> entry.setValue(escapeHtml(entry.getValue())));
			return parameterMap;
		}

		/**
		 * 特殊字符替换
		 * @param text
		 * @return
		 */
		private String escapeHtml(String text) {
			if (StringUtils.isBlank(text)) {
				return text;
			}
			String escapedText = StringEscapeUtils.escapeHtml4(text);
			if(!Objects.equals(escapedText, text)) {
				log.error("参数存在非法字符, 过滤前 {}, 过滤后 : {} ", text, escapedText);
			}
			return escapedText;
		}

		private String[] escapeHtml(String... texts) {
			if(ArrayUtils.isEmpty(texts)) {
				return texts;
			}
			return Arrays.stream(texts).map(this::escapeHtml).toArray(String[]::new);
		}

	}

}
