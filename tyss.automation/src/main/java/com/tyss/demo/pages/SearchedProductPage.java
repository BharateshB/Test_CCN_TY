package com.tyss.demo.pages;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class SearchedProductPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public SearchedProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*Filter Brand name*/
	@FindBy(xpath="//li[@id='p_89/HP']//div//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkHpProduct;
	
	/* Filter Price Range */
	@FindBy(xpath="//div[@id='priceRefinements']//span[contains(text(),'₹30,000 – ₹40,000')]")
	private WebElement lnkPriceRange;
	
	/* Filter CPU manufacturer type */
	@FindBy(xpath="//li[@aria-label='Intel']//div//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkCPU;
	
	/* Filter OS type */
	@FindBy(xpath="//li[@aria-label='Windows 10 Pro']//div//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkOS;
	
	/* Filter RAMsize type */
	@FindBy(xpath="//li[@aria-label='8 GB']//div//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkRAM;
	
	/* Filtered product type */
	@FindBy(xpath="//div[@class='sg-row']//div[@class='sg-col-inner']//h2/a//span")
	private List<WebElement> lstProductName ;
	
	/* Filtered product price */
	@FindBy(xpath="//div[@class='sg-row']//span[@class='a-price-whole']")
	private List<WebElement> lstProductPrice ;
	
	/*first filtered product image*/
	@FindBy(xpath="//div[@class='aok-relative']//a//img[@data-image-index='2']")
	private WebElement imgFirstProduct;
	
	
	/*method to search the product*/
	public synchronized void applyFilters() {
		try {
			actionUtil.expliEleClickable(driver,chkHpProduct);
			actionUtil.clickElement(chkHpProduct);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,lnkPriceRange);
			actionUtil.clickElement(lnkPriceRange);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkCPU);
			actionUtil.clickElement(chkCPU);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkOS);
			actionUtil.clickElement(chkOS);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkRAM);
			actionUtil.clickElement(chkRAM);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform filter action");
			Assert.fail("unable to filter product");
		}
	}
	
	/*print the product names with price*/
	public synchronized void printNameAndPrice() {
		try {
			actionUtil.expliElementsVisible(driver, lstProductName);
			actionUtil.expliElementsVisible(driver, lstProductPrice);
			actionUtil.printNameAndPrice(lstProductName, lstProductPrice );
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print the names and price");
			Assert.fail("unable to print");
		}
		}
	
	
	/*method to click on filtered product*/
	public synchronized void clickOnFirstFilteredProduct() {
		try {
			actionUtil.expliEleClickable(driver, imgFirstProduct);
			actionUtil.clickElement(imgFirstProduct);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("product not clickable");
			Assert.fail("unable to click the first filtered product");
		}
	}
	
} 
