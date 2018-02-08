package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TotalPage {
	
	public TotalPage(WebDriver driver)
	{
		init(driver);
	}
	
	//
	
	@FindBy(how = How.CSS, using = "#search-button")
	public WebElement landing_search;
	
 
	@FindBy(how = How.CSS, using = "#navbar-desktop-signin-toggle > span")
	public WebElement landing_signin;
	
	@FindBy(how = How.CSS, using = "#navbar-desktop-signin-links > ul > li:nth-child(1)")
	public WebElement landing_signin_seeker;
 
	@FindBy(how = How.CSS, using = "input[id='Form_Email']")
	public WebElement login_email;
	
	@FindBy(how = How.CSS, using = "#Form_Password")
	public WebElement login_password;
	
	@FindBy(how = How.CSS, using = "#btnLogin")
	public WebElement login_submit;
	
	final void init(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
