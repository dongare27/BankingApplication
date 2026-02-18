package testcases;

import org.testng.annotations.Test;

import pageobjectmodel.LoginPage;
public class TC_LoginPage_01 extends BaseClass
{

	@Test
	public void loginPage() throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setuserName(username);
		logger.info("user name is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		
	}
	

}
