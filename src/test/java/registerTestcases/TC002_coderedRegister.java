package registerTestcases;

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
//			this.navigate();
			Thread.sleep(10000);
			code.closeAds();
			code.click(code.getfree);
			code.closeAds();
			code.sendKeys(code.firstname, code.name);
			code.sendKeys(code.email, code.name+"@gmail.com");
			code.sendKeys(code.psswrd, code.randomAlphaNumeric());
			code.click(code.countryid);
			code.clickoption("India");
			code.click(code.chkbox);
			code.click(code.submit);
			code.closeAds();
			code.proceedToNextStep();
			code.logout();
			
//			<class name="registerTestcases.TC002_coderedRegister"/>
//	    	<class name="registerTestcases.TC003_CoderedRegisterTest2"/>
			
		} catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
	}
}
