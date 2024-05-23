package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data_Based_On_Condition {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("org");
	String expectedData="tc_02",data1="",data2="",data3="";
	boolean flag=false;
	int rowcount = sheet.getLastRowNum();
	for (int i = 0; i <=rowcount; i++) {
		try {
			String data = sheet.getRow(i).getCell(0).toString();
			if (data.equals(expectedData)) {
				flag=true;
				data1=sheet.getRow(i).getCell(1).toString();
				data2=sheet.getRow(i).getCell(2).toString();
				data3=sheet.getRow(i).getCell(3).toString();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	if(flag==true) {
	System.out.println(data1+"\t"+data2+"\t"+data3);
	}else {
		System.out.println(expectedData+" is not available");
	}
	wb.close();
	
	
	
}
}
