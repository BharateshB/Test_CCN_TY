package com.tyss.demo.commonUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverUtility {

	/*get the parent window id*/
	public String getParentId(WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	
	/*wait until element is visible*/
	public void expliEleVisible(WebDriver driver , WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/*switch to child window */
	public void switchToChildWindow(WebDriver driver, String ParentID) throws InterruptedException {
		Thread.sleep(2000);
	Set<String> childIDs=driver.getWindowHandles();
	Iterator<String> itr=childIDs.iterator();
	while(itr.hasNext()) {
		String childID=itr.next();
		if(!(ParentID.equals(childID))) {
			driver.switchTo().window(childID);
		}
	}
	}
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver , String parurltext) 
	{
	       Set<String> set = driver.getWindowHandles();
	        Iterator<String> it = set.iterator();

	          while (it.hasNext()) 
	          {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String acturl = driver.getCurrentUrl();
			          if(acturl.contains(parurltext)) 
			          {
			        	  break;
			          }
		    	}
	}
	
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void alertAccept(WebDriver driver ,String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) 
		 {
			 System.out.println("Alert Message is verified");
		 }
		 else 
		 {
			 System.out.println("Alert Message is not verified");
		 }
		 	alt.accept();
	}
	
	public void alertAccept(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
	
	
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) 
	{
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().equals(expectedMsg)) 
		 {
			 System.out.println("Alert Message is verified");
		 }
		 else 
		 {
			 System.out.println("Alert Message is not verified");
		 }
		 	alt.dismiss();
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) 
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) 
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDwon  based on visible text available in GUI
	 * @param element
	 * @param text
	 */
	public void selectbyvtext(WebElement element , String text) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option available in GUI
	 * @param element
	 * @param value
	 */
	public void selectbyvalue(WebElement element , String value) 
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 * @throws InterruptedException 
	 */
	public void mouseHoverOnElement(WebDriver driver , WebElement element) throws InterruptedException
	{
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to single click on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseHverSingleClick(WebDriver driver , WebElement element)
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	

	/**
	 * used to do mouse hover chain and click on specified element
	 * @param driver
	 * @param element1
	 * @param element2
	 */
	public void mouseHverChainClick(WebDriver driver , WebElement element1,WebElement element2)
	{
		expliEleVisible(driver, element1);
		Actions act = new Actions(driver);
		act.moveToElement(element1).moveToElement(element2).click().perform();
	}
	
	
	/**
	 * 	 used to hover on list of element
	 * @param driver
	 * @param elemnet
	 */
	public void hoverListElement(WebDriver driver,List<WebElement> elements) throws InterruptedException {
		for(WebElement ele:elements) {
			mouseHoverOnElement(driver, ele);
		}
	}
	
	public void hoverListAndPrintMoreNames(WebDriver driver,List<WebElement> elements,WebElement element, String data,List<WebElement> subelements) throws InterruptedException {
		
		for(WebElement ele:elements) {
			Thread.sleep(1000);
			expliEleVisible(driver, ele);
			mouseHoverOnElement(driver, ele);
			try {
			if(element.getAttribute("class").contains(data)) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("the sub options :"+element.getText());
				for(WebElement elem:subelements) {
					System.out.println(elem.getText());
				}
			}
			}
			catch(Exception e) {
				continue;
			}
		}
	}
	
	
public void hoverListAndPrintNamesAndPrice(WebDriver driver,List<WebElement> elements1,List<WebElement> elements2) throws InterruptedException {
		
		for(int i=0;i<elements1.size();i++) {
			Thread.sleep(1000);
			expliEleVisible(driver, elements1.get(i));
			System.out.print("the product name is :"+ elements1.get(i).getText());
			mouseHoverOnElement(driver, elements1.get(i));
			expliEleVisible(driver, elements2.get(i));
			System.out.print("and the product price is :"+ elements2.get(i).getText());
			System.out.println("");
		}
	}
	
public void hoverListImages(WebDriver driver,List<WebElement> elements) throws InterruptedException {
	
	for(int i=0;i<elements.size();i++) {
		Thread.sleep(1000);
		expliEleVisible(driver, elements.get(i));
		mouseHoverOnElement(driver, elements.get(i));
	}
}

	public void rightClickOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/*
	 * To scroll the page
	 * 
	 */
	public void scrollBy(WebDriver driver,int y)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")");
	}
	
	/*Assertions*/
	public void assertion(String s1,String s2, String msg) {
		Assert.assertEquals(s1, s2);
		System.out.println(msg);
	}
	
	/*select particular element based on text*/
	public void selectParticularProduct(WebDriver driver , List<WebElement> elements,String data) throws InterruptedException
	{
		Thread.sleep(1000);
		scrollBy(driver, 150);
		expliEleVisible(driver, elements.get(0));
		mouseHoverOnElement(driver, elements.get(0));
		for(WebElement elem:elements) {
			if(elem.getText().contains(data)) {
				elem.click();
				Thread.sleep(1000);
				break;
			}
		}
	}
	
	/*print all elements text */
	public void printElementsText(WebDriver driver , List<WebElement> elements)
	{
		for(WebElement elem:elements) {
			System.out.println(elem.getText());
	}
	}	
	
	}
	
