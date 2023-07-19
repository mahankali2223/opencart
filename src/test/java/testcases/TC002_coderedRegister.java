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
			Thread.sleep(10000);
			code.closepopup();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.clickGetfreeaccess();
			String name = randomeString();
			code.setfirstname(name);
			code.setemail(randomeString()+"@gmail.com");
			code.setpassword(randomAlphaNumeric());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.clickCountry();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.clickoption("India");
			code.submit();
		    String confirm =code.getSucessMsg();
		    // Checking Message on screen
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
		    Assert.assertEquals(confirm, msg);
		    // Checking title
		    String title = driver.getTitle();
		    Assert.assertEquals(title, "Welcome | EC-Council Learning");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.strtbutton();
			// Checking title
//		    String title = driver.getTitle();
//		    Assert.assertEquals(title, "Add title here");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			code.options();
			code.nextbtn();
			
		} catch(Exception e){
			System.out.println(e);
			
			Assert.fail();
		 }
		
	}
}
