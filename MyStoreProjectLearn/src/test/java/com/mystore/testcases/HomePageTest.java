package com.mystore.testcases;

import static org.junit.Assert.assertTrue;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.base;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends base{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
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
	public void WishListTest() throws InterruptedException {
		indexpage=new IndexPage(driver);
		//homepage=new HomePage(driver);
		loginpage=indexpage.clickOnSignin();
		//loginpage=new LoginPage(driver);
		homepage=loginpage.LoginToAppToHomePage(pro.getProperty("EMAILADDRESS"), pro.getProperty("PASSWORD"));
		boolean res=homepage.ValidateWishlist();
		Assert.assertTrue(res);;
	}
	@Test
	public void OrderHistoryTest() throws InterruptedException {
		indexpage=new IndexPage(driver);
		//homepage=new HomePage(driver);
		loginpage=indexpage.clickOnSignin();
		//loginpage=new LoginPage(driver);
		homepage=loginpage.LoginToAppToHomePage(pro.getProperty("EMAILADDRESS"), pro.getProperty("PASSWORD"));
		boolean res=homepage.ValidateOrderHistory();
		Assert.assertTrue(res);;
	}
}
