package testcases2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loginpage;
@Test
public class Logintest extends Basetest {
@Test
	public void LoginFailiureTest() {
		//test= report.startTest("LoginFailureTest");
		Loginpage login = new Loginpage();
		login.LoginDetails("xyz@abc.com","Abc@12345");
	
		WebElement ErrorMsg=driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActualMsg = ErrorMsg.getText();  
		String ExpMsg = ("Epic sadface: Username and password do not match any user in this service.");
		
		Assert.assertEquals(ActualMsg,ExpMsg,"Invalid Credentials");
		 //report.endTest(test);
	}


@Test
	public void LoginSuccessTest() {
	Loginpage login = new Loginpage();
	login.LoginDetails("standard_user"," secret_sauce");
	}


@Test
public void LoginSuccessTestExternalDataTest() {
	
	String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
	String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
	
	Loginpage login = new Loginpage();
	login.LoginDetails(UserNameVal,PasswordVal);		
}
}







