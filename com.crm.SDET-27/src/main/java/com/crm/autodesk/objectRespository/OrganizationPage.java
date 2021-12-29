package com.crm.autodesk.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility{
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement clcikOnLookUpImg;


	@FindBy(name="search_text")
	private WebElement clickonSearchEdt;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	//initialize
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getClcikOnLookUp() {
		return clcikOnLookUpImg;
	}

	

	public WebElement getClickonSearchEdt() {
		return clickonSearchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	//business libaraies
	public void clickOnLookUp() {
		clcikOnLookUpImg.click();
		
	}
	
	
	
	
}
