package testcases2;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Basetest {
	public static WebDriver driver;
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	//objects of Extent report
	 public static ExtentReports report;
	 public static ExtentTest test;
	 
@BeforeTest
 public void DataSetUP() throws IOException {
			
			FileInputStream fis = new FileInputStream("exceldata.xlsx");
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheet("Sheet1");	
			//test report
			report = new ExtentReports("ExtentReport.html");
		}
@AfterTest
public void DataTearDown() throws IOException {
			
			wbook.close();
			report.flush();
			report.close();
		}
		
@BeforeMethod
public void setup(Method Method)
	{
	test = report.startTest(Method.getName()); //creating the report in Before method
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		 driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.saucedemo.com/"); //nevigate to website
		driver.manage().window().maximize();  // to maximize the sceen 
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS); //implicit wait 
	
	}
	@AfterMethod
public void TearDown()  {
	report.endTest(test);
	driver.quit(); 
}
}

