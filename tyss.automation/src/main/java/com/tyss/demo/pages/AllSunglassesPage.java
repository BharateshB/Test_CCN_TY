package com.tyss.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class AllSunglassesPage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;
	
	/*constructor to initialize elements */
	public AllSunglassesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*search product text area*/
	@FindBy(xpath="//div[@id='sobe_d_b_1-carousel-viewport']//img[@alt=\"Men's sunglasses\"]")
	private WebElement lnkMenSunglasses;

	
	
	/*method to search Men's Sunglasses*/
	public synchronized void clickOnMenSunglassesLnk() {
		try {
			actionUtil.expliEleClickable(driver, lnkMenSunglasses);
			actionUtil.clickElement(lnkMenSunglasses);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on Men Sunglasses link");
			Assert.fail("unable to click on Men Sunglasses link");
		}
	}
	
}
