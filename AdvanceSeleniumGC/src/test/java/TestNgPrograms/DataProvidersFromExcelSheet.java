package TestNgPrograms;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProvidersFromExcelSheet {
	@Test(dataProvider = "mobileData")
	public void SearchProductFetchCost(String brand, String model) {
		WebDriver d=new ChromeDriver();
		d.get("https://www.amazon.in/");
		d.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		String price=d.findElement(By.xpath("//span[text()='"+model+"']/../../../../div[3]/div[1]/div/div[1]/div/div[1]/a/span/span[2]/span[2]")).getText();
		System.out.println(price);
		d.quit();
		
	}
	@DataProvider
	public Object[][] mobileData() throws EncryptedDocumentException, IOException{
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getrowcount("product");
		
		Object[][] mobile=new Object[rowcount][2];
		for (int i = 0; i < rowcount; i++) {
			mobile[i][0]=elib.readDataFromExcelFile("product", i+1, 0);
			mobile[i][1]=elib.readDataFromExcelFile("product", i+1, 1);
		}
		
		return mobile;
		
	}
}
