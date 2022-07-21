package com.skillstorm.model;

/**
 * The NotFound class is created as a means to properly parse a String 
 * in the servlet when sending a response, primarily when an item is not 
 * found due the item not existing or an incorrect parameter in a query statement.
 * 
 * @author Todd Foreman
 *
 */
public class NotFound 
{

	private String message;
	
	/**
	 * The basic constructor for NotFound
	 */
	public NotFound() 
	{
		
	}
	
	/**
	 * This constructor takes a message parameter to immediately save a String to a NotFound object.
	 * @param message
	 */
	public NotFound(String message) 
	{
		this.message = message;
	}
	
	/**
	 * Returns the String which was binded in the setMessage
	 *  method or in the NotFound constructor
	 * @return
	 */
	public String getMessage() 
	{
		return this.message;
	}
	
	/**
	 * Allows a String to be passes to assign the message 
	 * variable to the String.
	 * @param message
	 */
	public void setMessage(String message) 
	{
		this.message = message;
	}
}