package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class SearchResultPage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img") WebElement searchResult;
	
	public SearchResultPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public boolean isProductDisplayed() throws InterruptedException {
		//Action.scrollByVisibilityOfElement(ldriver, searchResult);
		
		Thread.sleep(5000);
		return Action.isDisplayed(ldriver, searchResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(ldriver, searchResult);
		return new AddToCartPage(ldriver);
	}
}
