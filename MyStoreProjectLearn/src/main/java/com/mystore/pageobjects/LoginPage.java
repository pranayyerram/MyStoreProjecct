package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.action;
import com.mystore.baseclass.base;

public class LoginPage extends base{
	
	WebDriver ldriver;
	@FindBy(xpath="//*[@id=\"email\"]") WebElement emailAddExistingUser;
	@FindBy(xpath="//*[@id=\"passwd\"]") WebElement passwordExistingUser;
	@FindBy(xpath="//i[@class='icon-lock left']") WebElement loginButton;
	
	@FindBy(id="email_create") WebElement EmailNewUserCreation;
	@FindBy(xpath="//i[@class='icon-user left']") WebElement createAccountButton;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public HomePage LoginToAppToHomePage(String emailaddress, String password) throws InterruptedException {
		//action Action=new action();
		Thread.sleep(2000);
		Action.type(emailAddExistingUser, emailaddress);
		
		Thread.sleep(5000);
		Action.type(passwordExistingUser, password);
		Action.click(ldriver, loginButton);
		//driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();
		return new HomePage(ldriver);
	}
	
	public AddressPage LoginToAppToAddressPage(String emailaddress, String password) {
		Action.type(emailAddExistingUser, emailaddress);
		Action.type(passwordExistingUser, password);
		Action.click(ldriver, loginButton);
		return new AddressPage(driver);
	}
	
	public AccountCreationPage AddNewUser(String emailaddress) {
		Action.type(EmailNewUserCreation, emailaddress);
		Action.click(driver, createAccountButton);
		return new AccountCreationPage();
		
	}
	
}
 