package com.pro.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pro.Utilities.BrowserFactory;
import com.pro.Utilities.ExcelDataProvider;
import com.pro.pages.TestBase;
import com.pro.pages.HomePage;

public class HomePageTest extends TestBase {

	
	@Test(groups= {"Regression","Smoke","Sanity"})

	public void TestBankManagerLogin() {

		
		extentTest.info("Browser launched");
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.bankManagerLogin();
		extentTest.info("Loged in as bankmanager");
		
		homepage.setupNewCustomer(excel.getStringData("Customer", 1, 0), excel.getStringData("Customer", 1, 1),
				excel.getStringData("Customer", 1, 2));
		
		extentTest.info("Creat a new customer");
		System.out.println(driver.switchTo().alert().getText());
		Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));

	}

}
