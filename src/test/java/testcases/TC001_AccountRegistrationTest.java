package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends Basepageclass{
	
	
	@Test
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("\"***  Starting TC_001_AccountRegistrationTest ***");
	   try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		hp.clickRegister();
		logger.info("Clicked on My Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
    //  regpage.setUserName(randomeString().toUpperCase());
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");
		
//		regpage.clickCountryDrp();
		
//		regpage.selectDropDown();
		
		regpage.setPassword(randomAlphaNumeric());
		
        regpage.setPrivacyPolicy();
        logger.info("Clicked on setprivacy");
//	    regpage.clickContinue();
//	    logger.info("Clicked on continue");
//		
//		String successmsg=regpage.getSucessMsg();
//		
//		Assert.assertEquals(successmsg,"Success: You passed!");
		
//		regpage.clickRegisterbutton();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	
	 catch(Exception e)
	 {
		Assert.fail();
	 }
	   logger.info("***  Finished TC_001_AccountRegistrationTest ***");	
	}


}
