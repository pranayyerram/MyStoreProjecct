package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class OrderSummaryPage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span") WebElement confirmBtn;
	
	public OrderSummaryPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public OrderConfirmationPage ClickOnConfirmBtn() {
		Action.click(ldriver, confirmBtn);
		return new OrderConfirmationPage(ldriver);
	}
}
