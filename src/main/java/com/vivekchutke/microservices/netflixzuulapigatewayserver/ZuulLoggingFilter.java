package com.vivekchutke.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("*** Request - {} Request URI {}", request, request.getRequestURI());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		logger.info("*** InZuulLogginFilter method Should Filter");
		return true;
	}

	@Override
	public int filterOrder() {
	
		return 1;
	}

	@Override
	public String filterType() {
	// possible options "pre", "post" or "error"
		return "pre";
	}

}
