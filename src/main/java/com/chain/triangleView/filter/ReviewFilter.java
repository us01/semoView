package com.chain.triangleView.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.chain.triangleView.wrapper.ReviewWrapper;

public class ReviewFilter implements Filter {

    public ReviewFilter() {}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r_request = (HttpServletRequest)request;
		
		ReviewWrapper rw = new ReviewWrapper(r_request);
		
		chain.doFilter(rw, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
