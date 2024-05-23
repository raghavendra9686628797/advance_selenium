package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_MultipleData_from_Excel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	int rowcount = sheet.getLastRowNum();
	for (int i = 1; i <=rowcount; i++) {
		Row row = sheet.getRow(i);
		String first_cell = row.getCell(0).toString();
		String Second_cell=row.getCell(1).toString();
		System.out.println(first_cell+"\t"+Second_cell);
	}
	wb.close();
	
	
	
}
}
