package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TC002 {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("./data/multiple.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		//Sheet sheet = wb.getSheet("multiple");
		String data = wb.getSheet("multiple").getRow(0).getCell(1).toString();
		String date = wb.getSheet("multiple").getRow(1).getCell(1).toString();
		String boo = wb.getSheet("multiple").getRow(2).getCell(1).toString();
		String num = wb.getSheet("multiple").getRow(3).getCell(1).toString();
		
		
		System.out.println(data);
		}
	}
