package com.crm.autodesk.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;
public class HomePage extends WebDriverUtility{
@FindBy(linkText="Organizations")
	private WebElement orgLink;


@FindBy(xpath="//a[@href='index.php?module=Home&action=index']s")
private WebElement homeClick;

@FindBy(linkText="Contacts")
private WebElement conLink;

@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement clickLookUp;


@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
private WebElement adminImg;

@FindBy(linkText="Sign Out")
private WebElement signOut;

//initiLize
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//utilization

public WebElement getOrgLink() {
	return orgLink;
}

public WebElement getConLink() {
	return conLink;
}


public WebElement getHomeClick() {
	return homeClick;
}

public WebElement getAdminImg() {
	return adminImg;
}


public WebElement getSignOut() {
	return signOut;
}

public WebElement getClickLookUp() {
	return clickLookUp;
}

//business lib for org click
public void clickOrgLink() {
	orgLink.click();
}
//business lib for contact clcik
public void clcikConLink() {
	conLink.click();
}
//business lib for home click

public void clickLookUpImg() {
	clickLookUp.click();
}

//business lib for signout

public void mouseOverForSignOut(WebDriver driver) {
	toMouseHover(driver,adminImg);
	signOut.click();
	
}

}