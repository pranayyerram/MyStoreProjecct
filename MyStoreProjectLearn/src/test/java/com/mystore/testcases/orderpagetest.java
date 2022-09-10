package com.mystore.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.base;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.SearchResultPage;

import junit.framework.Assert;

public class orderpagetest extends base{
	IndexPage indexpage;
	SearchResultPage searchresult;
	AddToCartPage addtocart;
	Orderpage orderpage;
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
	public void OrderPageTest() throws InterruptedException {
		indexpage=new IndexPage(driver);
		searchresult=indexpage.searchProduct("t-shirts");
		addtocart=searchresult.clickOnProduct();
		addtocart.EnterQuantity("3");
		addtocart.EnterSize("M");
		addtocart.clickOnAddTocart();
		
		orderpage=addtocart.ProceedToCheckout();
		orderpage=new Orderpage(driver);
		double Unitprice=orderpage.getUnitPrice();
		double Totalprice=orderpage.getTotalPrice();
		//System.out.print(Totalprice);
		double expectedtotalprice=((Unitprice*3)+2);
		Assert.assertEquals(Totalprice, expectedtotalprice);
	}
	
}
