package com.tyss.FirstCry.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class FirstcryHomePage extends WebDriverUtility{
		/*create an instance of ActionUtility class*/
		ActionUtility actionUtil=new ActionUtility();
		WebDriver driver;
		
		/*constructor to initialize elements */
		public FirstcryHomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		/*All categories dropdown*/
		@FindBy(xpath="//div[@class='menu-container']//a[contains(text(),' All Categories')]")
		private WebElement ddAllCategories;
		
		/*gear link*/
		@FindBy(xpath="//div[@class='all-category-container']//span[@id='allmenu6']/preceding-sibling::a[contains(text(),'GEAR')]")
		private WebElement lnkGear;
		
		/*list of Featured Categories*/
		@FindBy(xpath="//div[@class='cpidContainer']//div[@class='html-desktop-data'][1]//img")
		private List<WebElement> lstFeaturedCategories;
		
		/*image of Bicycle gear*/
		@FindBy(xpath="//div[@class='cpidContainer']//div[@class='html-desktop-data'][1]//img[@title='Bicycles']")
		private WebElement imgBicycle;
		
		/*Health menu*/
		@FindBy(xpath="//div[@class='menu-container']//a[contains(text(),'Health')]")
		private WebElement mnuhealth;
		
		/*oral care link*/
		@FindBy(xpath="//div[@class='menu-option-container menu11']//ul[@class='col-one']//a[contains(text(),'Oral Care')]")
		private WebElement lnkOralCare;
		
		
		
		/*method to hover and display all categories*/
		public synchronized void displayAllCategories() {
			try {
				actionUtil.expliEleClickable(driver,ddAllCategories );
				mouseHoverOnElement(driver, ddAllCategories);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to perform hover action on All categories");
				Assert.fail("unable to click on hover action on All categories");
			}
		}
		
		/*method to select gear*/
		public synchronized void clickGearLink() {
			try {
				actionUtil.expliEleClickable(driver,lnkGear );
				actionUtil.clickElement(lnkGear);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to click on gear link");
				Assert.fail("unable to click on gear link");
			}
		}
		
		
		/*print list of Featured Categories*/
		public synchronized void printFeaturedCategories() {
			try {
				actionUtil.expliElementsVisible(driver, lstFeaturedCategories);
				actionUtil.printProductUsingAttribute(lstFeaturedCategories, "title");
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to print the list of Featured Categories");
				Assert.fail("unable to print list of Featured Categories");
			}
		}
		
		/*method to select Bicycle gear*/
		public synchronized void clickBicycleImg() {
			try {
				actionUtil.expliEleClickable(driver,imgBicycle );
				actionUtil.clickElement(imgBicycle);
				Thread.sleep(1000);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to click on Bicycle image");
				Assert.fail("unable to click on Bicycle image");
			}
		}
		
		/*method to hover and display all categories*/
		public synchronized void displayHealthOptions() {
			try {
				actionUtil.expliEleVisible(driver,mnuhealth );
				mouseHoverOnElement(driver, mnuhealth);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to perform hover action on HealthOptions");
				Assert.fail("unable to click on hover action on HealthOptions");
			}
		}
		
		/*method to select OralCare*/
		public synchronized void clickOralCare() {
			try {
				actionUtil.expliEleClickable(driver,lnkOralCare );
				actionUtil.clickElement(lnkOralCare);
				Thread.sleep(1000);
			}
			catch(Exception e){
				actionUtil.printExceptionMsg(e.getMessage());
				actionUtil.printErrorMsg("unable to click on OralCare");
				Assert.fail("unable to click on OralCare");
			}
		}
		
		
		
		
		
		
		
}
