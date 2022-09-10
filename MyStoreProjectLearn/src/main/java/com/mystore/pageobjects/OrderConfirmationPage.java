package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class OrderConfirmationPage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong") WebElement orderConfirmMsg;
	
	public OrderConfirmationPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public String ValidateConfirmMessage() {
		//Actions.isDisplayed(driver, orderConfirmMsg);
		String ConfirmMsg=orderConfirmMsg.getText();
		return ConfirmMsg;
		
	}
}
