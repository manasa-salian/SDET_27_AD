package com.crm.autodesk.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationIfo {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgNameVerify;
	
	@FindBy(id="mouseArea_Email Opt Out")
	private WebElement emailVerify;

@FindBy(id="mouseArea_Industry")	
private WebElement indVerify;

@FindBy(id="mouseArea_Type")
private WebElement typeVerify;

//iniotialize
public OrganizationIfo(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getOrgNameVerify() {
	return orgNameVerify;
}

public WebElement getEmailVerify() {
	return emailVerify;
}

public WebElement getIndVerify() {
	return indVerify;
}

public WebElement getTypeVerify() {
	return typeVerify;
}
	
//lib
public String getOrgNameVerifyMsg() {
	return(orgNameVerify.getText());
}
public String indNameVerify() {
	return(indVerify.getText());
}
public String typeNameVerify(){
	return(typeVerify.getText());
}
public String getEmailVerifyMsg(){
	return(emailVerify.getText());
}

}
