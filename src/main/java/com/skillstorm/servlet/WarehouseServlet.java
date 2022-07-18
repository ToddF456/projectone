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
import com.skillstorm.daos.ItemDAO;
import com.skillstorm.daos.MySQLItemDAOImpl;
import com.skillstorm.model.Item;
import com.skillstorm.model.NotFound;
import com.skillstorm.service.URLParserService;

@WebServlet (urlPatterns = "/warehouses")
public class WarehouseServlet extends HttpServlet
{
	private static final long serialVersionUID = -5904700897033421495L;
	ItemDAO dao = new MySQLItemDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	// Returns all items
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try 
		{
			int id = urlService.extractIdFromURL(req.getPathInfo());
			// This means they want a specific item; fetch that item.
			Item item = dao.findById(id);
			if (item != null) 
			{
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(item));
			} 
			else 
			{
				resp.setStatus(404);
				resp.getWriter().print(mapper.writeValueAsString(new NotFound("No"
						+ " items with the provided Id found")));
			}
				
		} 
		catch (Exception e) 
		{
			// Means that there wasn't an id in the URL. Fetch all items instead.
			List<Item> items = dao.findAll();
			System.out.println(items);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(items));
		}
	}

}
