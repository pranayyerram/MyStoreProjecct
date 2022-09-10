package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class ShippingPage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//input[@name='cgv']") WebElement TermsCheckBox;
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span") WebElement proceedShipBtn;
	
	public ShippingPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void checkTerms() throws InterruptedException {
		Thread.sleep(3000);
		Action.click(ldriver, TermsCheckBox);
	}
	
	public PaymentPage ClickProceedShipBtn() {
		Action.scrollByVisibilityOfElement(ldriver, proceedShipBtn);
		Action.click(ldriver, proceedShipBtn);
		return new PaymentPage(driver);
	}
}
