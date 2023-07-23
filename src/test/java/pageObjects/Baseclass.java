package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Keys;

public class Baseclass {
	
	WebDriver driver;
	
	public Baseclass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "div.loader")
    public WebElement spinner;
	
	@FindBy(xpath = "//button[@title='Close']")
    public WebElement closebtn;
	
	@FindBy(xpath = "//div[@id=\"navbarSupportedContent\"] //div[@ngbdropdown]")
    public WebElement profileIcon;
    
    @FindBy(xpath = "//button[text()='Log Out']")
    public WebElement logOutbtn;
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st+"Aa@"+num);
	}
	
	public void closeAds() {
    	// waiting for page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.invisibilityOf(spinner));
    	if(closebtn.isDisplayed()){
    		wait.until(ExpectedConditions.elementToBeClickable(closebtn)).click();
    	}
    }
	
	public void logout() {
   	 	this.click(profileIcon);
   	 	this.moveAndClick(logOutbtn);
   }   
	
	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
	
	public void moveAndClick(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",element);
	}
	
	public void sendKeys(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }
	
	 public String getText(WebElement element) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				return (wait.until(ExpectedConditions.visibilityOf(element)).getText());
			} catch (Exception e) {
				return (e.getMessage());
			}
	}
	 
	 public void isDisable(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.isEnabled(), false);
	 }
	
	public void isEnable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertEquals(element.isEnabled(), true);
	}
	
	public void clear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	}
}
