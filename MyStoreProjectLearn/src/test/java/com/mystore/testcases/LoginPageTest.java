package com.mystore.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utilities.Log;

import junit.framework.Assert;

public class LoginPageTest extends base{
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
		driver.close();
	}
	
	@Test(dataProvider="Credentials", dataProviderClass=DataProviders.class)
	public void LoginTest(String uname, String pwd) throws InterruptedException {
		Log.startTestCase("LoginTest");
		indexpage=new IndexPage(driver);
		loginpage=new LoginPage(driver);
		//loginpage=indexpage.clickOnSignin();
		indexpage.clickOnSignin();
		Log.info("Clicked on Signin Button");
		Thread.sleep(2000);
		homepage=new HomePage(driver);
		Log.info("Entering username: "+pro.getProperty("EMAILADDRESS")+" and Password: "+pro.getProperty("PASSWORD"));
		//loginpage.LoginToAppToHomePage(pro.getProperty("EMAILADDRESS"), pro.getProperty("PASSWORD"));
		loginpage.LoginToAppToHomePage(uname, pwd);
		Log.info("Logged into Application");
		String accUrl="http://automationpractice.com/index.php?controller=my-account";
		String testResUrl=homepage.getCurUrl();
		Assert.assertEquals(accUrl, testResUrl);
		Log.endTestCase("LoginTest");
	}
	
}
