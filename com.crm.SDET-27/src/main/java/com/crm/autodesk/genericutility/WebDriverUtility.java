package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility { 
	/**
	 * wait for the page to load for identifying and synchronized element in DOM
	 * @param driver
	 */

public void waitForpageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
} 
/**
 * wait for the page to load before identifying any asynchronized [java script actions] element in DOM
 * @param driver
 */
	

public void waitForPageToLoadForJSElement(WebDriver driver) {
	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	
} 
/**
 * used for element to be clickable in GUI , &check for specific for specific element for every 500 milli seconds
 * @param driver
 * @param element
 */

public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * used to wait for the element to be clickable in GUI, &check for specific element for every 500 milli seconds
 * @param driver
 * @param element
 * @param pollingTime
 * @throws InterruptedException 
 */

public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element,int pollingTime) throws Throwable {
	FluentWait wait = new FluentWait(driver);
	
	wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
	wait.wait(20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * used to switch any window based on window title
 * @param driver
 * @param partialWindowTitle
 */


public void switchToWindow(WebDriver driver, String partialWindowTitle) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	
	while(it.hasNext()) {
		String wId=it.next();
		driver.switchTo().window(wId);
		String currentWindowTitle = driver.getTitle();
		if(currentWindowTitle.contains(partialWindowTitle)) {
			break;
		}
		
	}
}
/**
 * to clcik on accept in alert popup
 * @param driver
 */

public void switchToAlertWindowAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * to clcik on cancel in alert popup
 * @param driver
 */
public void switchToAlertWindowAndClickOnCancel(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * to switch to frames
 * @param driver
 */

public void switchToFrames( WebDriver driver, int index) {
	driver.switchTo().frame(index);
}
/**
 * switching frame using id attribute
 * @param driver
 * @param id_name_attribute
 */

public void switchToFrame(WebDriver driver, String id_name_attribute) {
	driver.switchTo().frame(id_name_attribute);
}
/**
 * used to select value from dropdown based on index 
 * @param ele
 * @param index
 */

public void toSlectUsingIndex(WebElement ele,int index) {
	Select s=new Select(ele);
	s.selectByIndex(index);
}

/**
 * used to slecet value form the dropw down based value/option from teh GUI
 * @param ele
 * @param text
 */

public void toSelectUsingVisibleText(WebElement ele, String text) {
	Select s=new Select(ele);
	s.selectByVisibleText(text);
}

public void toMaximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * used to hover on the element
 * @param driver
 * @param element
 */

public void toMouseHover(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}


/**
 * right click on the element
 * @param driver
 * @param element
 */
public void rightClickOnElement(WebDriver driver, WebElement element) {
Actions act=new Actions(driver);
act.contextClick(element).perform();
}
/**
 * 
 * @param driver
 * @param JavaScript
 */

public void executeJavaScript(WebDriver driver,String JavaScript) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeAsyncScript(JavaScript, null);
	
} 


public void waitAndClick(WebElement element) throws Throwable {
	int count=0;
	while(count<20) {
		try {
			element.click();
			break;
		}catch(Throwable e) {
			Thread.sleep(1000);
			count++;
		}
	}
}
/**
 * to take screen shot
 * @param driver
 * @param screenShotName
 * @throws Throwable
 */

public void takeScreenShot(WebDriver driver, String screenShotName) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot)driver;
	
	File src = ts.getScreenshotAs(OutputType.FILE);
    File dest = new File("./screenshot/"+screenShotName+".PNG");
    Files.copy(src, dest);
}
/**
 * pass enter key appertain in to browser
 * @param driver
 */

public void passEntryKey(WebDriver driver) {
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
}
