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

/**
 * This class contains all of the price related methods
 * 
 * @author Todd Foreman
 *
 */
@WebServlet (urlPatterns = "/warehouses/price/*")
public class PriceServlet extends HttpServlet
{
	private static final long serialVersionUID = -5904700897033421495L;
	ItemDAO dao = new MySQLItemDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
		
		
		/**
		 * Retrieves all of the items within a warehouse based on their price.
		 */
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			try 
			{
				int price = urlService.extractIdFromURL(req.getPathInfo());
				// This means they want a specific item; fetch that item.
				List<Item> item = dao.findByPrice(price);
				if (item != null) 
				{
					resp.setContentType("application/json");
					resp.getWriter().print(mapper.writeValueAsString(item));
				} 
				else 
				{
					resp.setStatus(404);
					resp.getWriter().print(mapper.writeValueAsString(new NotFound("No"
							+ " items with the provided Id found.")));
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
		
		/**
		 * Updates the price of an item on the database based on JSON received.
		 */
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			InputStream reqBody = req.getInputStream();
			Item newItem = mapper.readValue(reqBody, Item.class);
			dao.updatePrice(newItem); // IF the id changed
			if (newItem != null) 
			{
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(newItem));
				resp.setStatus(201); // The default is 200
			} 
			else 
			{
				resp.setStatus(400);
				resp.getWriter().print(mapper.writeValueAsString(new NotFound("Item was not found.")));
			}
		}
}

