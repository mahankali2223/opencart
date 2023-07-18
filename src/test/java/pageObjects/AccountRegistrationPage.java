package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends Baseclass {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
//			@FindBy(xpath = "//input[@id='input-username']")
//			WebElement txtUsername;
			
			@FindBy(xpath = "//input[@id='input-firstname']")
			WebElement txtFirstname;
			
			@FindBy(xpath = "//input[@id='input-lastname']")
			WebElement txtLastname;
			
			@FindBy(xpath = "//input[@id='input-email']")
			WebElement txtEmail;
			
//			@FindBy(xpath = "//select[@id='input-country']")
//			WebElement txtCountrydrp;
//			
//			@FindBy(xpath = "//option[text()='Angola']")
//			WebElement txtdrpdown;
			
			@FindBy(xpath = "//input[@name='password']")
			WebElement txtpassword;
			
			@FindBy(name = "agree")
			WebElement chkdPolicy;
//			
//			@FindBy(xpath = "//div[@class='bg-success']")
//			WebElement txtSuccessmsg;
			
//			@FindBy(xpath = "(//div[@id='button-register']/button)[1]")
//			WebElement txtbutton;
			
			@FindBy(xpath = "//input[@value='Continue']")
			WebElement btnContinue;
			
			@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
			WebElement msgConfirmation;
			
//			@FindBy(xpath = "//h3")
//			WebElement msgConfirmation;
			
//			public void setUserName(String username) {
//				txtUsername.sendKeys(username);
//
//			}

			public void setFirstName(String fname) {
				txtFirstname.sendKeys(fname);
			}
			
			public void setLastName(String Lname) {
				txtLastname.sendKeys(Lname);
			}
			
			public void setEmail(String email) {
				txtEmail.sendKeys(email);
			}
			
//			public void clickCountryDrp() {
//				txtCountrydrp.click();
//			}
//
//			public void selectDropDown() {
//				txtdrpdown.click();
//				
//			}
			
			public void setPassword(String password) {
				txtpassword.sendKeys(password);
			}
//			
//			public String getSucessMsg() {
//				try {
//					return (txtSuccessmsg.getText());
//				} catch (Exception e) {
//					return (e.getMessage());
//
//				}
//
//			}
			
//			public void  clickRegisterbutton() {
//				txtbutton.click();
//					
//			}
			
			public void setPrivacyPolicy() {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", chkdPolicy);
//			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			mywait.until(ExpectedConditions.elementToBeClickable(chkdPolicy)).click();
			
			}
			
			public void clickContinue() {
				btnContinue.click();
			}
			
			public String getConfirmationMsg() {
				try {
					return (msgConfirmation.getText());
				} catch (Exception e) {
					return (e.getMessage());

				}

			}
			
}
