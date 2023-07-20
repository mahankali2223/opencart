package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoderedRegister;
import pageObjects.CoderedRegister2;

public class TC003_CoderedRegisterTest2 extends Basepageclass {
	
	@Test
	public void codered_test_Registration2() throws InterruptedException
	{
		
		try {
			CoderedRegister2 Regpage = new CoderedRegister2(driver);
			CoderedRegister code= new CoderedRegister(driver);
			Thread.sleep(10000);
			code.closeAds();
			Regpage.setfirstname(code.name);
			Regpage.setemail(code.name+"@gmail.com");
			Regpage.setpassword(code.randomAlphaNumeric());
			Regpage.clickCheckbox();
			Regpage.clickSubmit();
			code.closeAds();
			code.proceedToNextStep();
			
		} catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
	}
}
