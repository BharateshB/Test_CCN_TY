package com.tyss.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class FlipkartCartPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public FlipkartCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/*Save for later button*/
	@FindBy(xpath="//div[@class='nZz3kj _1hNI6F']//div[contains(text(),'Save for later')]")
	private WebElement btnSaveLater ;
	
	/*Move To Cart button*/
	@FindBy(xpath="//div[@class='nZz3kj _1hNI6F']//div[contains(text(),'Move to cart')]")
	private WebElement btnMoveToCart ;
	
	/*total quantity price*/
	@FindBy(xpath="//div[@class='_35mLK5']//div[@class='_I_XQO']//div[@class='_1dqRvU']//span")
	private WebElement btnTotalQtyPrice ;
	
	/*place order button*/
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12 _78xt5Y']//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement btnPlaceOrder ;
	
	/*click on save for later*/
	public synchronized void clickOnSaveForLater() {
		try {
			
			actionUtil.expliEleClickable(driver,btnSaveLater );
			actionUtil.clickElement(btnSaveLater);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on save for later button");
			Assert.fail("unable to click on save for later button");
		}
	}
	
	/*click on Move to cart*/
	public synchronized void clickOnMoveToCart() {
		try {
			scrollBy(driver, 250);
			actionUtil.expliEleClickable(driver,btnMoveToCart );
			actionUtil.clickElement(btnMoveToCart);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on MoveToCart button");
			Assert.fail("unable to click on MoveToCart button");
		}
	}
	
	/*compare total and filteredProd Prices*/
	public synchronized void comparePrices(int filteredProdPrice) {
		try {
			actionUtil.expliEleVisible(driver,btnTotalQtyPrice );
			int total=actionUtil.getElementTextInt(btnTotalQtyPrice);
			Assert.assertEquals(total, filteredProdPrice,"both prices are equal");
			System.out.println("both prices are equal");
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform comparison between prices");
			Assert.fail("unable to  perform comparison between prices");
		}
	}
	
	/*click on Place order*/
	public synchronized void clickOnPlaceOrder() {
		try {
			
			actionUtil.expliEleClickable(driver,btnPlaceOrder);
			actionUtil.clickElement(btnPlaceOrder);
			Thread.sleep(2000);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Place order");
			Assert.fail("unable to click on Place order");
		}
	}

}
