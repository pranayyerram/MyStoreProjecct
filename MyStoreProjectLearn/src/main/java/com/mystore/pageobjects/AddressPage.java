package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class AddressPage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span") WebElement proceedAddBtn;
	
	public AddressPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public ShippingPage clickProceedAddBtn() {
		//Action.scrollByVisibilityOfElement(ldriver, proceedAddBtn);
		//Action.click(ldriver, proceedAddBtn);
		Action.click1(proceedAddBtn, null);
		return new ShippingPage(ldriver);
	}
}
