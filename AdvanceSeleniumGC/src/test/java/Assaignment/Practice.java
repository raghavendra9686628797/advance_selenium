package Assaignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice {
@Test
public void xecelsheet() throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptpractice (2).xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet("product");
	/*
	 * Row r=sh.getRow(1); Cell c1=r.getCell(0);
	 * Cell c2=r.getCell(1); String data= c1.toString()+"\t"+c2.toString();
	 */
	String data=sh.getRow(1).getCell(0).toString()+"\t"+sh.getRow(1).getCell(1).toString();
	
	System.out.println(data);
	
	//WebDriver d=new ChromeDriver();
	Row r=sh.getRow(0);
	int r_count = sh.getLastRowNum();
	int c_count=r.getLastCellNum();
	String data1="";
	for (int i = 0; i <r_count ; i++) 
	{
	for (int j = 0; j < c_count; j++) {
		data1=sh.getRow(i+1).getCell(j).toString();
		System.out.println(data1);
	}
	}
	
	
}
}
