package com.crm.autodesk.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectRespository.CreateOrganizationPage;
import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.LoginPage;
import com.crm.autodesk.objectRespository.OrganizationIfo;
import com.crm.autodesk.objectRespository.OrganizationPage;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class OrgWitIndustryandType extends BaseClass {
	@Test
	public  void orgWithIndusytryandTypeTest() throws Throwable {
		
		int rand = jLib.getRanDomNumber();
		
       String org = eLib.getDataFromExcel("sheet1", 1, 2)+rand;
       String ind = eLib.getDataFromExcel("Sheet1", 1, 3);

		 String type = eLib.getDataFromExcel("Sheet1", 1, 4);

		
	HomePage hp=new HomePage(driver);
	hp.clickOrgLink();
	
			
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnLookUp();
			
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.clickOrgNameWithIndustryAndType(org, ind, type);
		//	Assert.fail();
			
			
		
			OrganizationIfo org1=new OrganizationIfo(driver);
			String indName=org1.indNameVerify();
			SoftAssert sa=new SoftAssert();
			//String industryName = org1.indNameVerify();
			sa.assertTrue(indName.contains(indName));
			Reporter.log("industry created",true);
			
			
			OrganizationIfo org2=new OrganizationIfo(driver);
			String typeName=org2.typeNameVerify();
			sa.assertTrue(typeName.contains(typeName));
			Reporter.log("type  created",true);
			sa.assertAll();
			
			
										
			
			  
	}
	@Test
	public void createOrgDemoTest() {
	System.out.println("working");	
	}
}
