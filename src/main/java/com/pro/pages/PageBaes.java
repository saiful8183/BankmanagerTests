package com.pro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBaes {

	WebDriver driver;

	public PageBaes(WebDriver driver) {

		this.driver = driver;

	}

	public void doclick(WebElement elemnet, int waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		wait.until(ExpectedConditions.elementToBeClickable(elemnet)).click();
	}

	public WebElement waitForElement(WebElement elemnet, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.elementToBeClickable(elemnet));

	}

	public void type(WebElement element, String text) {

		element = waitForElement(element, 10);
		element.click();
		element.clear();
		element.sendKeys(text);

	}
	
	
	public void selectFromDropDown(WebElement element, String text) {
		
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	public void MouseOverAction(WebElement element) {
		
	Actions action=new Actions(driver);	
	action.moveToElement(element).click().perform();
		
		
		
	}

}
