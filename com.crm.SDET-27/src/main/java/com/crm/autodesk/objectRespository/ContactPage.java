package com.crm.autodesk.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement clcikOnLookUpImgOfContact;
	

	@FindBy(name="search_text")
	private WebElement clickonSearchEdtOnContact;
	
	@FindBy(name="submit")
	private WebElement searchBtnOnContact;
	
	//initialize
	
	public ContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

	public WebElement getClcikOnLookUpImgOfContact() {
		return clcikOnLookUpImgOfContact;
	}

	public WebElement getClickonSearchEdtOnContact() {
		return clickonSearchEdtOnContact;
	}

	public WebElement getSearchBtnOnContact() {
		return searchBtnOnContact;
	}

// business lib
	public void clickCreateContact() {
		clcikOnLookUpImgOfContact.click();
	}
	
}
