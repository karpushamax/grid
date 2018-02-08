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
import Page.TotalPage;
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
		
		driver.manage().window().maximize();
		
		jex = (JavascriptExecutor)driver;
		
		driver.get(url);
		TotalPage page = new TotalPage(driver);
		wait.until(ExpectedConditions.visibilityOf(page.landing_search));
		page.landing_signin.click();
		page.landing_signin_seeker.click();
		
		String email = Helper.getPropValue("email", "total_cred");
		String password = Helper.getPropValue("password", "total_cred");
		
		page.login_email.clear();
		page.login_email.sendKeys(email);
		
		page.login_password.clear();
		page.login_password.sendKeys(password);
		
		page.login_submit.click();
		
		wait.until(ExpectedConditions.visibilityOf(page.landing_search));
	}


}
