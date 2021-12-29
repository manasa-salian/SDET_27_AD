package com.crm.autodesk.contact;

import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectRespository.ConInfo;
import com.crm.autodesk.objectRespository.ContactPage;
import com.crm.autodesk.objectRespository.CreateNewContactPage;
import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.LoginPage;

	public class Contact {
	//private static final CharSequence Name = null;

	public static void main(String[] args) throws  Throwable{
		
		
		// create object for libraries
		
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
	    ExcelUtility eLib = new ExcelUtility();
	   FileUtility fLib = new FileUtility();
	   
	  //random
	   
	   int rand = jLib.getRanDomNumber();
		//create the property file
	   String URL = fLib.getPropertyKeyValue("url");
		 String Browser = fLib.getPropertyKeyValue("browser");
		 String UserName = fLib.getPropertyKeyValue("username");
		 String Password = fLib.getPropertyKeyValue("password");
		 
	

	//read data from excel sheet
	
			String con = eLib.getDataFromExcel("Sheet2", 1, 1)+rand;
				 
		 
	WebDriver driver;
	if(Browser.equals("chrome")) {
		driver =new ChromeDriver();
	}
	else if(Browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	else if (Browser.equals("ig")) {
		driver=new InternetExplorerDriver();
	} else {
		driver=new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.get(URL);
	
	 LoginPage lp=new LoginPage(driver);
	  lp.login(UserName, Password);
	  
	  HomePage hp=new HomePage(driver);
		hp.clcikConLink();
		
	  ContactPage cp=new ContactPage(driver);
	  cp.clickCreateContact();
	  
CreateNewContactPage cp1=new CreateNewContactPage(driver);
cp1.createNewContactAndSave(con);
	 
ConInfo cInfo=new ConInfo(driver);
String msg = cInfo.ContactVerify();
if(msg.contains(con)) {
	System.out.println("sucess");
}
else {
	System.out.println("not sucess");
}
hp.mouseOverForSignOut(driver);
}
	 
	
	
	}
	
	

	
	  
	
	
	

	
