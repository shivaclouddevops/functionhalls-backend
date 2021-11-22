package com.vedika.functionhall.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class MDCFilter implements Filter {
	Logger logger = LoggerFactory.getLogger(MDCFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			MDC.put("userId", getCorrelationId());
			logger.info("user enters in");
			filterChain.doFilter(servletRequest, servletResponse);
		} finally {
			MDC.remove("userId");
		}
	}

	private String getCorrelationId() {
		return UUID.randomUUID().toString();
	}
}
