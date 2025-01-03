package Modulegeneric_Contact_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class createContact_tc_02withSupportDateTest {

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
		Row r1=sh1.getRow(4);
		Cell c1=r1.getCell(2);
		String lastName=c1.getStringCellValue();
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
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		
		//***************capture system date
		Date dateobj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startdate=sim.format(dateobj);
		
        Calendar cal=sim.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH,30);
        String enddate=sim.format(cal.getTime());
        
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);

		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		//*************verify expected result Start date
		
		String startdateinfo=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(startdateinfo.equals(startdate))
		{
			System.out.println("startDate is Verified:=pass");
		}
		else
		{
			System.out.println("startDate  is not Verified:=fail");

		}
		//*************verify expected result end date

		String enddateinfo=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(enddateinfo.equals(enddate))
		{
			System.out.println("endDate is Verified:=pass");
		}
		else
		{
			System.out.println("endDate  is not Verified:=fail");

		}
		
		
		WebElement adminimg=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
