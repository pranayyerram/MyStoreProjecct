package com.mystore.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.base;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

import junit.framework.Assert;

public class EndToEndTest extends base{
	IndexPage indexpage;
	static LoginPage loginpage;
	SearchResultPage searchresult;
	static AddToCartPage addtocart;
	static Orderpage orderpage;
	static AddressPage addresspage;
	static ShippingPage shippingpage;
	static PaymentPage paymentpage;
	OrderSummaryPage ordersummary;
	OrderConfirmationPage orderconfirmation;
	@Parameters("browser")
	@BeforeTest 
	public void LaunchBrowser(String browser) {
		launchBrowser(browser);
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	@Test
	public void endtoendtest() throws InterruptedException {
		indexpage=new IndexPage(driver);
		searchresult=indexpage.searchProduct("t-shirts");
		addtocart=searchresult.clickOnProduct();
		addtocart.EnterQuantity("3");
		addtocart.EnterSize("M");
		addtocart.clickOnAddTocart();
		
		addtocart.ProceedToCheckout();
		orderpage=new Orderpage(driver);
		loginpage=orderpage.ClickOnProceed();
		addresspage=new AddressPage(driver);
		loginpage.LoginToAppToAddressPage(pro.getProperty("EMAILADDRESS"), pro.getProperty("PASSWORD"));
		addresspage.clickProceedAddBtn();
		shippingpage=new ShippingPage(driver);
		shippingpage.checkTerms();
		shippingpage.ClickProceedShipBtn();
		paymentpage=new PaymentPage(driver);
		paymentpage.ClickOnPayBankWireBtn();
		ordersummary=new OrderSummaryPage(driver);
		ordersummary.ClickOnConfirmBtn();
		orderconfirmation=new OrderConfirmationPage(driver);
		String cnfmmsg=orderconfirmation.ValidateConfirmMessage();
		Assert.assertEquals(cnfmmsg, "Your order on My Store is complete.");
	}
}
