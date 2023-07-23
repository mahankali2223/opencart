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
	
	public String name = this.randomString();
	
	@FindBy(xpath = "(//a[text()='Get Free Access'])[1]")
	 public WebElement getfree ;
	
	@FindBy(xpath ="(//input[@placeholder='First Name'])")
	public WebElement firstname;
	
	@FindBy(xpath ="(//input[@placeholder='Email'])")
	public WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Password'])")
	public WebElement psswrd;
	
    @FindBy(xpath = "//app-select[@defaultvalue='Country']")
    public WebElement countryid;
    
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement chkbox;
    
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submit;
    
    @FindBy(xpath = "//h2")
    public WebElement header;
    
    @FindBy(xpath = "//a[text()='Start']")
    public WebElement strtbtn;
    
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement nxtbtn;
    
    @FindBy(xpath = "//a[text()='Go To Dashboard']")
    public WebElement dashboard;
    
    @FindBy(xpath = "//h1")
    public WebElement thankMsg;
    
    @FindBy(xpath = "//app-right-side-header//h2")
    public WebElement dashboardMsg;
    
    public void clickoption(String option) {
    	driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(option);
    	List<WebElement> list	= driver.findElements(By.xpath("//li[@role='option']"));
   
    		for(int i=0; i<list.size(); i++) {
    			
    			if(list.get(i).getText().equals(option)){
    				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    				wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    				break;
    			}
    		}
	}

    public void options(int numberofoptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	for(int i=0; i<numberofoptions;i++) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    	
    }
    
    public void selectCareerGoals(int numOfOptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//label/p"));
    	for(int i=0; i<numOfOptions;i++) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    }
   
    public void proceedToNextStep() throws InterruptedException {
    	try {
    		String confirm = getText(header);
		    // Checking Message on screen
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
		    Assert.assertEquals(confirm, msg);
		    // Checking title
		    Assert.assertEquals(driver.getTitle(), "Welcome | EC-Council Learning");
			this.click(strtbtn);
			this.closeAds();
			// Checking title
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(4);
			this.click(nxtbtn);
			this.closeAds();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(1);
			this.click(nxtbtn);
			this.closeAds();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.selectCareerGoals(1);
			this.click(nxtbtn);
			this.closeAds();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(3);
			this.click(nxtbtn);
			this.closeAds();
			String thankYouMsg =this.getText(thankMsg);
		    // Checking Message on screen
		    String mesg = "Thank You, "+name+"!";
		    Assert.assertEquals(thankYouMsg, mesg);
			Assert.assertEquals(driver.getTitle(), "Thanks | EC-Council Learning");
			this.click(dashboard);
			this.closeAds();
			String dashboardMssg =this.getText(dashboardMsg);
		    // Checking Message on screen
		    String messg = "Welcome, "+name+"!";
		    Assert.assertEquals(dashboardMssg, messg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
    	}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
    }
}
