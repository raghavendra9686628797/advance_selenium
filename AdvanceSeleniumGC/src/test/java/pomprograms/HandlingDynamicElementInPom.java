package pomprograms;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.objectRepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryutility.OrganizationPage;

public class HandlingDynamicElementInPom {
	WebDriver d;
	@Test
	public void HandlingDynamic() throws IOException {

		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		javaUtility jlib=new javaUtility();
		WebDriverUtility wlib=new WebDriverUtility();

		String browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String username=flib.getDataFromPropertiesFile("username");
		String password=flib.getDataFromPropertiesFile("password");


		d=wlib.openBrowser(d, browser);
		wlib.maximizeWindow(d);
		d.get(url);
		wlib.waitForPageToLoad(d);

		LoginPage lib=new LoginPage(d);
		lib.getUsernameEdit().sendKeys(username);
		lib.getPasswordEdit().sendKeys(password);
		lib.getLoginbtnEdit().click();

		HomePage hlib=new HomePage(d);
		hlib.getOrganizaton().click();

		OrganizationPage olib=new OrganizationPage(d);
		olib.getAddOrganizationButton().click();
  

		int randnum=jlib.getRandomNumber();

		String orgname=elib.readDataFromExcelFile("org", 1, 2)+randnum;
		String orgtype=elib.readDataFromExcelFile("org", 1, 5);
		String industry=elib.readDataFromExcelFile("org", 1, 4);
		String accountname=elib.readDataFromExcelFile("org", 1, 6);
		CreateNewOrganizationPage cnlib=new CreateNewOrganizationPage(d);
		cnlib.CreateNewOrganization(d, orgname, industry);
		OrganizationInfoPage oilib=new OrganizationInfoPage(d);
		String actualtext=oilib.getHeaderTextorganizationName().getText();
		if (actualtext.contains(orgname)) {
			System.out.println("testcase pass");
		}
		else
		{
			System.out.println();	
		}

		hlib.getOrganizaton().click();
		olib.getSearcheditbox().sendKeys(orgname);
		olib.organizationdd(d, accountname);
		olib=new OrganizationPage(d);
		olib.getSearchbutton().click();
		d.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		wlib.switchToalertAccept(d);




	}
}
