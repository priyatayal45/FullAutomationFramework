package PagePackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{

	WebDriver pagedriver;
	@FindBy(xpath = "//input[@id=\"txtUsername\"]")
	static WebElement username;

	@FindBy(xpath = "//input[@id=\"txtPassword\"]")
	static WebElement password;

	@FindBy(id="btnLogin")
	static WebElement loginbutton;
	
    @FindBy(xpath="//a[@id=\"welcome\"]")
    static WebElement welcome;
    
    @FindBy(xpath="//a[text()=\"Logout\"]")
    static WebElement logout;
    

	
	public LoginPage(WebDriver driver)
	{ 
		pagedriver=driver;
		PageFactory.initElements(driver, this); 
	} 

	public  HomePage login(String username1, String password1,WebDriver driver) throws InterruptedException
	{
		username.sendKeys(username1);
		password.sendKeys(password1);
		loginbutton.click();
		return new HomePage(driver);
	}  
	public void logout()
	{
		welcome.click();
		logout.click();
	}
	
}
