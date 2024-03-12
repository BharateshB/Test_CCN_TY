package com.tyss.demoScripts.TestCase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.demo.baseUtil.BaseClass;
import com.tyss.demo.commonUtils.WebDriverUtility;
import com.tyss.demo.pages.Amazon_HomePage;
import com.tyss.demo.pages.CartPage;
import com.tyss.demo.pages.SearchedProductPage;
import com.tyss.demo.pages.SelectedProductPage;
/*
 * Testcase id: TC001
 * TestScript name: TYSS_TC001
 * Description: Verify the user is able to delete the product successfully after it is added to cart 
 */



public class TYSS_TC001_Test extends BaseClass{
	

	@Test
	public void buyLaptop() throws InterruptedException {
		/*initialize the product to be searched*/
		String product="laptops";
		
		
		/* create an instance of pom pages*/
		Amazon_HomePage ahp=new Amazon_HomePage(driver);
		SearchedProductPage spp=new SearchedProductPage(driver);
		SelectedProductPage selPP=new SelectedProductPage(driver);
		CartPage cp=new CartPage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		
		/*enter the product and click on search button*/
		ahp.searchProduct(product);
		Thread.sleep(2000);
		
		/*apply filters*/
		spp.applyFilters();
		
		
		/*print the filtered laptop name with price*/
		spp.printNameAndPrice();
		
		/*get the parent window id*/
		String pid=wdu.getParentId(driver);
		
		/*click on first filtered product*/
		spp.clickOnFirstFilteredProduct();
		
		Thread.sleep(2000);

		/*switch to child window*/
		wdu.switchToChildWindow(driver, pid);
		
		/*scroll vertically*/
		wdu.scrollBy(driver, 150);
		
		/*get the product price before adding to cart*/
		int prodPriceBef=selPP.getProductPrice();
//		System.out.println("the product price before adding to cart is :"+prodPriceBef);
		
		/*click on add to cart*/
		selPP.addToCart();
		
		/* Added to Cart*/
		String cartMsg=selPP.getMsgAddedToCart();
		Assert.assertEquals(cartMsg.contains("Added to Cart"), true,"product not added to cart");
		System.out.println("product added to cart successfully");
		
		/*click on cart button*/
		selPP.clickOnCart();
		
		/*get product price from the cart and compare with the product price before added to cart*/
		int cartProdPrice=cp.getCartProductPrice();
		Assert.assertEquals(prodPriceBef, cartProdPrice,"before and after adding to cart not equal");
		System.out.println("price before and after adding to cart are same");
		
		
		/*delete the added product from cart*/
		cp.clickOnDeleteBtn();
		System.out.println("successfully deleted");
	}
}
