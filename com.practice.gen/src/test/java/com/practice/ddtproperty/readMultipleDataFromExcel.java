package com.practice.ddtproperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readMultipleDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\report1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh1=wb.getSheet("Sheet3");
		int Rowcount =sh1.getLastRowNum();
		//System.out.println(Rowcount);
		for(int i=1;i<Rowcount;i++)//till last row
		{
			int cellcount=sh1.getRow(i).getLastCellNum();
			//System.out.println(cellcount);
			for(int j=0;j<cellcount;j++)
			{
				String c1=sh1.getRow(i).getCell(j).getStringCellValue();
//				String c2=sh1.getRow(i).getCell(1).getStringCellValue();
//				String c3=sh1.getRow(i).getCell(2).getStringCellValue();
				System.out.println(c1);
			}
			 

		}

				
			wb.close();
	}

}
