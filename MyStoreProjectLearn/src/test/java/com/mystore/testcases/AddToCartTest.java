package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.base;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartTest extends base{
	IndexPage indexpage;
	SearchResultPage searchresult;
	AddToCartPage addtocart;
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
	public void AddToCartTest() throws InterruptedException {
		indexpage=new IndexPage(driver);
		searchresult=indexpage.searchProduct("t-shirts");
		addtocart=searchresult.clickOnProduct();
		addtocart.EnterQuantity("3");
		addtocart.EnterSize("M");
		addtocart.clickOnAddTocart();
		boolean res=addtocart.ValidateSuccessMsg();
		Assert.assertTrue(res);
	}
}
