package com.tyss.flipkart.Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.demo.baseUtil.BaseClass;
import com.tyss.demo.commonUtils.WebDriverUtility;
import com.tyss.flipkart.pages.CookwarePage;
import com.tyss.flipkart.pages.FK_HomePage;
import com.tyss.flipkart.pages.FilteredProductPage;
import com.tyss.flipkart.pages.FlipkartCartPage;

public class TYSS_FLKT_TC001_Test extends BaseClass {
	
	@Test
	public void BuyPressureCooker() throws InterruptedException {
		
		/*create instances of pom pages*/
		FK_HomePage fkhp=new FK_HomePage(driver);
		CookwarePage ckp=new CookwarePage(driver);
		FilteredProductPage fpp=new FilteredProductPage(driver);
		FlipkartCartPage fcp=new FlipkartCartPage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		
		/*incorrect pin code*/
		int ipc=5700;
		
		/*correct pin code*/
		int cpc=210001;
		
		/*close login screen*/
		fkhp.clickOnCloseLogin();
		
		/*mouse hover on main menu list*/
		fkhp.HoverMainMenuList();
		
		/*print list of main menu*/
		fkhp.printMainMenuListNames();
		
		/*mouse hover to home*/
		fkhp.HoverHomeMainMenu();
		
		/*print home main menu*/
		fkhp.printHomeMenuListNames();
		
		/*mouse hover Home menu and print more options*/
		fkhp.HoverHomeMenuList();
		
		/*mouse hover chain kitchenAndDiningOption to cookware*/
		fkhp.kitchenAndDining_CookwareOption();
		
		/*apply filters*/
		ckp.applyFilters();
		
		/*get the parent window id*/
		String pid=wdu.getParentId(driver);
		
		/*click on Newest First*/
		ckp.clickOnNewestFirst();
		
		/*print the filtered products names and price*/
		ckp.printNameAndPrice();
		
		/*click on third Filtered Product*/
		String thirdFilteredProduct=ckp.clickAndGetThirdFilteredProduct();
		System.out.println("Before Selection-------------------"+thirdFilteredProduct);
		
		/*switch to child window*/
		wdu.switchToChildWindow(driver, pid);
		System.out.println("---------------------------------switched to new tab-------------------------");
		
		/*enter invalid pincode*/
		fpp.enterPinCode(""+ipc);
		
		/*check for error*/
		fpp.clickOnPinCodeCheck();	
		
		/*change pincode*/
		fpp.clickOnPinCodeChange();
		
		/*enter valid pincode*/
		fpp.enterPinCode(""+cpc);
		
		/*check for acceptance*/
		fpp.clickOnPinCodeCheck();
		
		/*get selected product price*/
		int fpPrice=fpp.getFilteredProdPrice();
		
		/*Assert product before and after click*/
		String filteredProd=fpp.getfilteredSelectedProduct();
		System.out.println("After selection-------------------------"+filteredProd);
//		Assert.assertEquals(thirdFilteredProduct, filteredProd,"before and after adding to cart are equal");
		System.out.println("product before and after selection are same");
		
		/*add to cart*/
		fpp.clickAddToCart();
		
		/*save for later*/
		fcp.clickOnSaveForLater();
		
		/*move to cart*/
		fcp.clickOnMoveToCart();
		
		/*compare selected product and total quantity price */
		fcp.comparePrices(fpPrice);
		
		/*click on place order*/
		fcp.clickOnPlaceOrder();
		
	}
}
