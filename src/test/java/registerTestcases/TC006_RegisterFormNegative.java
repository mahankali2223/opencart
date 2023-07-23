package registerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CoderedRegister2;

public class TC006_RegisterFormNegative extends Basepageclass {
	
	@Test (priority = 0)
	public void Test01_EmailNegative() throws InterruptedException
	{
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			Thread.sleep(10000);
			regPage.closeAds();
			regPage.checkInvalidEmailMsg(regPage.randomString());
		}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		}
	}
	
	@Test (priority = 1)
	public void Test02_PasswordNegative() throws InterruptedException
	{
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			Thread.sleep(10000);
			regPage.closeAds();
			regPage.checkInvalidPasswordMsg("ABCDEFGH"); //only capital letter
			regPage.checkInvalidPasswordMsg("abcdefgh"); //only small letter
			regPage.checkInvalidPasswordMsg("12345678"); //only number
			regPage.checkInvalidPasswordMsg("ABCabcdD"); //only capital and small letter
			regPage.checkInvalidPasswordMsg("ABCabc12"); //special character missing
			regPage.checkInvalidPasswordMsg("ABC@123456"); //small letters missing
			regPage.checkInvalidPasswordMsg("abc@12a"); //length is not 8
		}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		}
	}
	
	@Test(priority = 2)
	public void Test03_SubmitBtnNegative() throws InterruptedException
	{
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			Thread.sleep(10000);
			regPage.closeAds();
			regPage.isDisable(regPage.submit); 
			
			//check for blank form
			regPage.sendKeys(regPage.firstname, regPage.randomString());
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
			regPage.sendKeys(regPage.email, regPage.randomString()+"@gmail.com");
			regPage.click(regPage.chkbox);
			regPage.isEnable(regPage.submit);
			
			//Checking Mandatory fields
			regPage.clear(regPage.firstname);	//checking first name
			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.firstname, regPage.randomString());
			regPage.click(regPage.firstNameLabel);
			regPage.clear(regPage.psswrd);	//checking password
			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
			regPage.click(regPage.firstNameLabel);
			regPage.clear(regPage.email);	//checking email
			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.email, regPage.randomString()+"@gmail.com");
			regPage.click(regPage.firstNameLabel);
			regPage.click(regPage.chkbox);	//checking checkbox
			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.click(regPage.chkbox);
			regPage.click(regPage.firstNameLabel);
			
			//Checking for invalid input
			regPage.sendKeys(regPage.email, regPage.randomString());
			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.email, regPage.randomString()+"@gmail.com");
			regPage.click(regPage.firstNameLabel);
			regPage.sendKeys(regPage.psswrd, regPage.randomString());
			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			
		}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		}
	}
}