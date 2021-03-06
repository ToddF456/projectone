package com.skillstorm.daos;

import java.sql.Array;
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

/**
 * This is the MySQLDAOImpl class, which implements the various methods from the 
 * interface ItemDAO to create methods which query the database.
 * 
 * @author Todd Foreman
 */
public class MySQLItemDAOImpl implements ItemDAO{
	
	/**
	 * Finds each row within the items table, the main table for this warehouse.
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
	 * Finds an item based on it's specific item ID.
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
	 * Finds an item based on it's specific item ID and warehouse ID.
	 */
	@Override
	public Item findByIdAndWarehouseId(int id, int warehouseId) 
	{
		String sql = "SELECT * FROM item WHERE item_id = ? AND warehouse_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, warehouseId);
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
	 * Lists all of the items located in the respective warehouse using the warehouse ID.
	 */
	@Override
	public List<Item> findByWarehouseId(int warehouseId) 
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
	 * Lists all of the items which have the specified name in the parameter.
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
	 * Lists all of the items within a specific warehouse.
	 */
	@Override
	public List<Item> findByNameAndWarehouseId(String name, int warehouseId) 
	{
		String sql = "SELECT * FROM item WHERE item_name = ? AND warehouse_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, warehouseId);
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
	 * Lists all of the items which have the specified price in the parameter
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
	
	/**
	 * Lists all of the items within a specific warehouse.
	 */
	@Override
	public List<Item> findByPriceAndWarehouseId(int price, int warehouseId) 
	{
		String sql = "SELECT * FROM item WHERE item_price = ? AND warehouse_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, price);
			ps.setInt(2,  warehouseId);
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
	 * Lists items within a specified price range.
	 */
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

	/**
	 * Creates a new item in the database, allowing the user to
	 * add the item to any warehouse, set the name of the item, and the price of the item.
	 */
	@Override
	public Item save(Item item) 
	{
		String sql = "INSERT INTO item (warehouse_id, item_name, item_price) VALUES (?, ?, ?)";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, item.getWarehouseID());
			ps.setString(2, item.getName());
			ps.setInt(3, item.getPrice());
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected != 0)
			{
				ResultSet keys = ps.getGeneratedKeys();
				conn.commit();
			} 
			else 
			{
				conn.rollback();
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Changes which warehouse the item is currently occupying.
	 */
	@Override
	public void updateWarehouse(Item item) 
	{
		String sql = "UPDATE item SET warehouse_id = ? Where item_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getWarehouseID());
			ps.setInt(2, item.getId());
			
			int rowAffected = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Changes the name of an item.
	 */
	@Override
	public void updateName(Item item) 
	{
		String sql = "UPDATE item SET item_name = ? Where item_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setInt(2, item.getId());
			
			int rowAffected = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Changes the price of an item.
	 */
	@Override
	public void updatePrice(Item item) 
	{
		String sql = "UPDATE item SET item_price = ? Where item_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getPrice());
			ps.setInt(2, item.getId());
			
			int rowAffected = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an item from the database.
	 */
	@Override
	public void delete(Item item) 
	{
		String sql = "DELETE FROM item WHERE item_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, item.getId());
			
			int rowAffected = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an item from the database based on the item id.
	 */
	@Override
	public void delete(int id) 
	{
		String sql = "DELETE FROM item WHERE item_id = ?";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			int rowAffected = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Deletes multiple items from a database, by using 
	 * an array of item id's to delete them.
	 */
	@Override
	public void deleteMany(int[] ids) 
	{
		try(Connection conn = WarehouseDbCreds.getInstance().getConnection())
		{
			for(int id:ids)
			{
				String sql = "DELETE FROM item WHERE item_id = " + id;
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				conn.commit();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
