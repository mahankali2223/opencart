package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoderedRegister2 extends Baseclass {
	
	public CoderedRegister2(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
	@FindBy(xpath ="(//input[@placeholder='First Name'])[1]")
	WebElement firstname;
	
	@FindBy(xpath ="(//input[@placeholder='Email'])[1]")
	WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Password'])[1]")
	WebElement psswrd;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement chkbox;
	    
	@FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement submit;
	
	public void setfirstname(String fname) {
    	mywait.until(ExpectedConditions.elementToBeClickable(firstname)).sendKeys(fname);
    }
    
    public void setemail(String Email) {
    	mywait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(Email);
    }
    
    public void setpassword(String passwrd) {
    	mywait.until(ExpectedConditions.elementToBeClickable(psswrd)).sendKeys(passwrd);
    }
    
    public void clickCheckbox() {
    	mywait.until(ExpectedConditions.elementToBeClickable(chkbox)).click();
    }
    
    public void clickSubmit() {
    	mywait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
}
