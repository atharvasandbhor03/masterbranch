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
		
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\report1.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh1=wb.getSheet("org");
Cell ch1=sh1.getRow(1).createCell(4);
ch1.setCellType(CellType.STRING);
ch1.setCellValue("Pass");

FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\report1.xlsx");
wb.write(fos);
wb.close();
System.out.println("*******done********");
	}

}
