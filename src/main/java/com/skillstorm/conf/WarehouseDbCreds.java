package com.skillstorm.conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * This the Warehouse Database Credentials class, lifted from the 
 * previous Chinook Database Credentials Class created during lecture.
 * 
 * @author Todd Foreman
 */
public class WarehouseDbCreds 
{

	private static WarehouseDbCreds instance;
	private String url;
	private String username;
	private String password;
	
	/**
	 * Loads the JDBC Driver necessary to connect 
	 * to the database, as well as retrieving the information from the 
	 * application.properties file which contains the actual database access information.
	 */
	private WarehouseDbCreds() 
	{
		try 
		{
			// Load it into memory immediately so that I have it
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Read the properties (key/value pairs) from the application.properties
			try (InputStream input = WarehouseDbCreds.class.getClassLoader()
					.getResourceAsStream("application.properties")) 
			{
				// Properties object
				Properties props = new Properties();
				props.load(input); // Load in the file we opened
				
				// Grab out the keys that I want
				this.url = props.getProperty("db.url");
				this.username = props.getProperty("db.username");
				this.password = props.getProperty("db.password");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Lazily initiates an instance when the database 
	 * needs to be contacted (Mostly when the first query is executed).
	 * @return
	 */
	public static WarehouseDbCreds getInstance() 
	{
		if (instance == null) 
		{ 
			// Lazily initialize a connection to the DB
			instance = new WarehouseDbCreds();
		}
		return instance;
	}

	/**
	 * Retrieves the database url.
	 * @return
	 */
	public String getUrl() 
	{
		return url;
	}

	/**
	 * Retrieves the database username.
	 * @return
	 */
	public String getUsername() 
	{
		return username;
	}

	/**
	 * Retrieves the database password.
	 * @return
	 */
	public String getPassword() 
	{
		return password;
	}
	
	
	/**
	 * Opens a connection via a Driver Manager, which 
	 * manages the JDBC driver, and allows the proper database 
	 * properties to be properly parsed.
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
