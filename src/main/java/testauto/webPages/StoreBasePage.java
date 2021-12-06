package testauto.webPages;


import org.openqa.selenium.WebDriver;

import testauto.core.Wrapper;

public class StoreBasePage {
	
	protected static WebDriver webDriver;

	public StoreBasePage() {
		
		webDriver = Wrapper.getWebDriver();
	}

}
