package com.crm.autodesk.orgtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectRespository.CreateOrganizationPage;
import com.crm.autodesk.objectRespository.HomePage;
import com.crm.autodesk.objectRespository.OrganizationIfo;

//import sheet.getRow;

public class CreateOrganizationWithEmailOptOut extends BaseClass {

	@Test
	public void CreateOrganizationWithEmailOptOutTest () throws Throwable, IOException {
		
		 int rand = jLib.getRanDomNumber();
		String excel = eLib.getDataFromExcel("sheet1", 1, 2)+rand;
		
		HomePage hp=new HomePage(driver);
		hp.clickOrgLink();
		hp.clickLookUpImg();
		
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
org.clickOnEmailCheckBox(excel);		

OrganizationIfo info=new OrganizationIfo(driver);
String msg=info.getOrgNameVerifyMsg();
Assert.assertTrue(msg.contains(excel));
//String msg = info.getOrgNameVerifyMsg();
/*if(msg.contains(excel)) {
	System.out.println("sucess");
}
else {
	System.out.println("failed");
}  */
Reporter.log("worked",true);

}

 
 
	}


