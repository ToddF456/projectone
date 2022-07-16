package com.skillstorm.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet (urlPatterns = "/warehouses")
public class WarehouseServlet extends HttpServlet{

	private static final long serialVersionUID = -5904700897033421495L;
	
	
	//Quick test on servlet.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Hello Servlet!");
		
		//1. Send the message.
		//2. Redirect them to the HTML page.
		
		resp.sendRedirect("/projectone");
	}

}
