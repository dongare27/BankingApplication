package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage  {
	
	 WebDriver ldriver;
	 
	 public AddCustomerPage( WebDriver rdriver) {
		 
		 ldriver = rdriver;
		 PageFactory.initElements(rdriver,this ); 
	 }
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a") WebElement lnkAddCustomer;
	@FindBy(id="dismiss-button") WebElement dismissadlink;
    @FindBy(name="name") WebElement txtCustomerName;
    @FindBy(name="rad1") WebElement rGender;
    @FindBy(id="dob") WebElement txtdob;
    @FindBy(name="addr") WebElement txtAddress;
    @FindBy(name="city") WebElement txtCity;
    @FindBy(name="state") WebElement txtState;
    @FindBy(name="pinno") WebElement txtPin;
    @FindBy(name="telephoneno") WebElement txtTelephoneno;//emailid
    @FindBy(name="emailid") WebElement txtEmailid;
    @FindBy(name="password") WebElement txtPassword;
    @FindBy(name="sub") WebElement btnSubmit;
    
    public void clickAddCustomer() {
    	lnkAddCustomer.click();
    }
    public void dismissAdLink() {
    	dismissadlink.click();
    }
    
    
    public void custName(String cname) {
    	txtCustomerName.sendKeys(cname);
    }
    
    public void custGender(String cgender) {
    	rGender.click();
    }
    
    public void custdob(String mm,String dd,String yy) {
    txtdob.sendKeys(mm);
    txtdob.sendKeys(dd);
    txtdob.sendKeys(yy);
    
    }
    
    public void custAddress(String caddress) {
    	txtAddress.sendKeys(caddress);
    }
    public void custCity(String ccity) {
    	txtCity.sendKeys(ccity);
    }
	 public void custState(String cstate) {
		 txtState.sendKeys(cstate);
	 }
	 public void custPin(int cpin) {
		 txtPin.sendKeys(String.valueOf(cpin));
	 }
	 public void custTelephoneNo(String ctelephoneno) {
		 txtTelephoneno.sendKeys(ctelephoneno);
	 }
	 
	 public void custEmailID(String cemailid) {
		 txtEmailid.sendKeys(cemailid);
	 }
	 
	 public void custPassword(String cpassword) {
		 txtPassword.sendKeys(cpassword);
	 }
	 
	 public void custSubmit() {
		 btnSubmit.click();
	 }
	 
}
