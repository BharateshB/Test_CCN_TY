package com.tyss.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class MagentoCartPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
//	int index;
	
	/*constructor to initialize elements */
	public MagentoCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*check cart text*/
	@FindBy(xpath="//div[@data-block='minicart']//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']//span[@class='counter-number']")
	private WebElement txtCheckCart;
	
	/*proceed to checkout*/
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	private WebElement btnProceedCheckout;
	
	/*remove Cart items*/
	@FindBy(xpath="//div[@class='product actions']//div[@class='secondary']/a[@title='Remove item']")
	private WebElement btnRemCartItem;
	
	/*accept remove item*/
	@FindBy(xpath="//div[@class='modal-inner-wrap']/footer[@class='modal-footer']/button[@class='action-primary action-accept']")
	private WebElement btnAcceptRemCartItem;
	
	/*empty cart msg display*/
	@FindBy(xpath="//div[@id='minicart-content-wrapper']/div[@class='block-content']/strong")
	private WebElement txtEmptyCart;
	
	/*method to close login screen*/
	public synchronized void checkCart() {
		try {
			actionUtil.expliEleVisible(driver,txtCheckCart );
			String cartItem= actionUtil.getElementText(txtCheckCart);
			System.out.println("the cart items are :"+cartItem);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to get cart text");
			Assert.fail("unable to cart text");
		}
	}
	
	/*method to click on add to cart*/
	public synchronized void clickProceedCheckout() {
		try {
			actionUtil.expliEleClickable(driver,btnProceedCheckout );
			actionUtil.clickElement(btnProceedCheckout);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on ProceedCheckout");
			Assert.fail("unable to click on ProceedCheckout");
		}
	}
	
	/*method to click on cart image*/
	public synchronized void clickRemoveCartItem() {
		try {
			actionUtil.expliEleClickable(driver,btnRemCartItem );
			actionUtil.clickElement(btnRemCartItem);
			Thread.sleep(1000);
			actionUtil.expliEleClickable(driver,btnAcceptRemCartItem );
			actionUtil.clickElement(btnAcceptRemCartItem);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on remove cart item");
			Assert.fail("unable to click on remove Cart item");
		}
	}
	
	/*method to get cart msg after deletion*/
	public synchronized void getRemoveCartItemMsg() {
		try {
			Thread.sleep(1000);
			actionUtil.expliEleVisible(driver,txtEmptyCart );
			String msg=actionUtil.getElementText(txtEmptyCart);
			System.out.println("after deletion :"+msg);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to get msg after deletion");
			Assert.fail("unable to get msg after deletion");
		}
	}

}
