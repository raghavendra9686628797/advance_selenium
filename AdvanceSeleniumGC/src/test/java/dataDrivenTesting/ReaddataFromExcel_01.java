package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFromExcel_01 {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
//step1:get the excell path location and java object of the physical excel file
FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\TestScriptData.xlsx");
//step2: open work book in read mode
Workbook wb = WorkbookFactory.create(  fis);
//Step3: get the control of org sheet
Sheet sheet_nmae = wb.getSheet("org");
//step4:get the comntrol of the first row
Row row = sheet_nmae.getRow(1);
//step5:get the control of second cell and read the String data
Cell cell = row.getCell(2);
String data = cell.getStringCellValue();
System.out.println(data);
//step6:close the woork book
wb.close();
}
}
