package com.tyss.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class FilteredProductPage extends WebDriverUtility{
		/*create an instance of ActionUtility class*/
		ActionUtility actionUtil=new ActionUtility();
		WebDriver driver;
		
		/*constructor to initialize elements */
		public FilteredProductPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		/*filtered Selected Product*/
//		@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//div[@class='_2nQDXZ']//div[@class='_3fSRat']//a")
		@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//h1//span")
		private WebElement filteredSelectedProduct;
		
		
		/*Delivery pin code text area*/
		@FindBy(xpath="//div[@class='_1PQN-K']//input[@id='pincodeInputId']")
		private WebElement  txtPinCode;
		
		/*Delivery pin code check button*/
		@FindBy(xpath="//div[@class='_1PQN-K']//span[contains(text(),'Check')]")
		private WebElement  btnCheckPinCode;
		
		/*Delivery pin code change button*/
		@FindBy(xpath="//div[@class='hivXmn _8TbzJs']//span[@class='_2P_LDn']")
		private WebElement  btnChangePinCode;
		
		/*AddToCart button*/
		@FindBy(xpath="//div[@class='_1p3MFP dTTu2M']//li[@class='col col-6-12']//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
		private WebElement  btnAddToCart;
		
		/*Filtered product price*/
		@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//div[@class='dyC4hf']//div[@class='_25b18c']/div[@class='_30jeq3 _16Jk6d']")
		private WebElement txtFilteredproductPrice ;
		
		/*Invalid PinCode Message*/
		@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//div[@class='_1SLzzw']/div")
		private WebElement txtInvalidPinCodeMessage ;

		/*get filtered Selected Product*/
		public synchronized String getfilteredSelectedProduct() {
			try {
				Thread.sleep(2000);
				actionUtil.expliEleVisible(driver,filteredSelectedProduct );
				return actionUtil.getElementText(filteredSelectedProduct);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to get filtered product");
				Assert.fail("unable to get filtered product");
				return null;
			}
		}
		
		/*enter pin code */
		public synchronized void enterPinCode(String code) {
			try {
				Thread.sleep(2000);
				actionUtil.expliEleVisible(driver,txtPinCode );
				actionUtil.enterTextElement(txtPinCode,code);
				Thread.sleep(2000);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to send pincode");
				Assert.fail("unable to send pincode");
			}
		}
		

		/*check for pin code validation*/
		public synchronized void clickOnPinCodeCheck() {
			try {
				
				actionUtil.expliEleClickable(driver,btnCheckPinCode );
				actionUtil.clickElement(btnCheckPinCode);
				actionUtil.expliEleVisible(driver,txtInvalidPinCodeMessage);
				actionUtil.EleTextContains(txtInvalidPinCodeMessage,"Not a valid pincode");
				Thread.sleep(2000);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to perform click action on CheckPinCode button");
				Assert.fail("unable to click on CheckPinCode button");
			}
		}
		
		/*change the pincode*/
		public synchronized void clickOnPinCodeChange() {
			try {
				
				actionUtil.expliEleClickable(driver,btnChangePinCode );
				actionUtil.clickElement(btnChangePinCode);
				Thread.sleep(2000);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to perform click action on CheckPinCode button");
				Assert.fail("unable to click on CheckPinCode button");
			}
		}
		
		
		/*click on add to cart*/
		public synchronized void clickAddToCart() {
			try {
				
				actionUtil.expliEleClickable(driver,btnAddToCart );
				actionUtil.clickElement(btnAddToCart);
				Thread.sleep(2000);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to perform click action on CheckPinCode button");
				Assert.fail("unable to click on CheckPinCode button");
			}
		}
		
		/*get filteredProd Prices*/
		public synchronized int getFilteredProdPrice() {
			try {
				actionUtil.expliEleVisible(driver,txtFilteredproductPrice );
				return actionUtil.getElementTextInt(txtFilteredproductPrice);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to perform comparison between prices");
				Assert.fail("unable to  perform comparison between prices");
				return 0;
			}
		}
		
}
