package com.skillstorm.model;

/**
 * This is the item class, which contains the methods to properly 
 * get and set the variables that an item object has.
 * 
 * @author Todd Foreman
 */
public class Item 
{

	/**
	 * The private variables used to hold information 
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
	 * Retrieves the item ID.
	 * @return
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * Sets the item ID.
	 * @param id
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * Retrieves the warehouse ID.
	 * @return
	 */
	public int getWarehouseID()
	{
		return warehouseId;
	}
	
	/**
	 * Sets the warehouse ID.
	 * @param warehouseId
	 */
	public void setWarehouseID(int warehouseId)
	{
		this.warehouseId = warehouseId;
	}
	
	/**
	 * Retrieves the item name.
	 * @return
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Sets the item name.
	 * @param name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Retrieves the item price.
	 * @return
	 */
	public int getPrice() 
	{
		return price;
	}

	/**
	 * Sets the item price.
	 * @param price
	 */
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	/**
	 * Overrides the toString method in the String 
	 * class to print out the retrieved variables from the 
	 * database.
	 */
	@Override
	public String toString() {
		return "Item [ID=" + id + ", Warehouse ID=" + warehouseId + ", Name=" + name + ", Price=" + price + "]";
	}
	
	
}
