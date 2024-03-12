package com.tyss.demo.commonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionUtility extends WebDriverUtility{

	WebDriver driver;

	public void impliwait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**
	 *   it's an Explicit wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
		public void expliurl(WebDriver driver , String partailPageURL) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.urlContains(partailPageURL));
		}	
		
		/**
		 * it will wait till the title contains particular text 
		 * @para driver
		 * @para text
		 */
		public void explititle(WebDriver driver , String text) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.titleContains(text));
			
		}	
	
	/**
	 *   it's an Explicit wait Always wait for visibility of an element
	 * @param driver
	 * @param webelement
	 */
		public void expliEleVisible(WebDriver driver , WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 *   it's an Explicit wait Always wait for visibility of list of elements
		 * @param driver
		 * @param webelements
		 */
		public void expliElementsVisible(WebDriver driver , List<WebElement> elements) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}
		
		/**
		 *   it's an Explicitly wait Always wait for element is visible and clickable
		 * @param driver
		 * @param webelement
		 */
		public void expliEleClickable(WebDriver driver , WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/* enter the data to the required text field*/
		public void enterTextElement(WebElement element, String data) throws InterruptedException {
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(data);
		}
		
		/* get the data from the required attribute*/
		public String getAttributeText(WebElement element, String attributeName) {
			return element.getAttribute(attributeName);
		}
		
		/* click on the particular element*/
		public void clickElement(WebElement element) {
			element.click();
		}
		
		/*print the message caused by exception*/
		public void printExceptionMsg(String msg) {
			System.out.println("the exception is : "+msg);
		}
		
		/* print the error message*/
		public void printErrorMsg(String msg) {
			System.out.println("the error msg is : "+msg);
		}
		
		public String getElementText(WebElement element) {
			return element.getText();
		}
		
		public void EleTextContains(WebElement element, String msg) {
			Boolean status= element.getText().contains(msg);
			if(status){
				System.out.println("--------------------------------------Pin code message is validated");
			}
			else {
				System.out.println("--------------------------------------Pin code message not validated");
			}
		}
		
		public void printListElementText(List<WebElement> elements, String message) {
			System.out.println("-----------------------------------------------------");
			System.out.println(message);
			for(WebElement ele:elements) {
				System.out.println(ele.getText());
			}
		}
		
		
		public int getTextIntWithoutDecimal(WebElement element) {
			String text=element.getText().trim();
//			System.out.println("after adding to cart :"+text);
			String []strArr=text.split("[.]");
			String intValue=strArr[0].replaceAll("[^0-9]", "");
			return Integer.parseInt(intValue);
		}
		
		
		public int getElementTextInt(WebElement element) {
			String text=element.getText();
			text=text.replaceAll("[^0-9]", "");
			return Integer.parseInt(text);
		}
		
		public void printElementText(WebElement element) {
			System.out.println(element.getText());
		}
		
		
		public Boolean compareElementTexts(String s1,String s2) {
			return s1.equals(s2)?true:false;
		}
		
		public Boolean compareElementTexts(int i1,int i2) {
			return (i1==i2)?true:false;
		}
		
		public void printNameAndPrice(List<WebElement> productNamesList,List<WebElement> productPriceList) {
			String product_name="";
			int int_product_price=0;
			HashMap<String,Integer> map_final_products = new HashMap<String,Integer>();
		for(int i=0;i<productNamesList.size();i++) {
			product_name = productNamesList.get(i).getText();//Iterate and fetch product name
//			System.out.println("name is :"+(product_name)+"and price is :"+int_product_price);
			int_product_price =getElementTextInt(productPriceList.get(i));
			map_final_products.put(product_name,int_product_price);//Add product and price in HashMap
		}
		for (String key: map_final_products.keySet()){
            System.out.println("product name is : "+ key +" and it's price is : "+map_final_products.get(key));
        }
		}
		
		/*Print the product name and price referring attribute title*/
		public void printNameAndPriceRefTitle(List<WebElement> productNamesList,List<WebElement> productPriceList) {
			String product_name="";
			int int_product_price=0;
			HashMap<String,Integer> map_final_products = new HashMap<String,Integer>();
		for(int i=0;i<productNamesList.size();i++) {
			product_name = productNamesList.get(i).getAttribute("title");//Iterate and fetch product name
			System.out.println("----------------------------------------------");
//			System.out.println("name is :"+(product_name)+"and price is :"+int_product_price);
			int_product_price =getElementTextInt(productPriceList.get(i));
			map_final_products.put(product_name,int_product_price);//Add product and price in HashMap
		}
		for (String key: map_final_products.keySet()){
            System.out.println("product name is : "+ key +" and it's price is : "+map_final_products.get(key));
        }
		}
		
		/*Print the product referring attribute*/
		public void printProductUsingAttribute(List<WebElement> productNamesList,String attributeName) {
			String product_name="";
		for(int i=0;i<productNamesList.size();i++) {
			product_name = productNamesList.get(i).getAttribute(attributeName);//Iterate and fetch product name
			System.out.println(product_name);
		}
		}
		
		
		
		
		
}
