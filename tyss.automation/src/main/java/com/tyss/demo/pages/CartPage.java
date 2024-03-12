package com.tyss.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class CartPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*product price in the cart*/
	@FindBy(xpath="//div[@class='sc-item-price-block']//span")
	private WebElement txtCartProductPrice;
	
	/* delete product button */
	@FindBy(xpath="//span[@data-action='delete']//input[@value='Delete']")
	private WebElement btnDeleteProduct;
	

	/* quantity dropdown button */
	@FindBy(xpath="//span[@class='a-button-inner']//span[@class='a-button-text a-declarative']")
	private WebElement ddQuantity;
	
	/*select dropdown quantity*/
	@FindBy(xpath="//div[@class='a-popover-inner']//a[@id='quantity_2']")
	private WebElement ddQtyOption;
	
	/*proceed to buy*/
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	private WebElement btnProceedToBuy;
	
	
	/*method to search the product*/
	public synchronized int getCartProductPrice() {
		try {
			actionUtil.expliEleVisible(driver, txtCartProductPrice);
		return actionUtil.getTextIntWithoutDecimal(txtCartProductPrice);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to get product price");
			Assert.fail("unable to get product price from cart");
			return 0;
		}
	}
	
	/*method to delete the product in the cart*/
	public synchronized void clickOnDeleteBtn() {
		try {
			actionUtil.expliEleClickable(driver, btnDeleteProduct);
			actionUtil.clickElement(btnDeleteProduct);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to delete");
			Assert.fail("unable to delete the product from the cart");
		}
	}
	
	/*method to click the quantity dropdown in the cart*/
	public synchronized void clickOnQtyDropdown() {
		try {
			actionUtil.expliEleClickable(driver, ddQuantity);
			actionUtil.clickElement(ddQuantity);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to click the quantity dropdown");
			Assert.fail("unable to click the quantity dropdown");
		}
	}
	
	/*method to select the quantity in the cart*/
	public synchronized void selectQty() {
		try {
			actionUtil.expliEleClickable(driver, ddQtyOption);
			actionUtil.clickElement(ddQtyOption);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to select the quantity option");
			Assert.fail("unable to select the quantity option");
		}
	}
	
	/*method to click the proceed to buy*/
	public synchronized void clkProceedToBuy() {
		try {
			actionUtil.expliEleClickable(driver, btnProceedToBuy);
			actionUtil.clickElement(btnProceedToBuy);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to click the ProceedToBuy button");
			Assert.fail("unable to click the ProceedToBuy button");
		}
	}
}
