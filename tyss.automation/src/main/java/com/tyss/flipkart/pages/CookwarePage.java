package com.tyss.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class CookwarePage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public CookwarePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/*Newest first button*/
	@FindBy(xpath="//div[@class='_5THWM1']//div[contains(text(),'Newest First')]")
	private WebElement btnNewestFirst ;

	/*Filter Pressure Cookers*/
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//section[@class='_2aDURW']//a[contains(text(),'Pressure Cookers')]")
	private WebElement lnkPressureCookers;
	
	/*Filter price dropdown*/
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//section[@class='_2yz7eI _2hbLCH']//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	private WebElement ddprice;

	/*Filter flipkart assured*/
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//section[@class='_2hbLCH _24gLJx']//div[@class='_24_Dny _3tCU7L']")
	private WebElement chkFlipkartAssured;

	/*Filter Rating*/
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//section[@class='_167Mu3 _2hbLCH']//div[@title='3★ & above']//div[@class='_3879cV']")
	private WebElement chkFilterRating ;

	/*Filter Special Price*/
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//section[@class='_167Mu3 _2hbLCH']//div[@title='Special Price']//div[@class='_3879cV']")
	private WebElement chkSpecialPrice;
	
	
	/*List of filtered results Names*/
	@FindBy(xpath="//div[@class='_13oc-S']//div[@class='_4ddWXP']//a[@class='s1Q9rs']")
	private List<WebElement> lstFilteredResultsNames;
	
	/*Third filtered result */
//	@FindBy(xpath="//div[@data-id='PRCGJ86B6BS6HQRE']//a[@class='_2rpwqI']")
	@FindBy(xpath="(//div[@class='_13oc-S']//div[@class='_4ddWXP']//a[@class='s1Q9rs'])[3]")
	private WebElement lnkThirdproduct;
	
	/*fourth filtered result */
	@FindBy(xpath="(//div[@class='_13oc-S']//div[@class='_4ddWXP']//a[@class='s1Q9rs'])[4]")
	private WebElement lnkFourthProduct;
	
	
	/*List of filtered results prices*/
	@FindBy(xpath="//div[@class='_13oc-S']//div[@class='_4ddWXP']//a[@class='s1Q9rs']//ancestor::div[@class='_4ddWXP']//div[@class=\"_25b18c\"]/child::div[@class='_30jeq3']")
	private List<WebElement> lstFilteredResultsPrices;
	
	/*click on newest first*/
	public synchronized void clickOnNewestFirst() {
		try {
			actionUtil.expliEleClickable(driver,btnNewestFirst );
			actionUtil.clickElement(btnNewestFirst);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on NewestFirst");
			Assert.fail("unable to click on btnNewestFirst");
		}
	}
	
	
	public synchronized void applyFilters() {
		try {
			actionUtil.expliEleClickable(driver,lnkPressureCookers);
			actionUtil.clickElement(lnkPressureCookers);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,ddprice);
			selectbyvalue(ddprice, "3000");
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkFlipkartAssured);
			actionUtil.clickElement(chkFlipkartAssured);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkFilterRating);
			actionUtil.clickElement(chkFilterRating);
			Thread.sleep(2000);
			actionUtil.expliEleClickable(driver,chkSpecialPrice);
			actionUtil.clickElement(chkSpecialPrice);
			Thread.sleep(3000);
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
			actionUtil.expliElementsVisible(driver,lstFilteredResultsNames );
			actionUtil.expliElementsVisible(driver,lstFilteredResultsPrices );
			actionUtil.printNameAndPriceRefTitle(lstFilteredResultsNames,lstFilteredResultsPrices  );
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print the filtered names and price");
			Assert.fail("unable to print filtered names and price");
		}
		}
	
	/*click on Third product*/
	public synchronized String clickAndGetThirdFilteredProduct() {
		try {
			actionUtil.expliEleClickable(driver,lnkThirdproduct );
			String attValue=actionUtil.getAttributeText(lnkThirdproduct, "title");
			actionUtil.clickElement(lnkThirdproduct);
			Thread.sleep(2000);
			return attValue;
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Third product");
			Assert.fail("unable to click on Third product");
			return null;
		}
	}
	
	/*click on Third product*/
	public synchronized void clickOnFourthFilteredProduct() {
		try {
			actionUtil.expliEleClickable(driver,lnkFourthProduct );
			actionUtil.clickElement(lnkFourthProduct);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Fourth product");
			Assert.fail("unable to click on Fourth product");
		}
	}
	
	
	
}
