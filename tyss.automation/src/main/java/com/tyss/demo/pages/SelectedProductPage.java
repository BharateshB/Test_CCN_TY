package com.tyss.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class SelectedProductPage extends WebDriverUtility{
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	public SelectedProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*price of selected product*/
	@FindBy(xpath="//div[@class='a-section a-spacing-none aok-align-center']//span[@class='a-price-whole']")
	private WebElement txtSelProdPrice;
	
	/*add to cart button*/
	@FindBy(xpath="//div[@class='a-button-stack']//span[@id='submit.add-to-cart']//input[@id='add-to-cart-button']")
	private WebElement btnaddToCart;
	
	/*added to cart msg*/
	@FindBy(xpath="//div[@id='attach-added-to-cart-message']//span[contains(text(),'Added to Cart')]")
	private WebElement txtAddedToCartMsg;
	
	/*cart button after added to cart*/
	/*add to cart button*/
	@FindBy(xpath="//div[@id='attach-added-to-cart-message']//input[@class='a-button-input']")
	private WebElement btnCart;
	
	/*method to get product prize before added to cart*/
	public synchronized int getProductPrice() {
		try {
			actionUtil.expliEleVisible(driver, txtSelProdPrice);
		return actionUtil.getElementTextInt(txtSelProdPrice);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to get product price");
			Assert.fail("unable to get product price");
			return 0;
		}
	}
	
	/*method to click on add to cart button*/
	public synchronized void addToCart() {
		try {
			actionUtil.expliEleClickable(driver, btnaddToCart);
			actionUtil.clickElement(btnaddToCart);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("button not clickable");
			Assert.fail("unable to click on add to cart btn");
		}
	}
	
	/*method to get message after adding product to cart*/
	public synchronized String getMsgAddedToCart() {
		try {
			actionUtil.expliEleVisible(driver, txtAddedToCartMsg);
		return actionUtil.getElementText(txtAddedToCartMsg);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to get message");
			Assert.fail("unable to get message");
			return null;
		}
	}
	
	/*method to click on add to cart button*/
	public synchronized void clickOnCart() {
		try {
			actionUtil.expliEleClickable(driver, btnCart);
			actionUtil.clickElement(btnCart);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("button not clickable");
			Assert.fail("unable to click on cart btn");
		}
	}
	
}
