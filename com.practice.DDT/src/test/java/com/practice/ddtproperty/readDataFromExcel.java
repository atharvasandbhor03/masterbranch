package com.practice.ddtproperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.RowId;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\report.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh1=wb.getSheet("Sheet1");
		Row r1=sh1.getRow(1);
		Cell c1=r1.getCell(6);
		String cellvalue=c1.getStringCellValue();
		System.out.println(cellvalue);
		wb.close();
	}

}
