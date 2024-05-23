package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
public void waitForPageToLoad(WebDriver driver) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
}
public WebDriver openBrowser(WebDriver driver,String browser) {
	if (browser.equals("chrome")) {
		 driver=new ChromeDriver();
	}
	else if (browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}else if (browser.equals("edge")) {
		driver=new EdgeDriver();
	}else {
		System.out.println("check browser name");
	}
	return driver;
}
public void waitForElenment(WebDriver driver, WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void switchToTabBasedOnUrl(WebDriver driver,String partialurl) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> i = set.iterator();
	while (i.hasNext()) {
		String windowId=i.next();
		driver.switchTo().window(windowId);
		String actualurl=driver.getCurrentUrl();
		if (actualurl.contains(partialurl)) {
			break;
		}
		
	}
}
public void switchToTabBasedOntitle(WebDriver driver,String expectedtitle) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> i = set.iterator();
	while (i.hasNext()) {
		String windowId=i.next();
		driver.switchTo().window(windowId);
		String actualtitle=driver.getTitle();
		if (actualtitle.contains(expectedtitle)) {
			break;
		}
		
	}
}
public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver,String name) {
	driver.switchTo().frame(name);
}
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public void switchToalertAccept(WebDriver driver)
{
driver.switchTo().alert().accept();
}
public void switchToalertCancel(WebDriver driver)
{
driver.switchTo().alert().dismiss();
}
public void Select(WebElement element,String text)
{
Select s=new Select(element);
s.selectByVisibleText(text);
}
public void Select(WebElement element,int index)
{
Select s=new Select(element);
s.selectByIndex(index);
}
public void mouseMoveOnElement(WebDriver driver,WebElement element) {
	Actions a=new Actions(driver);
	a.moveToElement(element).click().perform();
}
public void doubleclick(WebDriver driver,WebElement element) {
	Actions a=new Actions(driver);
	a.doubleClick(element).perform();
}
public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
}

}
