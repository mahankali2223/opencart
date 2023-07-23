package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoderedRegister;

public class TC002_coderedRegister extends Basepageclass {
	
	@Test
	public void Codered_test_Registration() throws InterruptedException
	{
		
		try {
			System.out.println("Test case1");
			CoderedRegister code= new CoderedRegister(driver);
			Thread.sleep(10000);
			code.closeAds();
			code.clickGetfreeaccess();
			code.setfirstname(code.name);
			code.setemail(code.name+"@gmail.com");
			code.setpassword(code.randomAlphaNumeric());
			code.clickCountry();
			code.clickoption("India");
			code.clickCheckbox();
			code.clickSubmit();
			code.closeAds();
			code.proceedToNextStep();
			code.logout();
			
		} catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
	}
}
