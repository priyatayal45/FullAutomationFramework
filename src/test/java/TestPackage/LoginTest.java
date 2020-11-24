package TestPackage;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.Baseclass;
import utility.Logging;
import PagePackage.LoginPage;
import utility.Baseclass;
public class LoginTest extends Baseclass

{

	@Parameters({"username1","password1"})
	@Test
	public void LoginTest1(String username1,String password1) throws InterruptedException

	{
		LoginPage page = new LoginPage(driver);
		page.login(username1,password1,driver);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
		page.logout();
		Logging.loginfo("Test case is passed");
	}
	
	@Test
	@Parameters({"username2","password2"})
	public void LoginTest2(String username2,String password2) throws InterruptedException
	{
		LoginPage page = new LoginPage(driver);
		page.login(username2,password2,driver);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
		page.logout();
		Logging.loginfo("Test case is passed");
		
	}
}