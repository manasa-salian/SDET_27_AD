package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectRespository.ContactPage;
import com.crm.autodesk.objectRespository.CreateNewContactPage;
import com.crm.autodesk.objectRespository.CreateOrganizationPage;
import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.LoginPage;
import com.crm.autodesk.objectRespository.OrganizationIfo;
import com.crm.autodesk.objectRespository.OrganizationPage;

public class OrgWithCon1  extends BaseClass{
	@Test
	
	public void orgWithCon1Test() throws Throwable, IOException {
		

	//rand
	  int rand = jLib.getRanDomNumber();
		 
		String org = eLib.getDataFromExcel("sheet1", 1, 2)+rand;
	
		 String con = eLib.getDataFromExcel("Sheet2", 1, 1)+rand;
			HomePage hp=new HomePage(driver);
			hp.clickOrgLink();
			
			hp.clickLookUpImg();
	 
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnLookUp();
		
		//CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		//cop.clickOrgNameWithContact(driver, org);
		
		CreateOrganizationPage op1 = new CreateOrganizationPage(driver);
		op1.clickOrgName(org);
		

		OrganizationIfo org1=new OrganizationIfo(driver);
		String msg = org1.getOrgNameVerifyMsg();
						
		Assert.assertTrue(msg.contains(org));
		Reporter.log("worked");
					
					WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
				      wLib.waitForElementToBeClickable(driver, headerWb);
				      
				     hp.clcikConLink();
				     
				     ContactPage cp=new ContactPage(driver);
					  cp.clickCreateContact();
		
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.CreateContactWithOrg(driver, con, org);
		
					
			
					
				
}
}

	  
	

