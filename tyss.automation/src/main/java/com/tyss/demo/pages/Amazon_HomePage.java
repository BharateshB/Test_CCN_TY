package com.tyss.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class Amazon_HomePage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public Amazon_HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*search product text area*/
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement txtSearchProduct;
	
	/* search button */
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement btnSearchProduct;
	
	/*ALL menu*/
//	@FindBy(xpath="//a[@id='nav-hamburger-menu']//span")
	@FindBy(xpath="//div[@id='nav-main']//div[@class='nav-left']")
	private WebElement lnkAllMenu;
	
	/*Men's Fashion link*/
	@FindBy(xpath="//div[@id='hmenu-content']//li//a//div[contains(text(),\"Men's Fashion\")]")
	private WebElement lnkMenFashion;
	
	//Men's Sunglasses link
	@FindBy(xpath="//div[@id='hmenu-content']//ul[@data-menu-id='10']//li//a[contains(text(),'Sunglasses')]")
	private WebElement lnkSunglasses;
	
	/*method to search the product*/
	public synchronized void searchProduct(String productName) {
		try {
			actionUtil.expliEleVisible(driver, txtSearchProduct);
			actionUtil.enterTextElement(txtSearchProduct, productName);
			actionUtil.expliEleClickable(driver, btnSearchProduct);
			actionUtil.clickElement(btnSearchProduct);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform search action");
			Assert.fail("unable to search product");
		}
	}
	
	/*method to search allMenu*/
	public synchronized void allMenu() {
		try {
			actionUtil.expliEleVisible(driver, lnkAllMenu);
//			mouseHverSingleClick(driver, lnkAllMenu);
			actionUtil.clickElement(lnkAllMenu);
			
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on ALL menu");
			Assert.fail("unable to click ALL link");
		}
	}
	
	/*method to search Men's Fashion*/
	public synchronized void clickOnMensFashion() {
		try {
			actionUtil.expliEleClickable(driver, lnkMenFashion);
			actionUtil.clickElement(lnkMenFashion);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on MenFashion link");
			Assert.fail("unable to click on MenFashion link");
		}
	}
	/*method to search Men's Sunglasses*/
	public synchronized void clickOnSunglassesLnk() {
		try {
			actionUtil.expliEleClickable(driver, lnkSunglasses);
			actionUtil.clickElement(lnkSunglasses);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Sunglasses link");
			Assert.fail("unable to click on Sunglasses link");
		}
	}
	
	
	
}
