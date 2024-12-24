package com.practice.ddtproperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedatabacktoexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\\\\\\\Users\\\\\\\\admin\\\\\\\\Desktop\\\\\\\\report.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh1=wb.getSheet("Sheet2");
Cell ch1=sh1.getRow(5).createCell(2);
ch1.setCellType(CellType.STRING);
ch1.setCellValue("5");

FileOutputStream fos=new FileOutputStream("C:\\\\\\\\Users\\\\\\\\admin\\\\\\\\Desktop\\\\\\\\report.xlsx");
wb.write(fos);
wb.close();
System.out.println("*******done********");
	}

}
