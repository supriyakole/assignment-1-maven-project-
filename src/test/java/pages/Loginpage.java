package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import testcases2.Basetest;

public class Loginpage {

WebDriver driver = Basetest.driver;
ExtentTest test = Basetest.test;

//==============================Web Element==================================

@FindBy(name = "user-name")
WebElement UserName;

@FindBy(id = "password")
WebElement Password ;

@FindBy(name = "login-button")
WebElement LoginButton ;


 public Loginpage()
 {
 	PageFactory.initElements(driver, this);
 }
 
public void LoginDetails(String UserNameValue,String PasswordValue) {
	
	    UserName.sendKeys("xyz@abc.com");
	    test.log(LogStatus.PASS, "Enter UserName", "Name Entered  successfully");
		Password.sendKeys("Abc@12345");
		test.log(LogStatus.PASS, "Enter Password", "Password Entered successfully");
		LoginButton.click();
		test.log(LogStatus.PASS, "Click on LoginButton", " LoginButton Clicked successfully");
		
}
		
public void UICheck() {
	Assert.assertTrue(UserName.isDisplayed());
}
}




 