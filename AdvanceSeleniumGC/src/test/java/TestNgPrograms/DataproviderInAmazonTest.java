package TestNgPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderInAmazonTest {
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
public Object[][] mobileData(){
	Object[][] mobile=new Object[3][2];
	mobile[0][0]="vivo";
	mobile[0][1]="Vivo T2x 5G (Marine Blue, 128 GB) (6 GB RAM)";
	
	mobile[1][0]="blackberry phone";
	mobile[1][1]="Blackberry Corporation 32GB KEYone 4G LTE Single SIM Smartphone (Silver)";
	mobile[2][0]="iphone";
	mobile[2][1]="Apple iPhone 13 (128GB) - Starlight";
	return mobile;
	
}
}
