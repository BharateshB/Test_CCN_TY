package com.tyss.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.demo.commonUtils.ActionUtility;
import com.tyss.demo.commonUtils.WebDriverUtility;

public class FK_HomePage extends WebDriverUtility{
	/*create an instance of ActionUtility class*/
	ActionUtility actionUtil=new ActionUtility();
	WebDriver driver;

	
	/*constructor to initialize elements */
	public FK_HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*login close button*/
	@FindBy(xpath="//button[contains(text(),'✕')]")
	private WebElement btnCloseLogin;
	
	/*hover main menu list*/
	@FindBy(xpath="//div[@id='container']//div[@class='eFQ30H']//a")
	private List<WebElement> lstMainMenu ;
	
	@FindBy(xpath="(//div[@class='eFQ30H']//div[@class='_1mkliO'])[3]")
	private WebElement thirdmenu;
	
	/*list of Main menu*/
	@FindBy(xpath="//div[@class='InyRMC _3Il5oO']//div[@class='xtXmba']")
	private List<WebElement> lstMainMenuName ;
	
	/*Home dropdown*/
	@FindBy(xpath="//div[@class='InyRMC _3Il5oO']//a//div[contains(text(),'Home')]")
	private WebElement ddHome;
	
	/*Home Dropdown options*/
	@FindBy(xpath="//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E']//div[@class='_3XS_gI _7qr1OC']//a")
	private List<WebElement> lstHomeDdOptions ;
	
	
	/*More on Home drop down option name*/
	@FindBy(xpath="//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E']//div[@class='_3XS_gI _7qr1OC']//a/parent::div/following-sibling::div/span")
	private WebElement HomeMoreOnSubOptionName;
	
	/*Home menu sub options dropdown list*/
	@FindBy(xpath="//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E']//div[@class='_3XS_gI _7qr1OC']//a/parent::div/following-sibling::div/span/following-sibling::a")
	private List<WebElement> lstHomeSubOptionsDd ;
	
	/*Kitchen & Dining option*/
	@FindBy(xpath="//div[@class='_1y9fNR']//div[@class='_3XS_gI _7qr1OC']//a[contains(text(),'Kitchen & Dining')]")
	private WebElement optKitchenAndDining ;
	
	
	/*Kitchen & Dining - cookware option*/
	@FindBy(xpath="//div[@class='_3_Fivj']//div[@class='_3XS_gI']//a[contains(text(),'Cookware')]")
	private WebElement optCookware ;
	
	
	/*method to close login screen*/
	public synchronized void clickOnCloseLogin() {
		try {
			actionUtil.expliEleClickable(driver,btnCloseLogin );
			actionUtil.clickElement(btnCloseLogin);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to perform click action on close login");
			Assert.fail("unable to click on close login");
		}
	}
	
	/*print list of main menu*/
	public synchronized void printMainMenuListNames() {
		try {
			actionUtil.expliElementsVisible(driver, lstMainMenuName);
			actionUtil.printListElementText(lstMainMenuName, "list of main menu");
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print the main menu list");
			Assert.fail("unable to print main menu list");
		}
	}
	
	/*Mouse hover list of main menu*/
	public synchronized void HoverMainMenuList() {
		try {
			actionUtil.expliElementsVisible(driver, lstMainMenu);
			hoverListElement(driver, lstMainMenu);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to mouse hover the main menu list");
			Assert.fail("unable to mouse hover main menu list");
		}
	}
	
	/*mouse hover Home menu options*/
	public synchronized void HoverHomeMainMenu() {
		try {
			actionUtil.expliEleVisible(driver,ddHome );
			mouseHoverOnElement(driver,ddHome);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to mouse hover the home menu list");
			Assert.fail("unable to mouse hover home menu list");
		}
	}
	
	/*print list of Home menu options*/
	public synchronized void printHomeMenuListNames() {
		try {
			actionUtil.expliElementsVisible(driver, lstHomeDdOptions);
			actionUtil.printListElementText(lstHomeDdOptions, "list of Home menu options");
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to print the home menu list");
			Assert.fail("unable to print home menu list");
		}
	}
	
	/*Mouse hover list of Home menu and sub menu*/
	public synchronized void HoverHomeMenuList() {
		try {
			actionUtil.expliElementsVisible(driver, lstHomeDdOptions);
			hoverListAndPrintMoreNames(driver, lstHomeDdOptions,HomeMoreOnSubOptionName,"xtXmba",lstHomeSubOptionsDd);
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to mouse hover the home menu list");
			Assert.fail("unable to mouse hover home menu list");
		}
	}
	
	/*Mouse hover chain kitchenAndDining to cookware*/
	public synchronized void kitchenAndDining_CookwareOption() {
		try {
			actionUtil.expliEleVisible(driver, optKitchenAndDining);
//			mouseHverChainClick(driver, optKitchenAndDining,optCookware);
			mouseHoverOnElement(driver, ddHome);
			mouseHoverOnElement(driver, optKitchenAndDining);
			mouseHverSingleClick(driver, optCookware);
			
		}
		catch(Exception e){
			actionUtil.printExceptionMsg(e.getMessage());
			actionUtil.printErrorMsg("unable to mouse hover on kitchenAndDiningOption");
			Assert.fail("unable to mouse hover on kitchenAndDiningOption");
		}
	}

}
