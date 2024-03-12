package com.tyss.FirstCry.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class Firstcry_Selected_TP_Page extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	
	/*constructor to initialize elements */
	public Firstcry_Selected_TP_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*Filter toothpaste*/
	@FindBy(xpath="//div[@class='brand_cn lft fw brd_btm']//span[contains(text(),'Toothpaste')]")
	private WebElement chkToothpaste;
	
	/*Sort select dropdown*/
//	@FindBy(xpath="//div[@class='list_rightp lft']//div[@class='sort-select']//span[@class='arrow']")
	@FindBy(xpath="//div[@class='list_rightp lft']//div[@class='sort-select']//div[contains(text(),'Select')]")
	private WebElement ddSortSelect;
	
	/*Sort Newer Arrivals option*/
	@FindBy(xpath="//div[@class='list_rightp lft']//ul[@class='sort-menu sort-hide L12_42']//a[contains(text(),'New Arrivals')]")
	private WebElement optNewerArrivals;
	
	/*list of toothpaste names*/
	@FindBy(xpath="//div[@id='maindiv']//div[@class='li_inner_block']//div[@class='li_txt1 lft wifi']/a")
	private List<WebElement> lstTPNames;
	
	/*list of toothpaste price*/
	@FindBy(xpath="//div[@id='maindiv']//div[@class='li_inner_block']//div[@class='rupee fw lft mbzero']//span[@class='r1 B14_42']//a")
	private List<WebElement> lstTPPrice;
	
	/*List of combo pack contents*/
	@FindBy(xpath="//div[@class='div-contains']//a[1]")
	private List<WebElement> lstComboPack ;
	
	/*Expiry date text*/
	@FindBy(xpath="//div[@class='prod-exp-wrap']//span[@id='exp_date']")
	private WebElement txtExpiryDate ;
	
	/*product side images*/
	@FindBy(xpath="//div[@id='slide-wrap']//img")
	private List<WebElement> lstSideImgs ;
	
	/*select Filter toothpaste */
	public synchronized void clickToothPasteChk() {
		try {
			scrollBy(driver, 200);
			actionUtil.expliEleClickable(driver,chkToothpaste );
			actionUtil.clickElement(chkToothpaste);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to click on Toothpaste checkbox");
			Assert.fail("unable to click on Toothpaste checkbox");
		}
	}
	
	/*Mouse hover on sort and select newer arrivals*/
	public synchronized void selectNewArrival() {
		try {
//			Thread.sleep(2000);
			scrollBy(driver, -150);
			actionUtil.expliEleVisible(driver, ddSortSelect);
			mouseHoverOnElement(driver, ddSortSelect);
			actionUtil.expliEleVisible(driver, optNewerArrivals);
			actionUtil.clickElement(optNewerArrivals);
			
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to select New Arrival");
			Assert.fail("unable to select New Arrival");
		}
	}
	
	
	
	/*method to click on Age Filter*/
	public synchronized void PrintNameAndPrice() {
		try {
			actionUtil.expliElementsVisible(driver, lstTPNames);
			hoverListAndPrintNamesAndPrice(driver, lstTPNames, lstTPPrice);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print Toothpaste names and price");
			Assert.fail("unable to print Toothpaste names and price");
		}
	}
	
	/*method to select product based on parameter*/
	public synchronized void selectToothpaste(String TPName) {
		try {
			actionUtil.expliElementsVisible(driver, lstTPNames);
			selectParticularProduct(driver, lstTPNames, TPName);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to select Toothpaste");
			Assert.fail("unable to select Toothpaste");
		}
	}
	
	/*method to print ComboContents*/
	public synchronized void printComboContents(String parentID) {
		try {
			switchToChildWindow(driver, parentID);
			actionUtil.expliElementsVisible(driver, lstComboPack);
			printElementsText(driver, lstComboPack);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print ComboContents");
			Assert.fail("unable to print ComboContents");
		}
	}

	/*method to print expiry date */
	public synchronized void printExpiryDate() {
		try {
			actionUtil.expliEleVisible(driver,txtExpiryDate );
			actionUtil.printElementText(txtExpiryDate);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print ExpiryDate");
			Assert.fail("unable to print ExpiryDate");
		}
	}
	
	
	/*method to mouse hover on all side images*/
	public synchronized void hoverAllImages() {
		try {
			actionUtil.expliElementsVisible(driver,lstSideImgs );
			hoverListImages(driver, lstSideImgs);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to hover side images");
			Assert.fail("unable to hover side images");
		}
	}
	
}
