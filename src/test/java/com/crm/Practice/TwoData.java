package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TwoData {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("./data/RD2.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("VK");
		Row r = sh.getRow(1);
		String fn = r.getCell(0).getStringCellValue();
		String ln = r.getCell(1).getStringCellValue();
		System.out.println(fn);
		System.out.println(ln);
		
	}
}