package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoderedRegister extends Baseclass {
	
	public CoderedRegister(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	// 
	@FindBy(xpath = "(//a[text()='Get Free Access'])[1]")
	WebElement getfree ;
	
	@FindBy(xpath ="(//input[@placeholder='First Name'])")
	WebElement firstname;
	
	@FindBy(xpath ="(//input[@placeholder='Email'])")
	WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Password'])")
	WebElement psswrd;
	
    @FindBy(xpath = "//app-select[@defaultvalue='Country']")
    WebElement countryid;
    
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement chkbox;
    
    @FindBy(xpath = "//button[@title='Close']")
    WebElement closebtn;
    
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement submit;
    
    @FindBy(xpath = "//h2")
    WebElement header;
    
    @FindBy(xpath = "//a[text()='Start']")
    WebElement strtbtn;
    
    @FindBy(xpath = "(//button[@type='button'])[1]")
    WebElement nxtbtn;
    
    
    public void clickGetfreeaccess() {
    	mywait.until(ExpectedConditions.elementToBeClickable(getfree)).click();
		mywait.until(ExpectedConditions.elementToBeClickable(chkbox)).click();
	}
    
    public void setfirstname(String fname) {
    	mywait.until(ExpectedConditions.elementToBeClickable(firstname)).sendKeys(fname);
    }
    
    public void setemail(String Email) {
    	mywait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(Email);
    }
    
    public void setpassword(String passwrd) {
    	mywait.until(ExpectedConditions.elementToBeClickable(psswrd)).sendKeys(passwrd);
    }

    
    public void clickCountry() {
    	mywait.until(ExpectedConditions.elementToBeClickable(countryid)).click();
//    	countryid.click();
	}
    
    public void clickoption(String option) {
    	driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(option);
    	List<WebElement> list	= driver.findElements(By.xpath("//li[@role='option']"));
   
    		for(int i=0; i<list.size(); i++) {
    			
    			if(list.get(i).getText().equals(option)){
    				mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    				break;
    			}
    		}
	}
    
    public void closepopup() {
    	if(closebtn.isDisplayed()){
    		System.out.println("Popup is visible");
    		mywait.until(ExpectedConditions.elementToBeClickable(closebtn)).click();
    	}
    }
    
    public void submit() {
    	mywait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
    
    
    public String getSucessMsg() {
		try {
			return (mywait.until(ExpectedConditions.visibilityOf(header)).getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
    
    public void strtbutton() {
    	mywait.until(ExpectedConditions.elementToBeClickable(strtbtn)).click();
	}
    
    public void options() {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	int totaloptions = list.size();
    	for(int i=0; i<totaloptions-5;i++) {
    		mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    	
    }
    
    public void nextbtn() {
    	mywait.until(ExpectedConditions.elementToBeClickable(nxtbtn)).click();
	}
    
}
