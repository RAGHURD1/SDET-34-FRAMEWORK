package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddData {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./data/TC001.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("SHEET1");
		Row row = sheet.getRow(2);
		Cell cell = row.createCell(2);
		cell.setCellValue("car");
		
		FileOutputStream fos = new FileOutputStream("./data/TC001.xlsx");
		wb.write(fos);
		wb.close();
	}

}
