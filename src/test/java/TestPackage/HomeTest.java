package TestPackage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PagePackage.HomePage;
import PagePackage.LoginPage;
import utility.Baseclass;

public class HomeTest extends Baseclass

{
	@Parameters("name")
	@Test
	public void searchtestforactive(String name) throws InterruptedException
	{
		LoginPage lpage = new LoginPage(driver);
		HomePage page=lpage.login("Admin", "admin123", driver);
		String status=page.Findstatus(name,driver);
		lpage.logout();
		Assert.assertEquals(status ,"Active");

	}

	@Parameters("name")
	@Test
	public void searchtestforenabled(String name) throws InterruptedException 
	{
		LoginPage lpage = new LoginPage(driver);
		HomePage page=lpage.login("Admin", "admin123", driver);
		String status=page.Findstatus(name,driver);
		lpage.logout();
		Assert.assertEquals(status ,"Enabled"); 
		}

}
