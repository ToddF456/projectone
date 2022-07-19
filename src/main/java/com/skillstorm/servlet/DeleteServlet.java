package com.skillstorm.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.ItemDAO;
import com.skillstorm.daos.MySQLItemDAOImpl;
import com.skillstorm.model.Item;
import com.skillstorm.model.NotFound;
import com.skillstorm.service.URLParserService;

@WebServlet (urlPatterns = "/warehouses/delete/*")
public class DeleteServlet extends HttpServlet
{
	private static final long serialVersionUID = -5904700897033421495L;
	ItemDAO dao = new MySQLItemDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			InputStream reqBody = req.getInputStream();
			Item id = mapper.readValue(reqBody, Item.class);
			dao.delete(id); // IF the id changed
			if (id != null) 
			{
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(id));
				resp.setStatus(201); // The default is 200
			} 
			else 
			{
				resp.setStatus(400);
				resp.getWriter().print(mapper.writeValueAsString(new NotFound("Item was not found.")));
			}
		}
}
