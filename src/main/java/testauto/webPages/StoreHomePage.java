package testauto.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testauto.core.Wrapper;


public class StoreHomePage extends StoreBasePage {
	
	private static final By STORE_SEARCH_BUTTON = By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/main/div/div[2]/div/div/div[1]/section/div/div[1]/div/div/div/div[1]/div[2]/div[2]/button");
	private static final By STORE_SEARCH = By.xpath("/html/body/div[1]/div[1]/div/span/header/div/form/div/input");
	private static final By TRY_OTHER_METHOD = By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div[2]/div/div/p[2]/button");
	private static final By ROBOT_CHECKBOX = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]");

	
	public StoreHomePage(){
	
	}
	

	public boolean search(String location) {
		
		boolean result = true;
		
		WebDriverWait wait = Wrapper.getWebDriverWait();
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(STORE_SEARCH));
			
			WebElement searchBox = webDriver.findElement(STORE_SEARCH);
			searchBox.sendKeys(location);
			
			System.out.println("search value:  "+location);
			
			searchBox.sendKeys(Keys.ENTER);
			
			wait.until(ExpectedConditions.elementToBeClickable(TRY_OTHER_METHOD));
			webDriver.findElement(TRY_OTHER_METHOD).click();
			
			wait.wait(3);
			
			wait.until(ExpectedConditions.elementToBeClickable(ROBOT_CHECKBOX));
			webDriver.findElement(ROBOT_CHECKBOX).click();
			
			
		
			webDriver.findElement(STORE_SEARCH_BUTTON).click();
		
		}catch(NoSuchElementException e) {
			System.out.println(e.getMessage());

			result = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result value:  "+result);
		return result;
	
	}


}
