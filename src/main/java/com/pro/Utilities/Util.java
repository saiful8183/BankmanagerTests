package com.pro.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Util {

/*	
	
public static String captureScreenshot(WebDriver driver, String name) {
		
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh_mm_ss");
		String time = currentTime.format(formatTime);
		
		
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dstn = new File("./ScreenShot/"+name+"_"+time+".png");		
		try {
			Files.copy(src, dstn);
			System.out.println("Screenshot captured");
		} catch (Exception e) {			
			System.out.println("Unable to capture screenshot >> "+ e.getMessage());
		}
		return dstn.getAbsolutePath();
	}
		*/
	
	
	
	
	public static String captureScreenshot(WebDriver driver,String name) {
		
		LocalDateTime currenttime=LocalDateTime.now();
		DateTimeFormatter formattime=DateTimeFormatter.ofPattern("dd-MM-yyyy_hh_mm_ss");
		String time=currenttime.format(formattime);
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./ScreenShot/"+name+"_"+time+".png");
		//File dstn = new File("./ScreenShot/"+name+"_"+time+".png");
		try {
			Files.copy(src, dest);
			System.out.println("screenshot captured");
		} catch (Exception e) {
		
			
			System.out.println("Unable to take screenshot captured"+e.getMessage());
			
			
			
		}
		
		
		return dest.getAbsolutePath();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
























