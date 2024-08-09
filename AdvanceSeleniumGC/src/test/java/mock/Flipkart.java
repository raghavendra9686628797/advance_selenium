package mock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {
@Test
public void mobileNameAndCost() throws EncryptedDocumentException, IOException{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung mobiles",Keys.ENTER);
	List<WebElement> mobile_Names = driver.findElements(By.xpath("//div[@class=\"DOjaWF gdgoEp\"]//div[@class=\"KzDlHZ\"]"));
	List<WebElement> mobile_prices = driver.findElements(By.xpath("//div[@class=\"DOjaWF gdgoEp\"]//div[@class=\"Nx9bqj _4b5DiR\"]"));
	FileInputStream fis=new FileInputStream("./testdata/testscriptpractice (2).xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("fkart");
	
	int row_num = 0;
    for (int i = 0; i < mobile_Names.size(); i++) {
        Row row = s.createRow(row_num++);

        Cell nameCell = row.createCell(0);
        nameCell.setCellValue(mobile_Names.get(i).getText());

        Cell priceCell = row.createCell(1);
        priceCell.setCellValue(mobile_prices.get(i).getText());
    }
	
	FileOutputStream fos=new FileOutputStream("./testdata/testscriptpractice (2).xlsx");
	wb.write(fos);
	wb.close();
}

}
