package pomprograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HandlingStaleElementReferanceException {
@FindBy(name="user_name")
WebElement username;
@FindBy(name="user_password")
WebElement password;
@FindBy(id="submitButton")
WebElement loginbtn;
@Test
public void login() {
	 WebDriver d=new ChromeDriver();
	 d.manage().window().maximize();
	 d.get("http://localhost:8888");
	HandlingStaleElementReferanceException h = PageFactory.initElements(d, HandlingStaleElementReferanceException.class);
		h.username.sendKeys("admin");
		h.password.sendKeys("admin");
		d.navigate().refresh();
		h.username.sendKeys("admin");
		h.password.sendKeys("admin");
		h.loginbtn.click();
}
}
