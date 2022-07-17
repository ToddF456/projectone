package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.model.Item;
import com.skillstorm.conf.WarehouseDbCreds;



public class MySQLItemDAOImpl implements ItemDAO{

	public static void main(String[] args)
	{
		MySQLItemDAOImpl dao = new MySQLItemDAOImpl();
		System.out.println(dao.findByPriceRange(40, 150));
		
	}
	
	
	/**
	 * This method find each row within the items table, the main table for this warehouse.
	 */
	@Override
	public List<Item> findAll() 
	{
		String sql = "SELECT * FROM item";
		try(Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Item> items = new LinkedList<>();
			
			while(rs.next())
			{
				Item item = new Item(rs.getInt("item_id"), rs.getInt("warehouse_id"),
						rs.getString("item_name"), rs.getInt("item_price"));
				items.add(item);
			}
			return items;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method finds an item based on it's specific item ID.
	 */
	@Override
	public Item findById(int id) 
	{
		String sql = "SELECT * FROM item WHERE item_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			LinkedList<Item> items = new LinkedList<>();
			
			if(rs.next())
			{
				return new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method lists all of the items located in the respective warehouse using the warehouse ID.
	 */
	@Override
	public List<Item> findByWarehouseID(int warehouseId) 
	{
		String sql = "SELECT * FROM item WHERE warehouse_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, warehouseId);
			ResultSet rs = ps.executeQuery();
			LinkedList<Item> items = new LinkedList<>();
			
			while(rs.next())
			{
				Item item = new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				items.add(item);
			}
			return items;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method lists all of the items which have the specified name in the parameter.
	 */
	@Override
	public List<Item> findByName(String name) 
	{
		String sql = "SELECT * FROM item WHERE item_name = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			LinkedList<Item> items = new LinkedList<>();
			
			while(rs.next())
			{
				Item item = new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				items.add(item);
			}
			return items;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *This method lists all of the items which have the specified price in the parameter
	 */
	@Override
	public List<Item> findByPrice(int price) 
	{
		String sql = "SELECT * FROM item WHERE item_price = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, price);
			ResultSet rs = ps.executeQuery();
			LinkedList<Item> items = new LinkedList<>();
			
			while(rs.next())
			{
				Item item = new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				items.add(item);
			}
			return items;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Item> findByPriceRange(int priceMin, int priceMax)
	{
		String sql = "SELECT * FROM item WHERE item_price BETWEEN ? AND ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, priceMin);
			ps.setInt(2, priceMax);
			ResultSet rs = ps.executeQuery();
			LinkedList<Item> items = new LinkedList<>();
			
			while(rs.next())
			{
				Item item = new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				items.add(item);
			}
			return items;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWarehouse(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateName(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePrice(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(int[] ids) {
		// TODO Auto-generated method stub
		
	}

}
