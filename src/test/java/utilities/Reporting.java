package utilities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public void onStart(ITestContext testcontext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report" + timeStamp + ".html";

		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/"+repName);
		
		try {
			sparkreporter.loadXMLConfig("C:\\Users\\Admin\\eclipse-workspace1\\BankingApplication\\test-output\\extent-config.xml");
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		extent =new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("SystemName","localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Deepak");
		
		sparkreporter.config().setDocumentTitle("ReportTile-EBanking Application");
		sparkreporter.config().setReportName("Automation test report");
		sparkreporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult ts) {

		logger = extent.createTest(ts.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(ts.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tf) {

		logger = extent.createTest(tf.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tf.getName(), ExtentColor.RED));

	}

	public void onTestSkipped(ITestResult ts) {
		logger = extent.createTest(ts.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(ts.getName(), ExtentColor.AMBER));
	}

	public void onFinish(ITestContext testcontext) {
		extent.flush();

	}


}
