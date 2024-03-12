package com.tyss.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class MenSunglassesPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public MenSunglassesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*Brand filter*/
	@FindBy(xpath="//div[@id='brandsRefinements']//li[@aria-label='Fastrack']//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkBrands;
	
	/* filter price*/
	@FindBy(xpath="//div[@id='priceRefinements']//span[contains(text(),'₹1,000 - ₹1,500')]")
	private WebElement lnkPrice;
	
	/* filter Pay On Delivery */
	@FindBy(xpath="//div[@id='filters']//li[@aria-label='Eligible for Pay On Delivery']//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkPOD;
	
	/* filter discount*/
	@FindBy(xpath="//div[@id='filters']//ul[@data-csa-c-slot-id='nav-ref']//span[contains(text(),'10% Off or more')]")
	private WebElement lnkDiscount;
	
	/* filter seller*/
	@FindBy(xpath="//div[@id='filters']//li[@aria-label='Visions India']//i[@class='a-icon a-icon-checkbox']")
	private WebElement chkSeller;
	
	/*get list of sunglasses names*/
	@FindBy(xpath="//div[@class='sg-col-inner']//h2/a//span")
	private List<WebElement> lstSunGlassNames;
	
	
	/*get list of sunglasses price*/
	@FindBy(xpath="//div[@class='sg-col-inner']//span[@class='a-price-whole']")
	private List<WebElement> lstSunGlassprice;
	
	/*filtered sunglass*/
	@FindBy(xpath="//span[@data-component-type='s-search-results']//div[@cel_widget_id='MAIN-SEARCH_RESULTS-1']")
	private WebElement lnkFirstSunglass;
	
	
	/*method to search the product after applying filters*/
	public synchronized void applySgFilters() {
		try {
			Thread.sleep(2000);
			scrollBy(driver, 200);
			actionUtil.expliEleClickable(driver,chkBrands);
			actionUtil.clickElement(chkBrands);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,lnkPrice);
			actionUtil.clickElement(lnkPrice);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkPOD);
			actionUtil.clickElement(chkPOD);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,lnkDiscount);
			actionUtil.clickElement(lnkDiscount);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkSeller);
			actionUtil.clickElement(chkSeller);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform filter action");
			Assert.fail("unable to filter product");
		}
	}
	
	/*print the product names with price*/
	public synchronized void printSunglassesNameAndPrice() {
		try {
			Thread.sleep(2000);
			actionUtil.expliElementsVisible(driver, lstSunGlassNames);
			actionUtil.expliElementsVisible(driver, lstSunGlassprice);
			actionUtil.printNameAndPrice(lstSunGlassNames, lstSunGlassprice );
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print the names and price");
			Assert.fail("unable to print");
		}
		}
	
	
	/*method to click on filtered product*/
	public synchronized void clickOnFilteredSunglass() {
		try {
			actionUtil.expliEleClickable(driver, lnkFirstSunglass);
			actionUtil.clickElement(lnkFirstSunglass);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("product not clickable");
			Assert.fail("unable to click the first filtered product");
		}
	}

}
