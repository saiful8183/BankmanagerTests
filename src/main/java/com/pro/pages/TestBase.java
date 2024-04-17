package com.pro.pages;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pro.Utilities.BrowserFactory;
import com.pro.Utilities.ConfigDataProvider;
import com.pro.Utilities.ExcelDataProvider;
import com.pro.Utilities.Util;

public class TestBase {

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;

	public static ExtentReports reports;
	public static ExtentTest extentTest;

	// public static ExtentReports extentReports; // for report and attatch screenshot
	// public static ExtentTest extentTest; // for report and attatch screenshot

	@BeforeSuite
	public void setupSuite() {

		config = new ConfigDataProvider();
		excel = new ExcelDataProvider();

		reports = new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Reports/report.html");
		extentSparkReporter.config().setReportName("My Test..............");

		reports.attachReporter(extentSparkReporter);

		reports.setSystemInfo("OS", System.getProperty("os.name"));

		reports.setSystemInfo("Java version", System.getProperty("java.version"));

		reports =new ExtentReports();
		 ExtentSparkReporter sparkReporter=new
		 ExtentSparkReporter("Reports/report.html"); // screenshot
		 sparkReporter.config().setReportName("Bank Test"); // for report and attatch screenshot
		 reports.attachReporter(sparkReporter); // for report and attatch screenshot

		 reports.setSystemInfo("OS", System.getProperty("os.name")); // for
		// report and attatch screenshot

		 reports.setSystemInfo("Java Version",
		 System.getProperty("java.version")); // for report and attatch
		// screenshot

	}

	@AfterSuite // for report and attatch screenshot
	public void genrateReport() throws Exception { // for report and attatch screenshot
		reports.flush(); // for report and attatch screenshot
		Desktop.getDesktop().open(new File("Reports/report.html")); // for report and attatch screenshot
	}

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName, ITestContext context) {

		driver = BrowserFactory.launchapplication(driver, browserName, config.getUrl());

		 Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities(); //
		// for report and attatch screenshot
		 String device = capabilities.getBrowserName() + "_" + capabilities.getBrowserVersion(); // for report and
		// attatch screenshot
		 String author = context.getCurrentXmlTest().getParameter("author"); // for
		// report and attatch screenshot

		 extentTest = reports.createTest(context.getName()); // for report and attatch// screenshot

		 extentTest.assignAuthor(author); // for report and attatch screenshot
		 extentTest.assignDevice(device); // for report and attatch screenshot

	}

	@AfterTest
	public void Teardown() {

		BrowserFactory.quitBrowser(driver);

	}

	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result, Method m) {
		if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.fail(m.getName() + " failed");

			String screenshotPath = Util.captureScreenshot(driver, m.getName()); // for report and attatch screenshot //
																					// for report and attatch screenshot
			extentTest.addScreenCaptureFromPath(screenshotPath); // for report and attatch screenshot // for report and
																	// attatch screenshot
			Util.captureScreenshot(driver, m.getName());
			extentTest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " passed");

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.skip(m.getName() + " skipped");
		}
		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}


}
