package com.rivigo.assignment.RivigoAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunctions {
	WebDriver driver;
	WebDriverWait wait;
	
	public GenericFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public void fill(String xpath, String Value_To_Fill) {
		driver.findElement(By.xpath(xpath)).sendKeys(Value_To_Fill);
	}
	
	public void clear(String string) {
		// TODO Auto-generated method stub
	}
	
	
	public void click(String xPath) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		driver.findElement(By.xpath(xPath)).click();
	}
	
	
	
	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
}
