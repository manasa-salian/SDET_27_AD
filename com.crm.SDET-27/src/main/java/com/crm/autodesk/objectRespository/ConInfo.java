package com.crm.autodesk.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConInfo {
 @FindBy (xpath="//span[@class='dvHeaderText']")
  private WebElement conVerify;
 
 public ConInfo(WebDriver driver) {
	 
PageFactory.initElements(driver, this);


}

public WebElement getConVerify() {
	return conVerify;
}
	public String ContactVerify() {
		return(conVerify.getText());
	}
}
