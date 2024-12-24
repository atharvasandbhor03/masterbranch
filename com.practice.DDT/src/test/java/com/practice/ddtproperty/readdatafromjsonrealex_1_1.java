package com.practice.ddtproperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class readdatafromjsonrealex_1_1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		
	//	***************READ DATA FROM JSON FILE ******************


		JSONParser p1=new JSONParser();
		Object obj=p1.parse(new FileReader("C:\\Users\\admin\\Desktop\\readjson.json"));
		
		JSONObject jsondata=(JSONObject) obj;
		String URL=(String) jsondata.get("url");
		String BROWSER=(String) jsondata.get("browser");
		String USERNAME=(String) jsondata.get("username");
		String PASSWORD= (String) jsondata.get("password");
		
		
		//*****************int random num generation
				Random random=new Random();
				int random_num= random.nextInt(1000);
				
				
				FileInputStream fis1=new FileInputStream("C:\\Users\\admin\\Desktop\\report.xlsx");
				Workbook wb=WorkbookFactory.create(fis1);
				Sheet sh1=wb.getSheet("Sheet3");
				Row r1=sh1.getRow(1);
				Cell c1=r1.getCell(3);
				String orgname=c1.getStringCellValue()+random_num;
				//System.out.println(cellvalue);
				wb.close();
		
		
		WebDriver driver=null;
		if (BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();

		}
		else if (BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver() ;

		}
		else if (BROWSER.equals("edge")) {
			 driver=new EdgeDriver ();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		WebElement adminimg=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
