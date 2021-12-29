package com.crm.autodesk.objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganizationsPageToSelectOrganizationName extends WebDriverUtility{ 
	
	//@FindBy(xpath="//a[text()='\"+member_of+\"']")
	//private WebElement clickOnName;
	
	@FindBy(id="search_txt")
	private WebElement typeOrgNameAndSearch;
	
	@FindBy(name="search")
	private WebElement  searchOrgName;
	
	public OrganizationsPageToSelectOrganizationName(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTypeOrgNameAndSearch() {
		return typeOrgNameAndSearch;
	}

	public WebElement getSearchOrgName() {
		return searchOrgName;
	
	}
	
	//public WebElement getClickOnName() {
		//return clickOnName;
	//}

	public void switchToWindowOrg(WebDriver driver,String member_of) {
		switchToWindow(driver,"Accounts");
		typeOrgNameAndSearch.sendKeys(member_of);
		searchOrgName.click();

		//switchToWindowOrg("organizations",driver);
		switchToAlertWindowAndAccept(driver);
		driver.findElement(By.xpath("//a[text()='\\\"+member_of+\\\"']")).click();
		
	}
	

}
