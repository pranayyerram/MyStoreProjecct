package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.base;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultTest extends base{
	IndexPage indexpage;
	SearchResultPage searchresult;
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
	public void SearchResTest() throws InterruptedException {
		indexpage=new IndexPage(driver);
		searchresult=indexpage.searchProduct("t-shirts");
		
		boolean res=searchresult.isProductDisplayed();
		Assert.assertTrue(res);
	}
}
