package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
//	WebDriver driver;
@FindBy(linkText = "Organizations")
private WebElement organizaton;
@FindBy(linkText = "Contacts")
private WebElement contact;
@FindBy(linkText = "More")
private WebElement morelink;
@FindBy(linkText = "Campaigns")
private WebElement Campaignslink;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminimg;
@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
private WebElement signoutlink;


public HomePage(WebDriver driver){
	PageFactory.initElements(driver, this);
}



public WebElement getOrganizaton() {
	return organizaton;
}



public WebElement getContact() {
	return contact;
}



public WebElement getMorelink() {
	return morelink;
}



public WebElement getCampaignslink() {
	return Campaignslink;
}



public WebElement getAmdinimg() {
	return adminimg;
}



public WebElement getSignoutlink() {
	return signoutlink;
}



public void navigateToCampaigns(WebDriver driver) {
	morelink.click();
	mouseMoveOnElement(driver, Campaignslink);
	
	
	
}
public void logout(WebDriver driver) {
	adminimg.click();
	mouseMoveOnElement(driver, signoutlink);
	
}
}
