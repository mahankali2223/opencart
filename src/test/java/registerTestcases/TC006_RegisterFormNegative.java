package registerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CoderedRegister2;

public class TC006_RegisterFormNegative extends Basepageclass {
	
	@Test
	public void Test01_EmailNegative() throws InterruptedException
	{
		
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			Thread.sleep(10000);
			regPage.closeAds();
			regPage.sendKeys(regPage.email, regPage.randomString());
			regPage.click(regPage.firstname);
			String invalidEmailMsg = regPage.getText(regPage.invalidEmail);
			Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
		}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
	}
}
