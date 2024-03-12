package com.tyss.FirstCry.TestCase;

import org.testng.annotations.Test;

import com.tyss.FirstCry.pages.FirstcryCartPage;
import com.tyss.FirstCry.pages.FirstcryHomePage;
import com.tyss.FirstCry.pages.Firstcry_Bicycle_page;
import com.tyss.demo.baseUtil.BaseClass;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class TYSS_FirstCry_TC001_Test extends BaseClass{

	
	@Test
	public void shopBicycle() throws InterruptedException {
		
		/*create instances of pom pages*/
		FirstcryHomePage fhp=new FirstcryHomePage(driver);
		Firstcry_Bicycle_page fbp=new Firstcry_Bicycle_page(driver);
		FirstcryCartPage fcp=new FirstcryCartPage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		
		/*Display All categoies*/
		fhp.displayAllCategories();
		
		/*click on gear link*/
		fhp.clickGearLink();
		
		/*print list of Featured Categories*/
		fhp.printFeaturedCategories();
		
		/*get the parent id*/
		String pid=wdu.getParentId(driver);
		
		/*select Bicycle*/
		fhp.clickBicycleImg();
		
		/*switch window and select age filter*/
		fbp.clickFilterAge(pid);
		
		
		/*select price filter*/
		fbp.clickFilterPrice();
		
		/*select newer arrival*/
		fbp.selectNewArrival();
		
		/*print filtered bicycle names and price*/
		fbp.PrintNameAndPrice();
		
		/*get the parent id of bicycle tab*/
		String pid2=wdu.getParentId(driver);
		
		/*click on first product*/
		fbp.clickFirstbicycle();
		
		/* Switch window and click on ShortList*/
		fcp.clickShortlist(pid2);
		
		/*click on Add to cart*/
		fcp.clickAddToCart();
		
		/*click on Go to cart*/
		fcp.clickGoToCart();
		
		/*login to place order*/
		fcp.clickbtnLoginToPlaceOrder();
		
	}
}
