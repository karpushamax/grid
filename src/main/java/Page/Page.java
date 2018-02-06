package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	public Page(WebDriver dr)
	{
		init(dr);
	}
	
	
	
	@FindBy(how=How.CSS,using="#location-input")
	public WebElement location_input;
	
	@FindBy(how = How.CSS, using = "#psformnew > div.jobTitle.search-item.overflow > div.tag-container.overflow > ul")
	public WebElement job_input;
	
	@FindBy(how=How.CSS,using="body > div.container > header > menu > a > button")
	public WebElement login_button;
	
	@FindBy(how = How.CSS, using = "#searchBtn")
	public WebElement search_button;
	
	@FindBy(how = How.CSS, using = "#content > div.tj_search.search_results.page_wrap > div.container_wrap > div.content_main > div.search_content_results > div.jbe_signup_box_inline_wrap.spotlight_box > div.spotlight_dismiss.visible")
	public WebElement ex_Button;
	
	@FindBy(how = How.CSS, using = "#middleContainer > div.wrapper.contentWrapper.myjobsite_wrap > main > div.vacancySection.content > div.description.left")
	public WebElement job_description;
	
	@FindBy(how = How.CSS, using = "#email")
	public WebElement loginform_email;
	
	@FindBy(how = How.CSS, using = "#password")
	public WebElement loginform_password;
	
	@FindBy(how = How.CSS, using = "#login_form > fieldset > div.button-container > input")
	public WebElement loginform_submit;
	
 
	
 
	
	final void init(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
