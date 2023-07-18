package testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoderedRegister;

public class TC002_coderedRegister extends Basepageclass {
	
	@Test
	public void codered_test_Registration() throws InterruptedException
	{
		
		try {
			
			CoderedRegister code= new CoderedRegister(driver);
			code.closepopup();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.clickGetfreeaccess();
			String name = randomeString();
			code.setfirstname(name);
			code.setemail(randomeString()+"@gmail.com");
			code.setpassword(randomAlphaNumeric());
			code.closepopup();
			code.clickCountry();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.clickoption("India");
			code.closepopup();
			code.submit();
		    String confirm =code.getSucessMsg();
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
			Assert.assertEquals(confirm, msg);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.strtbutton();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.options();
			code.nextbtn();
			
		} catch(Exception e){
			System.out.println(e);
			
			Assert.fail();
		 }
		
	}
}
