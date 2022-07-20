package com.skillstorm.model;

/**
 * @author Todd Foreman
 * This is the item class, which contains the methods to properly 
 * get and set the variables that an item object has.
 */
public class Item 
{

	/**
	 * These are the private variables used to hold information 
	 * from the database
	 */
	private int id;
	private int warehouseId;
	private String name;
	private int price;
	
	/**
	 * An empty constructor to be used to generate any Item object
	 */
	public Item() 
	{
		super();
	}

	/**
	 * A constructor that takes the warehouse ID, name, and price, 
	 * mainly for auto incremented item IDs.
	 * @param warehouseId
	 * @param name
	 * @param price
	 */
	public Item(int warehouseId, String name, int price) 
	{
		super();
		this.warehouseId= warehouseId;
		this.name = name;
		this.price = price;
	}

	/**
	 * A full constructor for each variable.
	 * @param id
	 * @param warehouseId
	 * @param name
	 * @param price
	 */
	public Item(int id, int warehouseId, String name, int price) 
	{
		super();
		this.id = id;
		this.warehouseId= warehouseId;
		this.name = name;
		this.price = price;
	}

	/**
	 * This method retrieves the item ID.
	 * @return
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * This method sets the item ID.
	 * @param id
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * This method retrieves the warehouse ID.
	 * @return
	 */
	public int getWarehouseID()
	{
		return warehouseId;
	}
	
	/**
	 * This method sets the warehouse ID.
	 * @param warehouseId
	 */
	public void setWarehouseID(int warehouseId)
	{
		this.warehouseId = warehouseId;
	}
	
	/**
	 * This method retrieves the item name.
	 * @return
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * This method sets the item name.
	 * @param name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * This method retrieves the item price.
	 * @return
	 */
	public int getPrice() 
	{
		return price;
	}

	/**
	 * This method sets the item price.
	 * @param price
	 */
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	/**
	 * This method overrides the toString method in the String 
	 * class to print out the retrieved variables from the 
	 * database.
	 */
	@Override
	public String toString() {
		return "Item [ID=" + id + ", Warehouse ID=" + warehouseId + ", Name=" + name + ", Price=" + price + "]";
	}
	
	
}
