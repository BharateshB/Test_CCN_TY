package com.tyss.magentoAutomation.TestCase;

import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tyss.demo.baseUtil.BaseClass;
import com.tyss.demo.commonUtils.WebDriverUtility;
import com.tyss.magento.pages.MagentoCartPage;
import com.tyss.magento.pages.MagentoSelectedProductPage;
import com.tyss.magento.pages.Magento_HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TYSS_Magento_TC001_Test extends BaseClass{

	@Test
	public void chooseGear() throws InterruptedException {
		
		/*create instances of pom pages*/
		Magento_HomePage mhp=new Magento_HomePage(driver);
		MagentoSelectedProductPage mspp=new MagentoSelectedProductPage(driver);
		MagentoCartPage mcp=new MagentoCartPage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		
		int qty=2;
		
		/*mouse hover on gear menu*/
		mhp.HoverGearMenu();
		
		/*click on Bags link*/
		mhp.clickBagsLink();
		
		/*print the list of bags name*/
		mhp.printBagsName();
		
		/*click on first bag link*/
		mhp.clickFirstBagLink();
		
		/*enter the quantity */
		mspp.enterQty(""+qty);
		
		/*click on add to cart*/
		mspp.clickOnAddToCart();
		
		/*click on cart image*/
		mspp.clickOnCartImage();
		
		/*print the cart items*/
		mcp.checkCart();
		
		/*remove cart items*/
		mcp.clickRemoveCartItem();
		
		/*print msg after deletion*/
		mcp.getRemoveCartItemMsg();
	}
}



