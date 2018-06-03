package com.inSpringCloud.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("Request -> {} request URI -> {}",request,request.getRequestURI());
		logger.info("Request -> {} request URI -> {}",request,request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
