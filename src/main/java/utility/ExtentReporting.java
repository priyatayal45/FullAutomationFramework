package utility;

import java.awt.Color;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.reporters.TestHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting implements ITestListener
//we can also extends TestListenerAdapter class instead of ITestListener Interface.

{
    public ExtentHtmlReporter reporter;
	public ExtentReports report;
	public ExtentTest test;
	
	public void onStart(ITestContext context)
	{
	//Reporter
	reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Firstreport.html");
	reporter.config().setDocumentTitle("Fullframework Test Project"); // Title of report
	reporter.config().setReportName("Fullframework Test Automation Report"); // name of the report
	reporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	reporter.config().setTheme(Theme.DARK);//Theme of the report
	//Report
	report = new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("Automation Engineer", "Priya Tayal");
	report.setSystemInfo("Environment", "QA");
	}

	public void onTestSuccess(ITestResult result)
	{
		   
           test=report.createTest(result.getName());
           test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    
	}

	public void onTestFailure(ITestResult result)
	{
        test=report.createTest(result.getName());
        test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
       try {
		test.addScreenCaptureFromPath(Baseclass.takescreenshot());
		test.log(Status.FAIL,result.getThrowable());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       // System.out.println("I am called 4");    
	}

	public void onTestSkipped(ITestResult result)
	{
		test=report.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.GREY));
	}
	public void onFinish(ITestContext context)
	//public void onFinish()
	{
     report.flush();
   //  System.out.println("I am called 5");

	}













}
