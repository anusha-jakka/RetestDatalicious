package com.Datalicious.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Demo {
	
	WebDriver driver;
	
	
	@Test(enabled=false)
	public void testlaunch()
	{
		String Url="http://www.xebia.in";
		//String Browser="FF";
		System.out.println("In Chrome ");
		//System.setProperty("webdriver.chrome.driver", "E:\\Datalicious Project\\Datalicious\\drivers\\chromedriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(Url);
		
		
		
		//move to services menu
		Actions act=new Actions(driver);
		WebElement service=driver.findElement(By.xpath("//li[@class='services']"));
		act.moveToElement(service).perform();
		List<WebElement> elements=driver.findElements(By.xpath("//li[@class='services']/div/div[@class='sub-nav']/h2/a"));
		for(WebElement tag: elements )
		{
			
			System.out.println("List : "+tag.getText());
		}
		
		
	}
	
	@Test(enabled=false)
	public void fileUpload()
	{
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/upload");
		
		
		WebElement upload=driver.findElement(By.id("file-upload"));
		
		upload.sendKeys("C:\\Users\\Anusha Jakka\\Desktop\\Capture.PNG");
		driver.findElement(By.id("file-submit")).click();
		
		
	}
	
	@Test
	public void Tooltipcheck()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.flipkart.com");
		WebElement tooltip=driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[1]/a/img"));
		System.out.println("$$$$:"+tooltip.getAttribute("title")+"$$$"+tooltip.getLocation());
		driver.quit();
	}

	/*public static void main(String[] args) 
	{
		File firebug = new File(System.getProperty("user.dir") + "\\resources\\firebug-1.10.6.xpi");
		File netExport = new File(System.getProperty("user.dir") + "\\resources\\netExport-0.9b3.xpi");

		FirefoxProfile profile = new FirefoxProfile();
		try {
		profile.addExtension(firebug);
		profile.addExtension(netExport);
		} catch (IOException e) 
		{
		System.out.println("in exception");	
		e.printStackTrace();
		}
		
		//Setting Firebug preferences
		profile.setPreference("extensions.firebug.currentVersion", "2.0");
		profile.setPreference("extensions.firebug.addonBarOpened", true);
		profile.setPreference("extensions.firebug.console.enableSites", true);
		profile.setPreference("extensions.firebug.script.enableSites", true);
		profile.setPreference("extensions.firebug.net.enableSites", true);
		profile.setPreference("extensions.firebug.previousPlacement", 1);
		profile.setPreference("extensions.firebug.allPagesActivation", "on");
		profile.setPreference("extensions.firebug.onByDefault", true);
		profile.setPreference("extensions.firebug.defaultPanelName", "net");

		// Setting netExport preferences
		profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
		profile.setPreference("extensions.firebug.netexport.autoExportToFile", true);
		profile.setPreference("extensions.firebug.netexport.Automation", true);
		profile.setPreference("extensions.firebug.netexport.showPreview", false);
		profile.setPreference("extensions.firebug.netexport.defaultLogDir", "C:\\workspace\\CaptureNetworkTraffic");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);

		WebDriver driver = new FirefoxDriver(capabilities);
		try {
			Thread.sleep(10000);
			driver.get("http://www.google.com");
			Thread.sleep(10000);
			} catch(InterruptedException ie) {
			ie.printStackTrace();
			}
			driver.quit();

	}
*/
}
