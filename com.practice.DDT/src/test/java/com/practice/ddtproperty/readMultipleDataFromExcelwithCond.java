package com.practice.ddtproperty;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readMultipleDataFromExcelwithCond {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\admin\\\\Desktop\\\\report.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh1=wb.getSheet("Sheet4");
		String expecttc="tc_02";
		String c2="";
		String c3="";
		String c4="";
		String matchtcdata="";

		int Rowcount =sh1.getLastRowNum();
		boolean flag=false;
		System.out.println(Rowcount);
		for(int i=0;i<Rowcount;i++)//till last row
		{
			int cellcount=sh1.getRow(i).getLastCellNum();
			System.out.println(cellcount);
			String c1="";

			try {
				c1=sh1.getRow(i).getCell(0).getStringCellValue();
System.out.println(c1);
			if(c1.equals(expecttc)) {
				flag=true;
				 c2=sh1.getRow(i).getCell(1).getStringCellValue();
				 c3=sh1.getRow(i).getCell(2).getStringCellValue();
				 c4=sh1.getRow(i).getCell(3).getStringCellValue();

			} 
			
			}catch (Exception e) {
				// TODO: handle exception
			}

		}
		
		if(flag==true)
		{
			System.out.println(c2+" "+c3+" "+c4);
 
		}
		else {
			System.out.println("not found");
		}
				
			wb.close();
	}

}
