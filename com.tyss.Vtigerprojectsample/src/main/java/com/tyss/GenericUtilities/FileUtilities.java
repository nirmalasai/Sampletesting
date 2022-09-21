package com.tyss.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Nirmala
 *
 */

public class FileUtilities {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertyValue(String key) throws IOException
	{
	FileInputStream fileinputstream=new FileInputStream(IConstants.filePath);
	Properties properties=new Properties();
	properties.load(fileinputstream);
	String value=properties.getProperty(key);
	return value;
	}

}
