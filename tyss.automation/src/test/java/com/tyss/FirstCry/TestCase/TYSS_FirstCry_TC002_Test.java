package com.tyss.FirstCry.TestCase;

import org.testng.annotations.Test;

import com.tyss.FirstCry.pages.FirstcryCartPage;
import com.tyss.FirstCry.pages.FirstcryHomePage;
import com.tyss.FirstCry.pages.Firstcry_Bicycle_page;
import com.tyss.FirstCry.pages.Firstcry_Selected_TP_Page;
import com.tyss.demo.baseUtil.BaseClass;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class TYSS_FirstCry_TC002_Test extends BaseClass{

	
	@Test
	public void shopOralCare() throws InterruptedException {
		
		/*create instances of pom pages*/
		FirstcryHomePage fhp=new FirstcryHomePage(driver);
		Firstcry_Selected_TP_Page ftp=new Firstcry_Selected_TP_Page(driver);
		FirstcryCartPage fcp=new FirstcryCartPage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		
		/*Toothpaste name to select and verify*/
		String toothpasteName="DentoShine";
		
		/*display health options*/
		fhp.displayHealthOptions();
		
		/*click on oralcare*/
		fhp.clickOralCare();
		
		/*select filter toothpaste*/
		ftp.clickToothPasteChk();
		
		/*filter new arrival*/
		ftp.selectNewArrival();
		
		/*print filtered toothpaste name and price*/
//		ftp.PrintNameAndPrice();
		
		/*get parent id*/
		String parentid=wdu.getParentId(driver);
		
		/*select particular toothpaste*/
		ftp.selectToothpaste(toothpasteName);
		
		/*switch to product tab and print combo contents*/
		ftp.printComboContents(parentid);
		
		/*print the expiry date*/
		ftp.printExpiryDate();
		
		/*mouse hover on all sideimages*/
		ftp.hoverAllImages();
		
		/* click on ShortList*/
		fcp.clickShortlist();
		
		/*click on Add to cart*/
		fcp.clickAddToCart();
		
		
		/*click on Go to cart*/
		fcp.clickGoToCart();
		
		/*login to place order*/
		fcp.clickbtnLoginToPlaceOrder();
	}
}
