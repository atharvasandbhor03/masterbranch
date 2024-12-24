package Modulegeneric_Contact_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class createContact_tc_03_withOrgTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\ddtpractice.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String BROWSER=pro.getProperty("browser");
		String URL =pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		
		
		//*****************int random num generation
		Random random=new Random();
		int random_num= random.nextInt(1000);
		
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\admin\\Desktop\\report1.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh1=wb.getSheet("contact");
		Row r1=sh1.getRow(7);
		Cell c1=r1.getCell(2);
		String orgname=c1.getStringCellValue()+random_num;
		String contactlastname=r1.getCell(3).getStringCellValue();
		wb.close();
		
		
		
	//	System.out.println(BROWSER+" "+URL+" "+USERNAME+" "+PASSWORD);
		
	/*
	 * Scanner sc=new Scanner(System.in);
	 * System.out.println("enter broweser to be launch"); String
	 * browserscan=sc.next();
	 * 
	 * WebDriver driver=null; if (browserscan.equals("chrome")) { driver=new
	 * ChromeDriver();
	 * 
	 * } else if (browserscan.equals("firefox")) { driver=new FirefoxDriver() ;
	 * 
	 * } else if (browserscan.equals("edge")) { driver=new EdgeDriver ();
	 * 
	 * }
	 */
		
		
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
	//	WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		//*************verify expected result Header msg
		
		String headerInfo=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(headerInfo.contains(orgname))
		{
			System.out.println(orgname+" oragname is created:=pass");
		}
		else
		{
			System.out.println(orgname+" oragname is not created:=fail");

		}
		
		//*****create contact Integration of two module
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactlastname);
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		
		//xpath //input[@name='account_name']/following-sibling::img
		//******************switch to child window
		
		Set<String> set=driver.getWindowHandles();
		Iterator<String> itr=set.iterator();
		while (itr.hasNext()) {
			String windowid = (String) itr.next();
			driver.switchTo().window(windowid);
			
			String acturl=driver.getCurrentUrl();
			if(acturl.contains("module=Accounts"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();//********dynamic xpth
		
		//******************switch to parent window back
		
		Set<String> set1=driver.getWindowHandles();
		Iterator<String> itr1=set1.iterator();
		while (itr1.hasNext()) {
			String windowid1 = (String) itr1.next();
			driver.switchTo().window(windowid1);
			
			String acturl=driver.getCurrentUrl();
			if(acturl.contains("module=Contacts&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		//verify header info
		
		String headerInfo1=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(headerInfo1.contains(contactlastname))
		{
			System.out.println(contactlastname+" oragname is created:=pass");
		}
		else
		{
			System.out.println(contactlastname+" oragname is not created:=fail");

		}
		
		//************* verify expected result Oraganization name
		
		String actorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorgname);
		if(actorgname.trim().equals(orgname))
		{
			System.out.println(orgname+" oragname is created:=pass");

		}
		else
		{
			System.out.println(orgname+" oragname is not created:=fail");

		}
		
		WebElement adminimg=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}


}
