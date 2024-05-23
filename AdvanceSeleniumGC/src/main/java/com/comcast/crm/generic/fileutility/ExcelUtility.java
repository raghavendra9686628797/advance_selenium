package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String readDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptpractice (2).xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	wb.close();
	return data;
}
public int getrowcount(String sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptpractice (2).xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rowcount=wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return rowcount;
}
public void setDataToExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptpractice (2).xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
	FileOutputStream fos=new FileOutputStream("./testdata/testscriptpractice (2).xlsx");
	wb.write(fos);
	wb.close();	
} 
}
