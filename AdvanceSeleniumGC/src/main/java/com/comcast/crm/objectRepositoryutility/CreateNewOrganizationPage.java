package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement organizationname;
	@FindBy(name="industry")
	private WebElement industrydropdown;
	@FindBy(name = "accounttype")
	private WebElement type;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebutton;
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganizationname() {
		return organizationname;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public void CreateNewOrganization(WebDriver driver,String name,String industry) {
		organizationname.sendKeys(name);
		Select s=new Select(industrydropdown);
		s.selectByValue(industry);
		savebutton.click();
	}
	public void CreateNewOrganization(WebDriver driver,String name) {
		organizationname.sendKeys(name);
		savebutton.click();
	}
	
}
