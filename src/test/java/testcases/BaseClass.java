package testcases;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
    
	ReadConfig config=new ReadConfig();
	public String baseURL=config.getApplicationURL();
	public String username=config.getUserName();
    public String password=config.getPassword();
    public static WebDriver driver;
    public static Logger logger=LogManager.getLogger("BaseClass");
   	
    @BeforeClass
	public void setup() {
		
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseURL);
    logger.info("Application URL is Launched");
    
	}
	
public String randomString() {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(7);
		return generatedstring;
	}

public boolean isAlertPresent() {
	
	try{
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e) {
		return false;
	}
}
	
  @AfterClass
    public void tearDown() {
    	driver.quit();
    }
	
}

