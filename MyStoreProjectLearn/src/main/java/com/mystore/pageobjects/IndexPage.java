package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.action;
import com.mystore.baseclass.base;

public class IndexPage extends base{
	WebDriver ldriver;
	//action Actions=new action();
			
	@FindBy(xpath="//a[@class='login']") WebElement signinButton;
	@FindBy(xpath="//img[@alt='My Store']") WebElement mystoreLogo;
	@FindBy(id="search_query_top") WebElement searchBox;
	@FindBy(name="submit_search") WebElement searchButton;
	
	
	public IndexPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public boolean validateLogo() {
		//Actions=new action();
		return Action.isDisplayed(ldriver, mystoreLogo);
	}
	public LoginPage clickOnSignin() {
		//Actions=new action();
		Action.click(ldriver, signinButton);
		return new LoginPage(ldriver);
	}
	public String getPageTitle() {
		
		String t=ldriver.getTitle();
		System.out.print(t);
		return t;
	
	}
	public SearchResultPage searchProduct(String productName) {
		//Actions=new action();
		Action.type(searchBox, productName);
		Action.click(ldriver, searchButton);
		return new SearchResultPage(ldriver);
	}
}
