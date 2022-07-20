package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.model.Item;

/**
 * @author Todd Foreman
 * The Item Data Access Object interface contains all of the necessary methods to properly execute CRUD operations.
 */
public interface ItemDAO 
{
	
	public List<Item> findAll();
	public Item findById(int id);
	public Item findByIdAndWarehouseId(int id, int warehouseId);
	public List<Item> findByWarehouseId(int warehouseId);
	public List<Item> findByName(String name);
	public List<Item> findByNameAndWarehouseId(String name, int warehouseId);
	public List<Item> findByPrice(int price);
	public List<Item> findByPriceAndWarehouseId(int price, int warehouseId);
	public List<Item> findByPriceRange(int priceMin, int priceMax);
	public Item save(Item item);
	public void updateWarehouse(Item item);
	public void updateName(Item item); 
	public void updatePrice(Item item);
	public void delete(Item item);
	public void delete(int id);
	public void deleteMany(int[] ids);
	
}
