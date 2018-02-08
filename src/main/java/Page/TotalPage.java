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
	
	@FindBy(how = How.CSS, using = "#keywords")
	public WebElement landing_what;
	
	@FindBy(how = How.CSS, using = "#location")
	public WebElement landing_where;	
	
	@FindBy (how = How.CSS, using = "body > div.container.results-container > div.row.job-results-row > div > div.col-sm-9.job-results.clearfix > div > div.col-xs-12.job-results.clearfix")
	public WebElement search_results_container;
	
	@FindBy (how = How.CSS, using = "#JobToolsTop_AOLOptions_lnkApplyOnline")
	public WebElement job_apply;
	
	@FindBy (how = How.CSS, using = "#top-button-panel > section > div.buttons-panel-layer.main-layer > div.apply-job-col > div > div.col-xs-12.col-sm-6.oca-container > div:nth-child(1) > a")
	public WebElement job_apply_once;
	
	@FindBy (how = How.CSS, using = "div[class='job-description']")
	public WebElement job_container;
	
	@FindBy (how = How.CSS, using = "#search-submit-button-desktop")
	public WebElement submitted_search;
	
	final void init(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
