package registerTestcases;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoderedRegister;
import pageObjects.CoderedRegister2;

public class TC003_CoderedRegisterTest2 extends Basepageclass {
	
	@Test
	public void Eccodered_test_Registration2() throws InterruptedException
	{
		
		try {
			System.out.println("Testcase2");
			CoderedRegister2 regPage = new CoderedRegister2(driver);
			CoderedRegister code= new CoderedRegister(driver);
//			this.navigate();
			Thread.sleep(10000);
			code.closeAds();
			regPage.sendKeys(regPage.firstname, code.name);
			regPage.sendKeys(regPage.email, code.name+"@gmail.com");
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
			regPage.click(regPage.chkbox);
			regPage.click(regPage.submit);
			regPage.closeAds();
			code.proceedToNextStep();
			code.logout();
			
		} catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
	}
}
