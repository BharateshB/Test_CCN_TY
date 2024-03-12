package com.tyss.FirstCry.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class Firstcry_Bicycle_page extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public Firstcry_Bicycle_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*Filter age range*/
	@FindBy(xpath="//div[@class='brand_cn lft fw brd_btm']//span[contains(text(),'4-6 Years ')]")
	private WebElement chkAge;
	
	/*Filter price range*/
	@FindBy(xpath="//div[@class='brand_cn lft fw brd_btm']//span[contains(text(),' 5000 and above ')]")
	private WebElement chkPrice;
	
	
	/*Sort select dropdown*/
	@FindBy(xpath="//div[@class='list_rightp lft']//div[@class='sort-select']//span[@class='arrow']")
	private WebElement ddSortSelect;
	
	/*Sort Newer Arrivals option*/
	@FindBy(xpath="//div[@class='list_rightp lft']//ul[@class='sort-menu sort-hide L12_42']//a[contains(text(),'New Arrivals')]")
	private WebElement optNewerArrivals;
	
	/*list of Bicycle names*/
	@FindBy(xpath="//div[@id='maindiv']//div[@class='li_inner_block']//div[@class='li_txt1 lft wifi']/a")
	private List<WebElement> lstBicycleNames;
	
	/*list of Bicycle price*/
	@FindBy(xpath="//div[@id='maindiv']//div[@class='li_inner_block']//div[@class='rupee fw lft mbzero']//span[@class='r1 B14_42']//a")
	private List<WebElement> lstBicyclePrice;
	
	/*first bicycle img*/
	@FindBy(xpath="(//div[@id='maindiv']//div[@class='li_inner_block']//a/img)[1]")
	private WebElement imgFirstBicycle;
	
	
	
	
	
	/*method to click on Age Filter*/
	public synchronized void clickFilterAge(String parentID) {
		try {
			Thread.sleep(2000);
			switchToChildWindow(driver, parentID);
			scrollBy(driver, 300);
			actionUtil.expliEleClickable(driver,chkAge );
			actionUtil.clickElement(chkAge);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Age check box");
			Assert.fail("unable to click on Age check box");
		}
	}
	
	/*method to click on Age Filter*/
	public synchronized void clickFilterPrice() {
		try {
			scrollBy(driver, 300);
			actionUtil.expliEleClickable(driver,chkPrice );
			actionUtil.clickElement(chkPrice);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Price check box");
			Assert.fail("unable to click on Price check box");
		}
	}
	
	/*Mouse hover on sort and select newer arrivals*/
	public synchronized void selectNewArrival() {
		try {
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
			actionUtil.expliElementsVisible(driver, lstBicycleNames);
			hoverListAndPrintNamesAndPrice(driver, lstBicycleNames, lstBicyclePrice);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print bicycle names and price");
			Assert.fail("unable to print bicycle names and price");
		}
	}
	
	/*method to click on Age Filter*/
	public synchronized void clickFirstbicycle() {
		try {
			actionUtil.expliEleClickable(driver,imgFirstBicycle );
			actionUtil.clickElement(imgFirstBicycle);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on FirstBicycle");
			Assert.fail("unable to click on lnkFirstBicycle");
		}
	}
	
	
	
}
