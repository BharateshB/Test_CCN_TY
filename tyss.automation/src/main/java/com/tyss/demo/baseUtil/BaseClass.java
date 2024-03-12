package com.tyss.demo.baseUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tyss.FirstCry.pages.FirstcryCartPage;
import com.tyss.FirstCry.pages.FirstcryHomePage;
import com.tyss.FirstCry.pages.Firstcry_Selected_TP_Page;
import com.tyss.demo.commonUtils.WebDriverUtility;
import com.tyss.demo.pages.Amazon_HomePage;
import com.tyss.demo.pages.CartPage;
import com.tyss.demo.pages.SearchedProductPage;
import com.tyss.demo.pages.SelectedProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public 	WebDriver driver;
	WebDriverUtility wdu=new WebDriverUtility();
	
//	public String url = "https://www.amazon.in/";
//	public String url = "https://www.flipkart.com/";
	public String url = "https://magento.softwaretestingboard.com/";
//	public String url = "https://www.firstcry.com/";
	
	/* connect to database*/
	@BeforeSuite
	public void databaseconnection()
	{
		System.out.println("connected to database");
	}
	
	/* execution type and starting*/
	@BeforeTest
	public void executiontype()
	{
		System.out.println(" execution started");
	}
	
	/* launch the browser*/
	@BeforeClass
	public void launchBrowser()
	{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/* visit the application and login*/
	@BeforeMethod
	public void applicationlogin() throws Throwable
	{
		driver.get(url);
		Thread.sleep(2000);
		System.out.println("logged into app");
	}

	/* logout from the application*/
	@AfterMethod
	public void logoutapplication()
	{
		System.out.println("logged out");
	}

	/* quit the browser*/
	@AfterClass
	public void closebrowser()
	{
//		driver.quit();
	}

	/* execution completed*/
	@AfterTest
	public void executioncompleted()
	{
		System.out.println(" execution completed");
	}

	/* close the database connection*/
	@AfterSuite
	public void closedatabase()
	{
		System.out.println("database connection closed");
	}	
}
