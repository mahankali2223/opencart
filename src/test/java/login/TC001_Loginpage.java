package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import registerTestcases.Basepageclass;

public class TC001_Loginpage extends Basepageclass {
	
	@Test
	public void Codered_test_Registration() throws InterruptedException
	{
		try {
			System.out.println("Test case3");
		} catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
	}
}
