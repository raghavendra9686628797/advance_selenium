package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	WebDriver driver;
@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
private WebElement addOrganizationButton;
@FindBy(name = "search_text")
private WebElement searcheditbox;
@FindBy(id = "bas_searchfield")
private WebElement searchDropdown;
@FindBy(name = "submit")
private WebElement searchbutton;
public OrganizationPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}
public WebElement getSearcheditbox() {
	return searcheditbox;
}
public WebElement getSearchDropdown() {
	return searchDropdown;
}
public WebElement getSearchbutton() {
	return searchbutton;
}
public WebElement getAddOrganizationButton() {
	return addOrganizationButton;
}
public void organizationdd(WebDriver driver,String name) {
	Select s=new Select(searchDropdown);
	s.selectByValue(name);
	
}
}
