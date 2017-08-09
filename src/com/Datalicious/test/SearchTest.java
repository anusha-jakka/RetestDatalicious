package com.Datalicious.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.Datalicious.Config.TestConfig;
import com.Datalicious.POM.GooglePage;
import com.relevantcodes.extentreports.LogStatus;


public class SearchTest extends TestConfig
{
	 
	
	
	@Test
	public void Test01()
	{
		logger=report.startTest("Test01");
		
		GooglePage gp=new GooglePage(driver);
		gp.Search("Datalicious");
		logger.log(LogStatus.INFO, "Google search done");
		
		driver.findElement(By.xpath("//a[contains(text(),'Datalicious: Marketing')]")).click();
		System.out.println(driver.getTitle());
		//Assert page title
		Assert.assertEquals("Datalicious - Google Search", driver.getTitle());
		logger.log(LogStatus.PASS, "Search sucessfull");
	}
	
	@Test
	public void Test02()
	{
		logger=report.startTest("Test02");
		
		GooglePage gp=new GooglePage(driver);
		gp.Search("Datalicious");
		logger.log(LogStatus.INFO, "Google search done");
		
		driver.findElement(By.xpath("//a[contains(text(),'Datalicious: Marketing')]")).click();
		System.out.println(driver.getTitle());
		//Assert page title
		Assert.assertEquals("Datalicious", driver.getTitle());
		logger.log(LogStatus.PASS, "Search sucessfull");
	}
	
	
}
