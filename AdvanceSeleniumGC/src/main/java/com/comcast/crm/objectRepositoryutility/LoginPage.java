package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtnEdit;
	
	public LoginPage(WebDriver driver){
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginbtnEdit() {
		return loginbtnEdit;
	}
	
	public void LoginAction(String username,String password) {
		
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginbtnEdit.click();
	}
}
