package com.crm.autodesk.contact;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
	
	public class OrgtoCon {
	public static void main (String[] args) throws Throwable {
		//property file
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
		 
		
		 //excel org
		 
		 FileInputStream excel1 =new  FileInputStream("./data/Book1.xlsx");
		 Workbook wb=WorkbookFactory.create(excel1);
		Sheet sheet2=wb.getSheet("sheet1");
		Row row1= sheet2.getRow(1);
		String org=row1.getCell(2).getStringCellValue()+rand;
		 
		  //excel con

		String con = eLib.getDataFromExcel("Sheet2", 1, 1);
	
	            WebDriver driver;
	            if(Browser.equals("chrome")) {
	            	driver=new ChromeDriver();
	            }
	            else if(Browser.equals("firefox")) {
	            	driver=new FirefoxDriver();
	            } else {
	            	driver=new ChromeDriver();
	            }
	            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	            driver.get(URL);
	           driver.manage().window().maximize();
	            
	           driver.findElement(By.name("user_name")).sendKeys(UserName);
	           driver.findElement(By.name("user_password")).sendKeys(Password);
	           driver.findElement(By.id("submitButton")).click();
	           driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	         driver.findElement(By.name("accountname")).sendKeys(org);
	         //Thread.sleep(2500);
	         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	         
	         driver.navigate().refresh();
	         driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	         driver.findElement(By.name("lastname")).sendKeys(con);
	         driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	         String parentwindoHandle = driver.getWindowHandle();
			 String parentTitle = driver.getTitle();
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				
				Set<String> child = driver.getWindowHandles();
				System.out.println(child);
				for(String b:child)
				{
					driver.switchTo().window(b);
					if (!(driver.getTitle().equals(parentTitle))) 
					{
						break;
					}	
				}
				
				driver.findElement(By.id("search_txt")).sendKeys(org);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(org)).click();
				driver.switchTo().window(parentwindoHandle);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	            Actions a=new Actions(driver);
	 a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	            
	                      
	  driver.close() ;          
	            
	            
	}
	}

