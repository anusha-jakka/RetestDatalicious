package com.Datalicious.Config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static com.Datalicious.Utility.ScreenshotCapture.*;

public class TestConfig 
{

	String reportPath="E:/Datalicious Project/RetestDatalicious/ExtentReport/Report"+System.currentTimeMillis()+".html";
	public WebDriver driver;
	protected ExtentReports report=new ExtentReports(reportPath);
	protected ExtentTest logger;
	
	@BeforeMethod
	@Parameters({"Url","Browser"})
	public void Launch(String Url,String Browser)
	{
		if(Browser.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Datalicious Project\\Datalicious\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(Url);
			
		}
		else if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.out.println("In Chrome ");
			System.setProperty("webdriver.chrome.driver", "E:\\Datalicious Project\\Datalicious\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(Url);
		}
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		
			String path=captureScreenshot(driver, result.getTestName());
			String img=logger.addScreenCapture(path);
			logger.log(LogStatus.FAIL, "Title comaparision", img);
			
		}
		report.endTest(logger);
		report.flush();
		driver.close();
		
		driver.get(reportPath);
	}
	
}
