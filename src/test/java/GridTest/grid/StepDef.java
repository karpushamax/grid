package GridTest.grid;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page.Page;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.google.common.base.Function;

public class StepDef {
	
	WebDriver driver;
	WebDriverWait wait;
	Page page;
	List<WebElement> tree;
	int iter;
	String list;
	JavascriptExecutor jex;
	List<String> clicked;
	
	@Given("^I navigate to page$")
	public void i_navigate_to_webpage() throws Throwable {
	 
		System.out.println("MAX is STARTING TEST!");
		String url = Helper.getPropValue("landing", "navigation");

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,65);
		
	//	driver.manage().window().maximize();
		driver.get(url);
		Page page = new Page(driver);
		wait.until(ExpectedConditions.visibilityOf(page.login_button));
		jex = (JavascriptExecutor)driver;
		
		clicked = new ArrayList<String>();
		
	}
	
	@Then("^I log in$")
	public void i_log_in() throws Throwable {
 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement wel = (WebElement)js.executeScript("return document.getElementsByClassName('login blue')[0]");
		wel.click();
		driver.manage().timeouts().implicitlyWait(10, SECONDS);
		WebElement jee = (WebElement)jex.executeScript("return document.getElementById('email')");
		WebElement jep = (WebElement)jex.executeScript("return document.getElementById('password')");
		WebElement jes = (WebElement)jex.executeScript("return document.getElementsByClassName('submit')[0]");
		String email = Helper.getPropValue("email", "cred");
		String password = Helper.getPropValue("password", "cred");
		jee.sendKeys(email);
		jep.sendKeys(password);
		jes.click();
		
		
	}


	
	@Given("^I search for jobs$")
	public void i_search_for_jobs() throws Throwable {
		
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	// js.executeScript("document.getElementById('jobTitle-input').setAttribute('type','text')");
	 WebElement con = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#psformnew > div.jobTitle.search-item.overflow")));
	 con.click();
	 WebElement con1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#psformnew > div.jobTitle.search-item.overflow > div.tag-container.overflow > ul")));
	 con1.click();
	  
	 WebElement search = (WebElement)js.executeScript("return document.getElementById('jobTitle-input')");
	 search.clear();
	 search.sendKeys("QA contract Java");
	 WebElement searchbutton = (WebElement)js.executeScript("return document.getElementById('searchBtn')");
	 searchbutton.click();
	// Wait fluwait = new FluentWait(driver).withTimeout(60, SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);
	// js.executeScript("document.getElementsByClassName('spotlight_dismiss visible')[0].click()");
	// js.executeScript("document.getElementById('searchBtn').click()");
	 tree = new ArrayList<WebElement>();
	 tree = driver.findElements(By.cssSelector("a[href^='/job/']"));
	 list = driver.getCurrentUrl();

	 
	 
//	 List<WebElement> ex = (List<WebElement>)js.executeScript("return document.getElementsByClassName('spotlight_dismiss visible')");
//	 
//			 
////			 WebElement wel = wait.until(new Function<WebDriver, WebElement>() 
////				{
////				  public WebElement apply(WebDriver driver) {
////				  return driver.findElement(By.name("btnK"));
////				}
////				});
//	 
//	 if(ex!=null)
//	 {
//		 WebElement exbtn = ex.get(0);
//		  
//	 }
//	 
	}
	
	@Then("^I apply for jobs$")
	public void i_apply_for_jobs() throws Throwable {
	 
		iter = 0;
		
		for(int i = 0; i< tree.size(); i++)
		{
			
			if(iter!=0)
			{
				tree = new ArrayList<WebElement>();
				tree = driver.findElements(By.cssSelector("a[href^='/job/']"));
			}
			
			 if(iter == i)
			 {
				 String name = tree.get(i).getText();
				 
				 if(!clicked.contains(name))
				 {
				 tree.get(i).click();
				 
				 
				 driver.manage().timeouts().implicitlyWait(10, SECONDS);
				 WebElement descr = null;
				 clicked.add(name);
				 System.out.println(name);
				 try {
					descr = driver.findElement(By.cssSelector("div[class='description left']"));
				} catch (org.openqa.selenium.NoSuchElementException e1) {
					 
					 tree.get(i).click();
					 
					 driver.manage().timeouts().implicitlyWait(10, SECONDS);
					 descr = driver.findElement(By.cssSelector("div[class='description left']"));
					 clicked.add(name);
					 System.out.println(name);
				}
 
				 List<WebElement> ele = descr.findElements(By.tagName("p"));
				 
				 String str = "";
				 
				 for(WebElement p:ele)
				 {
					 try
					 {
					 str = str + p.getText();
					 }catch(Exception x)
					 {
						 x.printStackTrace();
					 }
					 
				 }
				 
				 if(valid(str))
				 {
					 System.out.println("WILL CLICK NOW FOR CANDIDACY: " + iter);
					 try
					 {
					 jex.executeScript("document.getElementsByClassName('one-click-apply-btn applynowButton')[0].click()");
					 }catch(org.openqa.selenium.WebDriverException exp)
					 {
						 jex.executeScript("document.getElementsByClassName('button applynowButton')[0].click()");
						 driver.manage().timeouts().implicitlyWait(5, SECONDS);
						try
						{
						 WebElement pex = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#apply_wrapper > button")));
						 pex.click();
//						 WebElement pex = driver.findElement(By.cssSelector("button[type='submit']"));
//						 System.out.println(pex.getAttribute("width"));
//						 jex.executeScript("arguments[0].click();", pex);
					

					 }	 catch(org.openqa.selenium.TimeoutException stx)
							{
								stx.printStackTrace();
							}
						}
				 }
				 
				 try {
//					JavascriptExecutor js = (JavascriptExecutor)driver;
//					 WebElement searchbutton = (WebElement)js.executeScript("return document.getElementById('searchBtn')");
//					 searchbutton.click();
					 
						driver.get(list);
						driver.manage().timeouts().implicitlyWait(10, SECONDS);			 
				} catch (org.openqa.selenium.ElementNotVisibleException e) {
				 
					driver.get(list);
					driver.manage().timeouts().implicitlyWait(10, SECONDS);
				}
			 }
				 
			 }
			iter ++;
		}
		
	}

 
	
	@After
	public void clean_up()
	{
//		driver.close();
	}
	
	
	public void populate()
	{
		 tree = new ArrayList<WebElement>();
		 tree = driver.findElements(By.cssSelector("a[href^='/job/']"));
		
	}
	
	boolean valid(String s)
	{
		boolean result = false;
		
		String[] or = {"QA","qa","Test","test","Automation"};
		String[] and = {"Java","Selenium"};
		
		 for(String r:or)
		 {
			 if(s.toLowerCase().contains(r.toLowerCase()))
			 {
				 if(s.toLowerCase().contains(and[0].toLowerCase())||s.toLowerCase().contains(and[1].toLowerCase()))
				 {
					 result = true;
					 break;
				 }
			 }
		 }
		
		return result;
	}

}
