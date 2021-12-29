package com.crm.autodesk.objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
@FindBy(name="lastname")
private WebElement lastNameEdt;

@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
private WebElement clcikOnContactLookup;

@FindBy(name = "search_text")
private WebElement searchOrgTextEdt;

@FindBy(name = "search")
private WebElement searchNowOrgBtn;


@FindBy(xpath="//input[@src=\"themes/images/clear_field.gif\"]")
private WebElement clearOnContact;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtnContact;

//initialize

public CreateNewContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



public WebElement getLastName() {
	return lastNameEdt;
}

public WebElement getClcikOnContactLookup() {
	return clcikOnContactLookup;
}

public WebElement getClearOnContact() {
	return clearOnContact;
}

public WebElement getSaveBtnContact() {
	return saveBtnContact;
}

//business
public void createNewContactAndSave(String conName) {
	lastNameEdt.sendKeys(conName);
	saveBtnContact.click();
	
}

public void CreateContactWithOrg(WebDriver driver, String con,String org)
{
	lastNameEdt.sendKeys(con);
	clcikOnContactLookup.click();
	switchToWindow(driver, "Accounts");
	searchOrgTextEdt.sendKeys(org);
	searchNowOrgBtn.click();
	driver.findElement(By.xpath("//a[text()='"+org+"']")).click();
	switchToWindow(driver, "Contacts");
	saveBtnContact.click();
}

}