package com.mystore.baseclass;
import com.mystore.actiondriver.action;
import com.mystore.utilities.ExtentManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;


public class base {
	public static Properties pro;
	public static WebDriver driver;
	public static action Action;

	public static ThreadLocal<RemoteWebDriver> tdriver= new ThreadLocal<>();
	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			
			pro=new Properties();
			//FileInputStream fis=new FileInputStream("./Configuration/config.properties");
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void launchBrowser(String browserName)	{
		//WebDriverManager.chromedriver().setup();
		//String browserName=pro.getProperty("BROWSER");
		//browserName="edge";
		if (browserName.equalsIgnoreCase("Chrome")){
			//System.setProperty("Webdriver.chrome.driver", "C://Users//Pranay//Downloads//chromedriver_win32 (4)//chromedriver.exe");
			System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Pranay\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pranay\\Downloads\\geckodriver-v0.31.0-win64 (1)\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		Action=new action();
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 20);
		driver.manage().window().maximize();
		driver.get(pro.getProperty("URL"));
		Action.implicitWait(driver, 10);
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
