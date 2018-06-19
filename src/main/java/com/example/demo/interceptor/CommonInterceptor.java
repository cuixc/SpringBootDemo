package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;


public class CommonInterceptor implements HandlerInterceptor {
	private final static Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getContextPath();
		log.info("访问:"+path);
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        request.setAttribute("basePath", basePath);
        return true;
	}
}
