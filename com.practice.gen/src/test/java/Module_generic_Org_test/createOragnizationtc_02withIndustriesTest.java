package Module_generic_Org_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

public class createOragnizationtc_02withIndustriesTest {

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
		Sheet sh1=wb.getSheet("org");
		Row r1=sh1.getRow(4);       //*********tc_02**********
		Cell c1=r1.getCell(2);
		String orgname=c1.getStringCellValue()+random_num;
		String industry=r1.getCell(3).toString();
		String type=r1.getCell(4).toString();

		
		//System.out.println(cellvalue);
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
		
		WebElement fir_dd=driver.findElement(By.name("industry"));

		Select sel1=new Select(fir_dd);
		sel1.selectByVisibleText(industry);
		
		WebElement sec_dd=driver.findElement(By.name("accounttype"));

		Select sel2=new Select(sec_dd);
		sel2.selectByVisibleText(type);

		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
	/*	//*************verify expected result Header msg
		
		String headerInfo=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(headerInfo.contains(orgname))
		{
			System.out.println("oragname is created:=pass");
		}
		else
		{
			System.out.println("oragname is not created:=fail");

		}
		
		//************* verify expected result Oraganization name
		
		String actorgname=driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
		if(actorgname.equals(orgname))
		{
			System.out.println("oragname is created:=pass");

		}
		else
		{
			System.out.println("oragname is not created:=fail");

		}
		
		*/
		//*******************verify industries and type info
		String actIndustries=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustries.equals(industry))
		{
			System.out.println("industry name is varified");

		}
		else
		{
			System.out.println("industry name is not varified");

		}
		
		String actType=driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.equals(type))
		{
			System.out.println("type is varified");

		}
		else
		{
			System.out.println("type  is not varified");

		}
		WebElement adminimg=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
