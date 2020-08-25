package com.odoo.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class ExcelLib {
	String value;
	String filePath;
	
	public ExcelLib(String filePath) {
		this.filePath=filePath;
	}
	
	public String readData(String sheetName, int row, int cell) {
	
		try {
		
		FileInputStream fis= new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		
		Cell c1=wb.getSheet(sheetName).getRow(row).getCell(cell);
		
		switch(c1.getCellType()) {
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(c1)) {
				SimpleDateFormat sdf= new SimpleDateFormat("DD-MMM-YYY");
				value= sdf.format(c1);
				
				
			}
			else {
				long num= (long )c1.getNumericCellValue();
				value=""+num;
				
			}
			break;
		case STRING:
			value= c1.getStringCellValue();
			break;
		default:
			break;
		}
		}
		catch(EncryptedDocumentException e)
		{
			Reporter.log(e.getMessage(),true);
		}
		catch(IOException e)
		{
			Reporter.log(e.getMessage(),true);
		}
		return value;
		
		
		
	}
	

}
