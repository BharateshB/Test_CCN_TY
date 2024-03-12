package com.tyss.demoScripts.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.demo.baseUtil.BaseClass;
import com.tyss.demo.commonUtils.WebDriverUtility;
import com.tyss.demo.pages.AllSunglassesPage;
import com.tyss.demo.pages.Amazon_HomePage;
import com.tyss.demo.pages.CartPage;
import com.tyss.demo.pages.MenSunglassesPage;
import com.tyss.demo.pages.SelectedSunglassPage;

public class TYSS_TC002_Test extends BaseClass {
	
	@Test
	public void buySunglasses() throws InterruptedException {
		Amazon_HomePage ahp=new Amazon_HomePage(driver);
		CartPage cp=new CartPage(driver);
		AllSunglassesPage asp=new AllSunglassesPage(driver);
		MenSunglassesPage msp=new MenSunglassesPage(driver);
		SelectedSunglassPage ssp=new SelectedSunglassPage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		
		/*click on All menu*/
		ahp.allMenu();
		
		/*click on on MenFashion link*/
		ahp.clickOnMensFashion();
		
		/*click on Sunglasses link*/
		ahp.clickOnSunglassesLnk();
		
		/*click on Men Sunglasses link*/
		asp.clickOnMenSunglassesLnk();
		
		/*apply filters*/
		msp.applySgFilters();
		
		/*print the filtered sunglasses name and price*/
		msp.printSunglassesNameAndPrice();
		
		/*get the parent window id*/
		String pid=wdu.getParentId(driver);
		
		/*click on filtered sunglass*/
		msp.clickOnFilteredSunglass();
		
		Thread.sleep(2000);

		/*switch to child window*/
		wdu.switchToChildWindow(driver, pid);
		
		/*scroll vertically*/
		wdu.scrollBy(driver, 100);
		
		/*get the product price before adding to cart*/
		int prodPriceBef=ssp.getProductPrice();
		System.out.println("the product price before adding to cart is :"+prodPriceBef);
		
		/*click on add to cart*/
		ssp.addToCart();
		
		/*verify the product is added to cart*/
		String cartMsg=ssp.getMsgAddedToCart();
		Assert.assertEquals(cartMsg.contains("Added to Cart"), true,"product not added to cart");
		System.out.println("product added to cart successfully");
		
		/*go to cart*/
		ssp.goToCart();
		
		/*get product price from the cart and compare with the product price before added to cart*/
		int cartProdPrice=cp.getCartProductPrice();
		Assert.assertEquals(prodPriceBef, cartProdPrice,"before and after adding to cart not equal");
		System.out.println("price before and after adding to cart are same");
		
		/*click on quantity dropdown*/
		cp.clickOnQtyDropdown();
		
		/*select quantity*/
		cp.selectQty();
		
		/*proceed to buy*/
		cp.clkProceedToBuy();
	}
}
