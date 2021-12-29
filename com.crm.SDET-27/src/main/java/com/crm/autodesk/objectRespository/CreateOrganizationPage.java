package com.crm.autodesk.objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationPage  extends WebDriverUtility{

@FindBy(name="emailoptout")
private WebElement emailCheck;
	
@FindBy(name="accountname")
private WebElement orgNameEdt;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
private WebElement clickOnMemebr_ofLookUp;


@FindBy(xpath="themes/images/clear_field.gif")
private WebElement clcikOnClearImg;
	
	@FindBy(name="industry")
	private WebElement clickOnIndustryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement clickOnTypeDropDown;
	
	// initialize
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getEmailCheck() {
		return emailCheck;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getClickOnMemebr_ofLookUp() {
		return clickOnMemebr_ofLookUp;
	}

	public WebElement getClcikOnClearImg() {
		return clcikOnClearImg;
	}

	public WebElement getClickOnIndustryDropDown() {
		return clickOnIndustryDropDown;
	}

	public WebElement getClickOnTypeDropDown() {
		return clickOnTypeDropDown;
	}
	
//business lib
	public void clickOrgName(String orgName) {
		orgNameEdt.sendKeys(orgName);
		//clickOnMemebr_ofLookUp.click();
		
		//clcikOnClearImg.click();
		saveBtn.click();
		
	}
	//business lib for org name with emial check box
	
	public void clickOnEmailCheckBox(String orgName) {
		orgNameEdt.sendKeys(orgName);
		emailCheck.click();
		saveBtn.click();
	}
	
	public void clickOrgNameWithIndustryAndType(String orgName,String industryType,String Type) {
		orgNameEdt.sendKeys(orgName);
		
		toSelectUsingVisibleText(clickOnIndustryDropDown, industryType);
		toSelectUsingVisibleText(clickOnTypeDropDown, Type);
		saveBtn.click();
		
	}
	//public void clickOrgNameWithCont(WebDriver driver,String orgName) {
		//orgNameEdt.sendKeys(orgName);
		//saveBtn.click();
		
		
		
}

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

