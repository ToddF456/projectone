package com.skillstorm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the ItemCORSFilter class, which implements a CORs filter 
 * for the servlet, allowing the servlet to be contacted by a webpage.
 * 
 * @author Todd Foreman
 */
@WebFilter(urlPatterns = "/*")
public class ItemCORSFilter implements Filter 
{

	/**
	 * Occurs when the CORS filter is initiated to confirm that it has initiated.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("CORS Filter Created");
	}
	
	/**
	 * Necessary to destroy the CORSfilter when the servlet is turned off.
	 */
	@Override
	public void destroy() 
	{
		
	}
	
	/**
	 * The full filter process, allowing specific url's 
	 * (mainly ones sent by browsers) to send http requests to the servlet.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		System.out.println("CORS Filter activated.");
		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("Access-Control-Allow-Origin", "*"); // Allows any domain to make a request
		res.addHeader("Access-Control-Allow-Methods", "*"); // Allows all HTTP methods
		res.addHeader("Access-Control-Allows-Credentials", "true");
		res.addHeader("Access-Control-Allow-Headers", "*"); // Allows all types of headers
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getMethod().equals("OPTIONS")) 
		{
			res.setStatus(202);
		}
		chain.doFilter(req, res);
	}

}