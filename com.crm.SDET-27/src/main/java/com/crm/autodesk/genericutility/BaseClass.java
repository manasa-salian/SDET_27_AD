package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.LoginPage;

//import com.crm.autodesk.ObjectRepository.HomePage;
//import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {

		public DataBaseUtility dLib = new DataBaseUtility();
		public FileUtility fLib = new FileUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public  JavaUtility jLib = new JavaUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public WebDriver driver;
		public static WebDriver sdriver;
		
		
		@BeforeSuite(groups= {"smokeSuite","RegressionSuite"})
		public void dbConnection() {
			dLib.connectToDb();
			System.out.println("====Database Connection Successfull====");
	}
		@Parameters("browser")
		@BeforeClass(groups= {"smokeSuite","RegressionSuite"})
		
		public void launchBrowser() throws Throwable {
			//read the data
			String BROWSER = fLib.getPropertyKeyValue("browser");
			String URL = fLib.getPropertyKeyValue("url");
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
				driver = new FirefoxDriver();
			}
			else {
				System.out.println("invalid Browser");
			}
			sdriver=driver;
			wLib.waitForpageToLoad(driver);
			wLib.toMaximizeWindow(driver);
			driver.get(URL);
			System.out.println("====Browser launched=====");
		}
		
		@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
		public void loginToApp() throws Throwable {
			//read the data
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);
			System.out.println("=====Login Success====");
		}
		
		@AfterMethod(groups= {"smokeSuite","RegressionSuite"})
		public void logoutApp() 
		{
			HomePage hp = new HomePage(driver);
			hp.mouseOverForSignOut(driver);
		}
		
		@AfterClass(groups= {"smokeSuite","RegressionSuite"})
		public void closeBrowser() {
			driver.quit();
			System.out.println("=====browser quit====");
		}
		
		@AfterSuite(groups= {"smokeSuite","RegressionSuite"})
		public void closeConnection() {
			dLib.closeDb();
			System.out.println("====browser closed====");
		}
}