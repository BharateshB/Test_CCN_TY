package com.tyss.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class MagentoSelectedProductPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public MagentoSelectedProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*enter the quantity in the text field*/
	@FindBy(xpath="//div[@class='field qty']//input[@id='qty']")
	private WebElement txtEnterQty;
	
	/*Add to cart button*/
	@FindBy(xpath="//div[@class='actions']//span[contains(text(),'Add to Cart')]")
	private WebElement btnAddtoCart;
	
	/*Cart image*/
	@FindBy(xpath="//div[@data-block='minicart']")
	private WebElement imgCart;
	
	
	
	/*method to enter the quantity*/
	public synchronized void enterQty(String quantity) {
		try {
			actionUtil.expliEleVisible(driver,txtEnterQty );
			actionUtil.enterTextElement(txtEnterQty,quantity);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to enter quantity");
			Assert.fail("unable to enter quantity");
		}
	}
	
	/*method to click on add to cart*/
	public synchronized void clickOnAddToCart() {
		try {
			actionUtil.expliEleClickable(driver,btnAddtoCart );
			actionUtil.clickElement(btnAddtoCart);
			Thread.sleep(3000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on AddtoCart");
			Assert.fail("unable to click on AddtoCart");
		}
	}
	
	/*method to click on cart image*/
	public synchronized void clickOnCartImage() {
		try {
			actionUtil.expliEleClickable(driver,imgCart );
			actionUtil.clickElement(imgCart);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Cart image");
			Assert.fail("unable to click on Cart image");
		}
	}
	

}
