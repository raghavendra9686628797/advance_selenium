package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
private WebElement headerTextorganizationName;
@FindBy(id = "dtlview_Organization Name")
private WebElement organizationname;
public OrganizationInfoPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
public WebElement getHeaderTextorganizationName() {
	return headerTextorganizationName;
}
public WebElement getOrganizationname() {
	return organizationname;
}

}
