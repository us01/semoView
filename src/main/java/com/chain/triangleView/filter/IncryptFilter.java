package com.chain.triangleView.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.chain.triangleView.wrapper.LoginWrapper;

@WebFilter(description = "incrypt", urlPatterns = { "*.me" })
public class IncryptFilter implements Filter {

    public IncryptFilter() {}
    
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest h_request = (HttpServletRequest)request;
		
		LoginWrapper lw = new LoginWrapper(h_request);
		
		chain.doFilter(lw, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
