package com.crm.autodesk.orgtest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectRespository.CreateOrganizationPage;
import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.LoginPage;
import com.crm.autodesk.objectRespository.OrganizationIfo;
import com.crm.autodesk.objectRespository.OrganizationPage;


public class CreateOrg extends BaseClass {
	
	@Test
	
	
	 public void createOrgTest() throws Throwable {
		int rand = jLib.getRanDomNumber();
		
		String excel = eLib.getDataFromExcel("sheet1", 1, 2)+rand;
		
	HomePage hp=new HomePage(driver);
	hp.clickOrgLink();
	
	hp.clickLookUpImg();
	
	CreateOrganizationPage op=new CreateOrganizationPage(driver);
	op.clickOrgName(excel);
	//op.getSaveBtn();
	
	OrganizationIfo info=new OrganizationIfo(driver);
	String msg=info.getOrgNameVerifyMsg();
	Assert.assertTrue(msg.contains(excel));
//String msg = info.getOrgNameVerifyMsg();
//if(msg.contains(excel)) {
//System.out.println("org name is same");
//} else {
	//System.out.println("not same");

}
	
		
	}

	


