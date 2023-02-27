package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageobjectmodel.AddCustomerPage;
import pageobjectmodel.LoginPage;

public class TC_AddNewCustomer_02 extends BaseClass {

	@Test
	public void addNewCustomer() {
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(username);
		logger.info("user name entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("clicked on submit button");

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddCustomer();
		logger.info("Clicked on Add New Customer link");
		
		boolean ad1=isElementPresentFrame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		
		if(ad1=true) {
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		driver.switchTo().defaultContent();
		logger.info("Came out of frame");
		addcust.custName("Deepak");
		logger.info("customer name is entered");
		addcust.custGender("male");
		logger.info("Clicked on male radio button");
		addcust.custdob("12", "21", "2022");
		logger.info("Customer DOB is entered");
		addcust.custAddress("Wakad Pink City");
		logger.info("Customer address is entered");
		addcust.custCity("Pune");
		logger.info("Customer city is entered");
		addcust.custState("MH");
		logger.info("Customer state is entered");
		addcust.custPin(234567);
		logger.info("Customer Pin is entered");
		addcust.custTelephoneNo("9999999999");
		logger.info("Customer Phone number is entered");
		String email = randomString() + "@gmail.com";
		addcust.custEmailID(email);
		logger.info("Customer email id  is entered");
		addcust.custPassword("htv1234");
		logger.info("Customer Password  is entered");
		addcust.custSubmit();
		logger.info("clicked on submit button to create new customer");
		}
		
	}

	public boolean isElementPresentFrame(String Frame) {
		try {
			driver.switchTo().frame(Frame);
			return true;
		} catch (Throwable t) {
			return false;
		}

	}

}
