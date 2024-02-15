package com.pro.rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BankTest {

	
	@Test
	public void testBank() throws InterruptedException {

		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	    
	     //Bank manager login
	       driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
	       //click on add customer button 

	         driver.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();
	         
	         
	         //adding customer details
	         //Add first name
	         driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys("Stephen");
	         //Add last name
	         driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys("Fleming");
	         //Add post code
	         driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys("10008");
	         
	         // clicking on add customer button
	         driver.findElement(By.xpath("//button[@type='submit']")).click();
	         
	       	//Capturing text from  alart
	       	 System.out.println( driver.switchTo().alert().getText());
	       	  
	      	//Accepting alart
	       	  driver.switchTo().alert().accept();
	       	  
	       	  //clicking on home button  button
	       	  driver.findElement(By.xpath("//button[text()='Home']")).click();
	       	  
	       	  
	       	 // clicking on customer login button 
	       	  driver.findElement(By.xpath("//button[contains(text(),'Customer')]")).click();
	       	  
	       	  
	       	  
	       	  //Clicking on customer ID drop down icon
	       	 driver.findElement(By.xpath("//Select[@ng-model='custId']")).click();
	       	  
	       	 
	       	 
	       	 //Selecting Stephen Fleming
	       	Select select=new Select(driver.findElement(By.xpath("//Select[@ng-model='custId']")));
	       	  
	       	select.selectByVisibleText("Stephen Fleming");
	       	  
	       	  
	       	  
	       	  
	      //Clicking on login button 	  
	  	  driver.findElement(By.xpath("//button[text()='Login']")).click();
	  	  
	  	  driver.findElement(By.xpath("//span[text()='Stephen Fleming']")).isDisplayed()  ;	  
	       	Thread.sleep(3000)  ;
	       	driver.quit();
	       	  
	}       	  
	       	  
	       	  
	}    	  
	       	  
	       	  
	       	  
	       	  
	       	  
	       	  
	       	 