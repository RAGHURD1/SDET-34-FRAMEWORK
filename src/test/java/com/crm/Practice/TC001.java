package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TC001 {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream("./data/TC001.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("TC001").getRow(1).getCell(0).getStringCellValue();
		Date date = wb.getSheet("TC001").getRow(1).getCell(1).getDateCellValue();
		boolean boo = wb.getSheet("TC001").getRow(1).getCell(2).getBooleanCellValue();
		double num = wb.getSheet("TC001").getRow(1).getCell(3).getNumericCellValue();
		
		System.out.println("data="+ data);
		System.out.println("date="+ date);
		System.out.println("boo="+ boo);
		System.out.println("num="+ num);

	} 

}



