package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.baseclass.base;

public class Orderpage extends base{
	WebDriver ldriver;
	@FindBy(xpath="//td[@data-title='Unit price']") WebElement unitPrice;
	@FindBy(id="total_price_container") WebElement totalPrice;
	@FindBy(xpath="//*[@id=\'center_column\']/p[2]/a[1]/span") WebElement ProceedBtn;
	
	public Orderpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	/*public Orderpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}*/
	
	
	public double getUnitPrice() throws InterruptedException {
		Thread.sleep(5000);
		String unitprice1=unitPrice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	
	public double getTotalPrice() {
		String totalprice1=totalPrice.getText();
		String total=totalprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finaltotalprice=Double.parseDouble(total);
		return finaltotalprice/100;
	}
	
	public LoginPage ClickOnProceed() {
		//Action.scrollByVisibilityOfElement(driver, ProceedBtn);
		//Action.click(ldriver, ProceedBtn);
		Action.click1(ProceedBtn, null);
		return new LoginPage(ldriver);
	}
}
