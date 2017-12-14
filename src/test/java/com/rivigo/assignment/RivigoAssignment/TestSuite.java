package com.rivigo.assignment.RivigoAssignment;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite {

	WebDriver driver;
	PageObject poj;
	GenericFunctions generic;

	@BeforeMethod
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "/etc/Common_Resources/drivers/mac/chromedriver/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-fullscreen");
		driver = new ChromeDriver(options);
		generic = new GenericFunctions(driver);
		poj = new PageObject(driver,generic);


	}


	@Test
	public void TC_001_PerformShopping() throws Exception{
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		poj.fill_search_Txt("iphone");
		poj.click_performsearch_Img();
		poj.click_BrandName_Lnk();
	
		Collection<String> minPrice = minimumPrice_SortedArray();
		System.out.println("minPrice"+minPrice);
		driver.get((String)minPrice.toArray()[1]);
		Thread.sleep(5000);
		String priceOnListingPage = poj.getText_priceData_ListingPage();
		System.out.println("price on listing"+priceOnListingPage);
		poj.click_addToCart_Btn();
		String quantityData = poj.getText_quantity();
		String priceInCartText = poj.getText_priceInCart_Txt();
		System.out.println("quantity"+quantityData+"price"+priceInCartText);
		assert priceOnListingPage.equals(priceInCartText) && quantityData.contains("1 item"):"Either price or quantity data is wrong";

	}





	public Collection<String> minimumPrice_SortedArray() throws Exception {

		HashMap<String, String> prices = new HashMap<String, String>();
		for (int j = 1; j < 5; j++) {
			pageScrollToBottomInSlowMotion();
			List<WebElement> allprices = driver.findElements(By.xpath("//span[contains(@class,'a-size-base a-color-price')]"));
			List<WebElement> links = driver.findElements(By.xpath("//span[contains(@class,'a-color-price')]/ancestor::a"));
			for (int i = 0; i < allprices.size(); i++) {
				prices.put(allprices.get(i).getText().toString(), links.get(i).getAttribute("href").toString());
				System.out.println("Prices " + allprices.get(i).getText().toString() + "  Links: "
						+ links.get(i).getAttribute("href").toString());
			}
			allprices.clear();
			links.clear();

			driver.findElement(By.xpath("//span[text()='Next Page']")).click();
			Thread.sleep(5000);


		}
		Thread.sleep(5000);
		System.out.println("total items" + prices.size());

		Map<String, String> sorted = new TreeMap<>(prices);

		for (Map.Entry m : sorted.entrySet()) {
			System.out.println(m.getKey().toString() + " " + m.getValue().toString());
		}
		return sorted.values();
		//driver.get((String) sorted.values().toArray()[1]);
		//Thread.sleep(15000);

	}

	public void pageScrollToBottomInSlowMotion() {
		for (int count = 0;; count++) {
			if (count >= 5) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
			goToSleep(1000);
		}
	}

	public void goToSleep(int TimeInMillis) {
		try {
			Thread.sleep(TimeInMillis);
		} catch (Exception e) {
		}
	}






	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
