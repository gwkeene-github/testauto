package testauto.webTests;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import testauto.core.Wrapper;


public class WebBaseTest{
	
	protected static WebDriver driver;

	static String testName; 

	
    @BeforeClass
	protected void startDriver() {

        System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Wrapper.setWebDriver(driver);
            
	}
    
	@BeforeMethod
	public void beforeMethod(Method method) throws IOException {
		
		// Notify the reporter that a test method block is going to be executed.
		testName = method.getName();
	
	}
	
	/**
	 * Called by TestNG framework when it is about to execute a "test" tag branch defined
	 * in the XML file. The test branch will contain one or more classes, each of which
	 * will be executed as part of the test branch.
	 */
	@BeforeTest
	public void beforeTest(ITestContext context) {
		// Notify the reporter that a TEST block is going to be executed.
		
	
	}

	/**
	 * Called after test runs, updates test count and writes results to reporter
	 */
	@AfterTest
	public void afterTest(ITestContext context) {
		
	}

	@AfterMethod
	public void afterMethod(Method method) throws InterruptedException {

	}
	
	/**
	 * Called by TestNG framework when all the test methods in the current a test class
	 * have been executed. 
	 */
	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}
	/**
	 * Called after test suite finishes for teardown
	 */
	@AfterSuite
	public void afterSuite(ITestContext context) {

	
	}


    protected void navigate(String url) {
   
 
//    	WebDriverWait wait = Wrapper.getWebDriverWait();
//    	try {
//    	wait(5);
//    	}
//    	catch(TimeoutException | InterruptedException e) {
//    		System.out.println(e.getMessage());
//    		e.printStackTrace();
//    	}
    	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    	driver.navigate().to(url);
      // 	driver.get(url);
    }
    


    

}
