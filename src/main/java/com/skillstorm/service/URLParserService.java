package com.skillstorm.service;

/**
 * This is the URLParserService class, which is responsible for allowing 
 * a http request to input a value into the url to execute the respective 
 * query, with either an int or string being accepted.
 * 
 * @author Todd Foreman
 */
public class URLParserService 
{
	
	/**
	 * Takes a url, converts it into a string, and allows 
	 * an int value to be placed after a "\" in the url to be placed 
	 * into a database query method.
	 * @param url
	 * @return
	 */
	public int extractIdFromURL(String url) 
	{
		String[] splitString = url.split("/");
		return Integer.parseInt(splitString[1]);
	}
	
	/**
	 * Takes a url, converts it into a string, and allows 
	 * a String value to be placed after a "\" in the url to be placed 
	 * into a database query method.
	 * @param url
	 * @return
	 */
	public String extractStringFromURL(String url)
	{
		String[] splitString = url.split("/");
		return splitString[1];
	}
}
