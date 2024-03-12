package com.tyss.magento.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class Magento_HomePage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public Magento_HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*Gear menu dropdown*/
	@FindBy(xpath="//li[@role='presentation']//a[@href='https://magento.softwaretestingboard.com/gear.html']")
	private WebElement ddGearMenu;
	
	/*Bags option*/
	@FindBy(xpath="//a[@id='ui-id-25']")
	private WebElement lnkBags;
	
	/*list of Bags*/
	@FindBy(xpath="//li[@class='item product product-item']//strong//a")
	private List<WebElement> lstBagsNames ;
	
	/*first bag link*/
	@FindBy(xpath="//li[@class='item product product-item']//a[contains(text(),'Push It Messenger Bag ')]")
	private WebElement lnkFirstBag;
	
	
	
	/*mouse hover Gear menu*/
	public synchronized void HoverGearMenu() {
		try {
			actionUtil.expliEleVisible(driver,ddGearMenu );
			mouseHoverOnElement(driver,ddGearMenu);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to mouse hover the gear menu list");
			Assert.fail("unable to mouse hover gear menu list");
		}
	}
	
	
	/*click on Bags Link*/
	public synchronized void clickBagsLink() {
		try {
			actionUtil.expliEleVisible(driver,lnkBags );
			actionUtil.clickElement(lnkBags);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to click bags link");
			Assert.fail("unable to click bags link");
		}
	}
	
	/*print the list of bags name displayed*/
	public synchronized void printBagsName() {
		try {
			actionUtil.expliElementsVisible(driver,lstBagsNames );
			actionUtil.printListElementText(lstBagsNames, "-------------list of Bags names------");
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to click bags link");
			Assert.fail("unable to click bags link");
		}
	}
	
	/*click on First Bag Link*/
	public synchronized void clickFirstBagLink() {
		try {
			actionUtil.expliEleVisible(driver,lnkFirstBag );
			actionUtil.clickElement(lnkFirstBag);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to click First bag link");
			Assert.fail("unable to click First bag link");
		}
	}
	
	
	
	

}
