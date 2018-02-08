package GridTest.grid;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;
import Page.Page;
import Page.TotalPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalStepDef {
	
	WebDriver driver;
	WebDriverWait wait;
	TotalPage page;
	List<WebElement> tree;
	int iter;
	String list;
	JavascriptExecutor jex;
	List<WebElement> ele;
	String window;
	
	@Given("^I navigate to totaljobs and log in$")
	public void i_navigate_to_totaljobs_and_log_in() throws Throwable {
	   
	 
		String url = Helper.getPropValue("total", "navigation");

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,45);
		
		//driver.manage().window().maximize();
		
		jex = (JavascriptExecutor)driver;
		
		driver.get(url);
		page = new TotalPage(driver);
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
		window = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOf(page.landing_search));
	}

	@Then("^I search for jobs in London$")
	public void i_search_for_jobs_in_London() throws Throwable {
 
		String keyword = Helper.getPropValue("what", "totalinput");
		String location = Helper.getPropValue("where", "totalinput");
		
		page.landing_what.clear();
		page.landing_what.sendKeys(keyword);
		page.landing_where.clear();
		page.landing_where.sendKeys(location);
		
		page.landing_search.click();
		
	}
	
	@Then("^I apply for applicable jobs$")
	public void i_apply_for_applicable_jobs() throws Throwable {
	//	driver.manage().timeouts().implicitlyWait(10, SECONDS);
		WebElement container = wait.until(ExpectedConditions.visibilityOf(page.search_results_container));
		ele = container.findElements(By.tagName("h2"));

		int count = ele.size();
		int iter = 0;
		
		for(int i = 0; i<count; i++)
		{
			 
			
			if(iter!= 0)
			{
				 
				try {
					container = wait.until(ExpectedConditions.visibilityOf(page.search_results_container));
					ele.clear();
					ele = container.findElements(By.tagName("h2"));
				} catch (org.openqa.selenium.TimeoutException e) {
					
					page.submitted_search.click();
					container = wait.until(ExpectedConditions.visibilityOf(page.search_results_container));
					ele.clear();
					ele = container.findElements(By.tagName("h2"));
				}
			}
			if(i == iter)
			{
			ele.get(i).click();
			
			String text = null;
			try {
				WebElement cont = wait.until(ExpectedConditions.visibilityOf(page.job_container));
				List<WebElement> paragraph = cont.findElements(By.tagName("p"));
				
				text = "";
				for(WebElement par:paragraph)
				{
					text = text + par.getText();
				}
			} catch (org.openqa.selenium.TimeoutException e3) {
				ele.get(i).click();
				WebElement cont = wait.until(ExpectedConditions.visibilityOf(page.job_container));
				List<WebElement> paragraph = cont.findElements(By.tagName("p"));
				
				text = "";
				for(WebElement par:paragraph)
				{
					text = text + par.getText();
				}
				
			}
			
			
			
			
			if(Helper.valid(text))
			{
				
				try {
					page.job_apply_once.click();
				} catch (org.openqa.selenium.NoSuchElementException e) {
				 
					try {
						page.job_apply.click();
					} catch (org.openqa.selenium.NoSuchElementException e1) {
 						e1.printStackTrace();
					}catch(org.openqa.selenium.WebDriverException e2)
					{
						e2.printStackTrace();
					}
				}
			}
			
			try {
				WebElement subsearch = wait.until(ExpectedConditions.elementToBeClickable(page.submitted_search));
				subsearch.click();
			} catch (org.openqa.selenium.TimeoutException e) {
 
				driver.switchTo().window(window);
				page.submitted_search.click();
			}
			}
			iter ++;
			
		}
	}
}
