package com.skillstorm.model;

public class NotFound 
{

	private String message;
	
	public NotFound() 
	{
		
	}
	
	public NotFound(String message) 
	{
		this.message = message;
	}
	
	public String getMessage() 
	{
		return this.message;
	}
	
	public void setMessage(String message) 
	{
		this.message = message;
	}
}