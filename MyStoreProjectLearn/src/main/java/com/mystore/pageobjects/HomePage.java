package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class HomePage extends base{
	
	WebDriver ldriver;
	@FindBy(xpath="//i[@class='icon-heart']") WebElement myWishlistBtn;
	@FindBy(xpath="//i[@class='icon-list-ol']") WebElement orderHistoryBtn;
	
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public boolean ValidateWishlist() {
		return Action.isDisplayed(ldriver, myWishlistBtn);
	}
	
	public boolean ValidateOrderHistory() {
		return Action.isDisplayed(ldriver, orderHistoryBtn);
	}
	
	public String getCurUrl() {
		return Action.getCurrentURL(ldriver);
	}
}
