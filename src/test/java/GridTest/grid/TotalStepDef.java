package GridTest.grid;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page.Page;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalStepDef {
	
	WebDriver driver;
	WebDriverWait wait;
	Page page;
	List<WebElement> tree;
	int iter;
	String list;
	JavascriptExecutor jex;
	
	
	@Given("^I navigate to totaljobs and log in$")
	public void i_navigate_to_totaljobs_and_log_in() throws Throwable {
	   
	 
		String url = Helper.getPropValue("total", "navigation");

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,20);
		
	//	driver.manage().window().maximize();
		driver.get(url);
		Page page = new Page(driver);
	//	wait.until(ExpectedConditions.visibilityOf(page.login_button));
		jex = (JavascriptExecutor)driver;
		
		
	}


}
