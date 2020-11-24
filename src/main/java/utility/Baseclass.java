package utility;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Baseclass 

{
	public static WebDriver driver;


	@BeforeTest
	public void beforeverytest()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}


	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	public static String takescreenshot() throws IOException

	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination= "C:\\\\Users\\\\LENOVO\\\\eclipse-workspace\\\\Framework\\\\Utilities\\\\failed.jpg";
		File dest = new File ("C:\\Users\\LENOVO\\eclipse-workspace\\Framework\\Utilities\\failed.jpg");
		FileUtils.copyFile(src,dest);
		return destination;
	}


}
