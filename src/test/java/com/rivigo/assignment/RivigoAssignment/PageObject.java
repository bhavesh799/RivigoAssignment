package com.rivigo.assignment.RivigoAssignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PageObject {

	WebDriver driver;
	GenericFunctions generic;

	public PageObject(WebDriver driver, GenericFunctions generic){
		this.driver = driver;
		this.generic = generic;

	}

	private String search_Txt = "//input[@id = 'twotabsearchtextbox']";
	private String Performsearch_Img = "(//input[@class= 'nav-input'])[1]";
	private String BrandName_Lnk = "//*[@id='leftNavContainer']/ul[5]/div/li[1]/span/span/div/label/span/span";
	private String Price_Txt = "//*[@id='result_21']/div/div[4]/div[1]/a/span[2]";//"//span[@class = 'a-size-base a-color-price s-price a-text-bold']";
	private String NextPage_Lnk = "//span[@id = 'pagnNextString']";
	private String priceData = "//span[@class = 'a-size-large a-color-price olpOfferPrice a-text-bold']/span";//"(//span[@class = 'a-size-large a-color-price olpOfferPrice a-text-bold']/span/span)[2]";
	private String addToCart_Btn = "//input[@class = 'a-button-input']";
	private String quantity = "(//span[@class = 'a-size-medium a-align-center huc-subtotal']/span)[1]";
	private String priceInCart_Txt = "(//span[@class = 'a-color-price hlb-price a-inline-block a-text-bold']/span)[1]";




	public String getText_priceInCart_Txt(){
		return generic.getText(priceInCart_Txt);
	}


	public String getText_quantity(){
		return generic.getText(quantity);
	}

	public void click_addToCart_Btn(){
		generic.click(addToCart_Btn);
	}

	public String getText_priceData_ListingPage(){
		return generic.getText(priceData);
	}

	public String getText_Price_Txt(){
		return generic.getText(Price_Txt);}


	public void click_NextPage_Lnk(){
		generic.click(NextPage_Lnk);
	}


	public void click_BrandName_Lnk(){
		generic.click(BrandName_Lnk);
	}

	public void fill_search_Txt(String inputdata){
		//		if(inputdata.trim().length()==0){
		//		clear_search_Txt();return;}
		//		generic.fill(search_Txt,inputdata);

		WebElement element= driver.findElement(By.xpath(search_Txt));
		//element.clear();
		element.click();
		element.sendKeys("iphone");

	}

	public  void clear_search_Txt(){
		generic.clear(search_Txt);
	}

	public  void click_search_Txt(){
		generic.click(search_Txt);
	}

	public String getText_search_Txt(){
		return generic.getText(search_Txt);}


	public void click_performsearch_Img(){
		driver.findElement(By.xpath(Performsearch_Img)).click();
	}
}
