package com.crm.autodesk.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectRespository.CreateOrganizationPage;
import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.OrganizationIfo;

public class CreateOrganizationWithMembersOfAndClear  extends BaseClass{
	@Test
	public void createOrganizationWithMembersOfAndClearTest() throws Throwable {
		int rand = jLib.getRanDomNumber();
		
		String excel = eLib.getDataFromExcel("sheet1", 1, 2)+rand;
		String ind=eLib.getDataFromExcel("sheet1", 1, 3);
		String type=eLib.getDataFromExcel("sheet1", 1, 4);
		
		HomePage hp=new HomePage(driver);
		hp.clickOrgLink();
		
	hp.clickLookUpImg();
	CreateOrganizationPage op=new CreateOrganizationPage(driver);
	op.clickOrgNameWithIndustryAndType(excel, ind, type);
	
	OrganizationIfo info=new OrganizationIfo(driver);
	String msg = info.getOrgNameVerifyMsg();
	Assert.assertTrue(msg.contains(excel));
	Reporter.log("worked");
		
	}
}
 