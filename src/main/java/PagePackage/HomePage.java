package PagePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.Assert;

public class HomePage 

{

	WebDriver driver;
	@FindBy(xpath ="//b[text()=\"Admin\"]")
	WebElement Admin ;

	@FindBy(id="menu_admin_UserManagement")
	WebElement UserMgmt;

	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement Users;

	@FindBy(id="searchSystemUser_userName")
	WebElement usernamebox;   // --- Aaliyah.Haq

	@FindBy(xpath="//input[@id=\"searchBtn\"]")
	WebElement search;

	@FindBy(xpath="//tbody//child :: tr[1]//child :: td[5]")
	WebElement Status;

	@FindBy(xpath="//a[text()=\">\"]")
	WebElement Expand;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String Findstatus(String name,WebDriver driver) throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(Admin).moveToElement(UserMgmt).click(Users).build().perform();
		Thread.sleep(3000);
		action.click(usernamebox).sendKeys(name).click(search).build().perform();
		String status=Status.getText();
		return status;
	}












}
