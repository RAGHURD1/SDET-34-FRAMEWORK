package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.comcast.genericutility.ExcelUtility;

public class ReadAllRowData {

	public static void main(String[] args) throws Throwable {
		ExcelUtility eil = new ExcelUtility();
		eil.getRowCount("Sheet1");
		
		// FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
		 //open the workbook in read mode
		 //Workbook wbk = WorkbookFactory.create(fis);
		 //get the control of the sheet1
		 //Sheet sh = wbk.getSheet("Sheet1");
		 //get the last used row
		//int count = sh.getLastRowNum();
		// for(int i=1;i<count;i++)
		 {
			//Row row = sh.getRow(i);
		//String firstcolData = row.getCell(0).getStringCellValue();
		//String secondcolData = row.getCell(1).getStringCellValue();
		//System.out.println(firstcolData + "/t" + secondcolData);
			 
		 }
	
	}

}
