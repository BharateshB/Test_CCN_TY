package com.tyss.demo.commonUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {

	public String getvalue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Data/commonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		 String value = pro.getProperty(key);
		 return value;
		
	}
}
