package com.Datalicious.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCapture 
{

	public static String captureScreenshot(WebDriver driver,String TCName)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest="E:/Datalicious Project/RetestDatalicious/Screenshots"+TCName+System.currentTimeMillis()+"png";
		
		try {
			
			FileUtils.copyFile(src, new File(dest));
			
			} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		
		return dest;
		
	}
}
