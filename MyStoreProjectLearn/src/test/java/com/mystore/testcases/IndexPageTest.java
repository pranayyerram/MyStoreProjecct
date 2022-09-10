package com.mystore.testcases;

import org.testng.annotations.*;

import com.mystore.baseclass.base;
import com.mystore.pageobjects.IndexPage;

import junit.framework.Assert;

public class IndexPageTest extends base{

	IndexPage indexpage;
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
	public void ValidateLogo() {
		indexpage=new IndexPage(driver);
		boolean result=indexpage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void ValidateTitle() {
		indexpage=new IndexPage(driver);
		String title=indexpage.getPageTitle();
		Assert.assertEquals(title, "My Store");
		indexpage.searchProduct("t-shirts");
		
	}
	
	
	
	
	
}
