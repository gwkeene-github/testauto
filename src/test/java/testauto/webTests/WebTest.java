package testauto.webTests;

import org.testng.annotations.Test;



import static org.testng.Assert.assertTrue;


//import testAutomationProject.report.TestReporter;

import testauto.webPages.StoreHomePage;


public class WebTest  extends WebBaseTest {
	
	@Test
	public void searchTest() {
		
		boolean result = true;
		String details = "Search Test";
		
		System.out.println(testName);
		
		navigate("https://www.walmart.com/");
		
		String searchString = "Computer";

		
		StoreHomePage storeHome = new StoreHomePage();
		
		result = storeHome.search(searchString);
		
		System.out.println("Result is :  "+result);
		
		if(result) {
			//testReporter.testPass(details);
		}
		else {
		//	testReporter.testFail(details);
		}
		
		assertTrue(result);
		
	}
	
	
	
}
