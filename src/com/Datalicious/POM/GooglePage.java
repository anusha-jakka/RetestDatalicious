package com.Datalicious.POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage 
{

	WebDriver driver;
	
	@FindBy(css="input#lst-ib")
	private WebElement GoogleSearch;
	
	public GooglePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Search(String SearchText)
	{
		GoogleSearch.sendKeys(SearchText,Keys.ENTER);
	}
}
