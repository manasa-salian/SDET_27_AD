package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author DELL
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * 
	 * @throws Throwable
	 */

	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fp = new FileInputStream("./data/data3.properties");
		Properties pObj = new Properties();
		pObj.load(fp);
		
		String value=pObj.getProperty(key);
		return value;
	}

	
	
}
