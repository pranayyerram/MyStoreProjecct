package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class AddToCartPage extends base{
	WebDriver ldriver;
	@FindBy(id="quantity_wanted") WebElement quantity;
	@FindBy(id="group_1") WebElement size;
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span") WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2") WebElement addToCartMessage;
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span") WebElement ProceedToCheckoutBtn;
	
	public AddToCartPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	public void EnterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void EnterSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddTocart() throws InterruptedException {
		Action.click(ldriver, addToCartBtn);
		Thread.sleep(5000);
	}
	
	public boolean ValidateSuccessMsg() {
		return Action.isDisplayed(ldriver, addToCartMessage);
	}
	
	public Orderpage ProceedToCheckout() throws InterruptedException {
		Thread.sleep(5000);
		Action.explicitWait(ldriver, ProceedToCheckoutBtn, 10);
		Action.click(ldriver, ProceedToCheckoutBtn);
		return new Orderpage(ldriver);
	}
}
