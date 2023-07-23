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
	 
	@FindBy(xpath ="(//input[@placeholder='First Name'])[1]")
	public WebElement firstname;
	
	@FindBy(xpath ="(//input[@placeholder='Email'])[1]")
	public WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Password'])[1]")
	public WebElement psswrd;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement chkbox;
	    
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement submit;
	
	@FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;
	    
	@FindBy(xpath = "//span[@patternalidationerror]")
	public WebElement invalidPasswrd;
	
}
