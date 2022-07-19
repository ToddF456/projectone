package com.skillstorm.service;

public class URLParserService 
{
	
	public int extractIdFromURL(String url) 
	{
		String[] splitString = url.split("/");
		return Integer.parseInt(splitString[1]);
	}
	
	public String extractStringFromURL(String url)
	{
		String[] splitString = url.split("/");
		return splitString[1];
	}
}
