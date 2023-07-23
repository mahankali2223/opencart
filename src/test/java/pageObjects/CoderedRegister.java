package pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CoderedRegister extends Baseclass {
	
	public CoderedRegister(WebDriver driver) {
		super(driver);
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st+"Aa@"+num);
	}
	
	public String name = this.randomString();
	
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
    
    @FindBy(xpath = "div.loader")
    WebElement spinner;
    
    @FindBy(xpath = "//a[text()='Go To Dashboard']")
    WebElement dashboard;
    
    @FindBy(xpath = "//h1")
    WebElement thankMsg;
    
    @FindBy(xpath = "//app-right-side-header//h2")
    WebElement dashboardMsg;
    
    @FindBy(xpath = "//div[@id=\"navbarSupportedContent\"] //div[@ngbdropdown]")
    WebElement profileIcon;
    
    @FindBy(xpath = "//button[text()='Log Out']")
    WebElement logOutbtn;
    
    public void clickGetfreeaccess() {
    	mywait.until(ExpectedConditions.elementToBeClickable(getfree)).click();
    	mywait.until(ExpectedConditions.invisibilityOf(spinner));
	}
    
    public void setfirstname(String fname) {
    	mywait.until(ExpectedConditions.elementToBeClickable(firstname)).sendKeys(fname);
    }
    
    public void setemail(String Email) {
    	mywait.until(ExpectedConditions.elementToBeClickable(email)).clear();
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
    
    public void closeAds() {
    	// waiting for page to load
    	mywait.until(ExpectedConditions.invisibilityOf(spinner));
    	if(closebtn.isDisplayed()){
    		mywait.until(ExpectedConditions.elementToBeClickable(closebtn)).click();
    	}
    }
    
    public void clickCheckbox() {
    	mywait.until(ExpectedConditions.elementToBeClickable(chkbox)).click();
    }
    
    public void clickSubmit() {
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
    
    public void options(int numberofoptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	for(int i=0; i<numberofoptions;i++) {
    		mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    	
    }
    
    public void nextbtn() {
    	mywait.until(ExpectedConditions.elementToBeClickable(nxtbtn)).click();
	}
    
    public void selectCareerGoals(int numOfOptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//label/p"));
    	for(int i=0; i<numOfOptions;i++) {
    		mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    }
    
//    public void clickdashboard(WebElement buttonName) {
//    	mywait.until(ExpectedConditions.elementToBeClickable(buttonName)).click();
//	}
    
    public void clickdashboard() {
    	mywait.until(ExpectedConditions.elementToBeClickable(dashboard)).click();
	}
    
    public String getThanksMsg() {
		try {
			return (mywait.until(ExpectedConditions.visibilityOf(thankMsg)).getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
    
    public String getDashboardMsg() {
		try {
			return (mywait.until(ExpectedConditions.visibilityOf(dashboardMsg)).getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
    
    public void clickProfileIcon() {
    	mywait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
	}
    
    public void clickLogoutBtn() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",logOutbtn);
	}
    
    public void proceedToNextStep() throws InterruptedException {
    	try {
    		String confirm = getSucessMsg();
		    // Checking Message on screen
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
		    Assert.assertEquals(confirm, msg);
		    // Checking title
		    Assert.assertEquals(driver.getTitle(), "Welcome | EC-Council Learning");
			this.strtbutton();
			this.closeAds();
			// Checking title
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(4);
			this.nextbtn();
			this.closeAds();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(1);
			this.nextbtn();
			this.closeAds();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.selectCareerGoals(1);
			this.nextbtn();
			this.closeAds();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(3);
			this.nextbtn();
			this.closeAds();
			String thankYouMsg =this.getThanksMsg();
		    // Checking Message on screen
		    String mesg = "Thank You, "+name+"!";
		    Assert.assertEquals(thankYouMsg, mesg);
			Assert.assertEquals(driver.getTitle(), "Thanks | EC-Council Learning");
			this.clickdashboard();
			this.closeAds();
			String dashboardMsg =this.getDashboardMsg();
		    // Checking Message on screen
		    String messg = "Welcome, "+name+"!";
		    Assert.assertEquals(dashboardMsg, messg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
    	}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
    }
    
    public void logout() {
    	 this.clickProfileIcon();
    	 this.clickLogoutBtn();
    }   
}
