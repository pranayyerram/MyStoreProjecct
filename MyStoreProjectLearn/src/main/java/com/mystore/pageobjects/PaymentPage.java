package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class PaymentPage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a") WebElement payBankWireBtn;
	
	public PaymentPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public OrderSummaryPage ClickOnPayBankWireBtn() {
		Action.click(ldriver, payBankWireBtn);
		return new OrderSummaryPage(ldriver);
	}
}
