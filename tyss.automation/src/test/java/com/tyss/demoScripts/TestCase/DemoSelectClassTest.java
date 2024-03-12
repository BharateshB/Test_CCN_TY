package com.tyss.demoScripts.TestCase;



import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Position;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSelectClassTest {
	//Select option form get options and print options
	public WebDriver driver;
	
	@BeforeMethod()
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		 driver.manage().window().maximize();
//		Dimension d=new Dimension(1024,768);
//		 driver.manage().window().setSize(d);
		 
	
	}
	
	@Test(enabled=false)
	public void selectTest() {
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement selEle=driver.findElement(By.xpath("//div[@rel-title='Select Country']//select"));
		Wait<WebDriver> wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(selEle));
		System.out.println("x position "+selEle.getLocation().getX());
		System.out.println("y position "+selEle.getLocation().getY());
		Select sel=new Select(selEle);
		List<WebElement> options = sel.getOptions();
		TreeSet<String> ts=new TreeSet<String>();
		for(WebElement ele:options) {
			ts.add(ele.getText());
		}
		for(WebElement ele:options) {
			if(ele.getText().equalsIgnoreCase("India")) {
				ele.click();
				break;
			}
		}
		
		for(String txt:ts) {
			System.out.println(txt);
		}
	}
	
	
	@Test(enabled =true)
	public void handleSlider() throws InterruptedException {
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String eleText = driver.findElement(By.xpath("//div[@class='page_heading']//h1")).getAttribute("innerHTML");
		System.out.println("----------------------"+eleText);
		
		
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frameEle);
		
		WebElement eleRange = driver.findElement(By.xpath("//div[@id='green']"));
		Wait<WebDriver> wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(eleRange));
		System.out.println("range is "+eleRange.getSize().getWidth());
		
		WebElement eleSlider = driver.findElement(By.xpath("//body[@class='ui-widget-content']//div[@id='green']/span[contains(@class,'ui-slider-handle')]"));
		Wait<WebDriver> wait2=new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.elementToBeClickable(eleSlider));
		System.out.println("x position before sliding "+eleSlider.getLocation().getX());
		System.out.println("y position before sliding "+eleSlider.getLocation().getY());
		Actions action=new Actions(driver);
		action.moveToElement(eleSlider).click().dragAndDropBy(eleSlider, 25, 0).build().perform();
//		 for (int i = 1; i <= 10 ; i++) {
//			 eleSlider.sendKeys(Keys.ARROW_RIGHT);
//	        }
		Thread.sleep(1000);
		System.out.println("x position after sliding "+eleSlider.getLocation().getX());
		System.out.println("y position after sliding "+eleSlider.getLocation().getY());
//		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("i").build().perform();
		
		
		}
	
//date picker 
		@Test(enabled =false)
		public void datePicker() {
			driver.get("https://www.globalsqa.com/demo-site/datepicker/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			String dd="18";
			String mm="May";
			String yy="2023";
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)","");
			WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
			driver.switchTo().frame(frameEle);
			
			WebElement eleDate = driver.findElement(By.xpath("//input[@id='datepicker']"));
			Wait<WebDriver> wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(eleDate));
			Date date=new Date();
			String dateStr=date.toString();
			String dateArr[]=dateStr.split(" ");
			String crtDate=dateArr[2];
			System.out.println(date+" and todays date is "+crtDate);
//			SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
//			String newFormat=df.format(date);
//			eleDate.sendKeys(newFormat);
//			Actions action=new Actions(driver);
//			action.sendKeys(Keys.ENTER).build().perform();
			
					
			eleDate.click();
//			
			for(int i=0;i<5;i++) {
			try {
			WebElement dateSel = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[contains(text(),'"+mm+"')]/following-sibling::span[contains(text(),'"+yy+"')]//ancestor::div[@id='ui-datepicker-div']//table//a[text()='"+crtDate+"']"));
				wait.until(ExpectedConditions.visibilityOf(dateSel));
				dateSel.click();
				Thread.sleep(2000);
				break;
			}
			catch(Exception e) {
//				
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			}
			
		}	

}
