package main.java.com.fishOn.engine;

import java.util.ResourceBundle;

public class ResourceString
{
	private static final String BUNDLE_NAME = "main.java.com.fishOn.engine.resource.resource.message";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private ResourceString()
	{
		
	}
	
	public static String getString(String key)
	{
		try
		{
			return RESOURCE_BUNDLE.getString(key);
		}
		catch (Exception e)
		{
			System.err.println("Couldn't find that string.");
			return "!!!" + key + "!!!";
		}
		
	}
}
