package com.pro.rough;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * 
 * ExtentReports
 * ExtentSparkReporter
 * ExtentTests
 * Capabilities
 * ITestContext
 * ITestResult
 * Method
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class TwoTest extends TwoTestBase {

	@Test(groups = { "Regression", "Smoke" })
	public void googleTest() {

		extentTest.info("Browser is launched");
	
		driver.get("https://www.google.com/");
		extentTest.info("Url is launched");
		Assert.assertTrue(driver.getTitle().contains("Gogle"));

	}
	@Test(groups = { "Regression", "Sanity" })
	public void FacebookTest() {
	
		extentTest.info("Browser is launched");
	
		
		driver.get("https://www.facebook.com/");
		extentTest.info("Url is launched");
		Assert.assertTrue(driver.getTitle().contains("Facebook"));
	
		
	}

	@Test(groups = { "Regression", "E2E" })
	public void hackerrankTest() {
	
		extentTest.info("Browser is launched");

		
		driver.get("https://www.hackerrank.com/");
		extentTest.info("Url is launched");
		Assert.assertTrue(driver.getTitle().contains("Hacker"));
		
		
		
	/*
	@Test(groups = { "Regression", "Sanity" })
	public void FacebookTest() {
		extentTest.info("Browser is launched");
		extentTest.info("Url is launched");
		
		
		driver.get("https://www.facebook.com/");
		Assert.assertTrue(driver.getTitle().contains("Facebok"));

	}

	@Test(groups = { "Regression", "E2E" })
	public void hackerrankTest() {
		extentTest.info("Browser is launched");
		extentTest.info("Url is launched");
		driver.get("https://www.hackerrank.com/");
		Assert.assertTrue(driver.getTitle().contains("Hacker"));
*/
	}

}
