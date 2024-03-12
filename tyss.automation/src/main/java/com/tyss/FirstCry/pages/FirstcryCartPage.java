package com.tyss.FirstCry.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class FirstcryCartPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public FirstcryCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*Shortlist button*/
//	@FindBy(xpath="//div[@class='prod-buttons clearfix']/div[@id='shortlist']")
	@FindBy(xpath="//div[@class='prod-buttons clearfix']//span[contains(text(),'Shortlist')]")
	private WebElement btnShortlist;
	
	/*add to cart button*/
	@FindBy(xpath="//div[@class='prod-buttons clearfix']/div[@class='div-add-to-cart']/div[@class='btn btn-add-cart add-cart']")
	private WebElement btnAddToCart;
	
	/*Goto cart button*/
//	@FindBy(xpath="//div[@class='prod-buttons clearfix']//div[@class='btn btn-add-cart btn-add-cart-active']//span[contains(text(),'GO TO CART')]")
	@FindBy(xpath="//div[@class='prod-buttons clearfix']//div[@class='btn btn-add-cart btn-add-cart-active']//span[contains(text(),'Go to Cart')]")
	private WebElement btnGotoCart;
		
	/*price of the product after added to cart*/
	@FindBy(xpath="//div[@class='div-prod-price']//span[@id='prod_price']")
	private WebElement txtProductPrice;
	
	/*price of the product in cart*/
	@FindBy(xpath="//div[@class='cart-card-content-info-2']//span[@class='B18_42']")
	private WebElement txtCartProductPrice;
	
	/*LoginToPlaceOrder button*/
	@FindBy(xpath="//div[@class='placeOrderButtonWraper']//label[contains(text(),' Login to place order ')]")
	private WebElement btnLoginToPlaceOrder;
	
	
	/*method to click on ShortList button*/
	public synchronized void clickShortlist(String parentID2) {
		try {
			Thread.sleep(1000);
			switchToChildWindow(driver, parentID2);
			actionUtil.expliEleClickable(driver,btnShortlist );
			actionUtil.clickElement(btnShortlist);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Shortlist button");
			Assert.fail("unable to click on Shortlist button");
		}
	}
	
	/*method to click on ShortList button*/
	public synchronized void clickShortlist() {
		try {
			Thread.sleep(1000);
			actionUtil.expliEleClickable(driver,btnShortlist );
			actionUtil.clickElement(btnShortlist);
			Thread.sleep(1000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Shortlist button");
			Assert.fail("unable to click on Shortlist button");
		}
	}
	
	/*method to click on Add to cart button*/
	public synchronized void clickAddToCart() {
		try {
			actionUtil.expliEleClickable(driver,btnAddToCart );
			actionUtil.clickElement(btnAddToCart);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Add to cart button");
			Assert.fail("unable to click on Add to cart button");
		}
	}
	
	/*method to click on Go to cart button*/
	public synchronized void clickGoToCart() {
		try {
			actionUtil.expliEleClickable(driver,btnGotoCart );
			actionUtil.clickElement(btnGotoCart);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Go to cart button");
			Assert.fail("unable to click on Go to cart button");
		}
	}
	
	
	/*method to click on login to place order button*/
	public synchronized void clickbtnLoginToPlaceOrder() {
		try {
			actionUtil.expliEleClickable(driver,btnLoginToPlaceOrder );
			actionUtil.clickElement(btnLoginToPlaceOrder);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on btnLoginToPlaceOrder button");
			Assert.fail("unable to click on btnLoginToPlaceOrder button");
		}
	}
	
	
	

}
