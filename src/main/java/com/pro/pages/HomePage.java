package com.pro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBaes {

	
	  WebDriver driver;
	  
	  public HomePage(WebDriver driver) {
	  
	 // this.driver = driver;
	  super(driver);
	  }
	  
	  @FindBy(xpath = "//button[@ng-click='manager()']")
	  
	  public WebElement managerLoginButton;
	  
	  @FindBy(xpath = "//button[@ng-class='btnClass1']")
	  
	  public WebElement AddCustomerBtn;
	  
	  @FindBy(xpath = "//input[@ng-model='fName']")
	  
	  public WebElement FirstName;
	  
	  @FindBy(xpath = "//input[@ng-model='lName']")
	  
	  public WebElement LastName;
	  
	  @FindBy(xpath = "//input[@ng-model='postCd']")
	  
	  public WebElement PostCode;
	  
	  @FindBy(xpath = "//button[@type='submit']")
	  
	  public WebElement addCustomer;
	  
	  public void bankManagerLogin() {
	  
		  
		  doclick(managerLoginButton, 5);
	 // managerLoginButton.click();
	  
	  }
	  
	  public void setupNewCustomer(String firstName, String lastName, String
	  zipcode) {
	  
		  doclick(AddCustomerBtn, 1);
	 // AddCustomerBtn.click();
	  
		  type(FirstName, firstName);
	 // FirstName.sendKeys(firstName);
		  type(LastName, lastName);
	  //LastName.sendKeys(lastName);
		  type(PostCode, zipcode);
	  //PostCode.sendKeys(zipcode);
		  doclick(addCustomer, 2);
	  //addCustomer.click();
		  }
	 

	

}
