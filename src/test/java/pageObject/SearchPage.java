package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage{

	 WebDriver driver;
	public SearchPage( WebDriver driver){
		this.driver=driver;
		
      	PageFactory.initElements(driver, this);
	}
	
	//locator
	

@FindBy(xpath="//input[@placeholder='Search']") WebElement Searchtextbar;
@FindBy(xpath="//i[@class='fa fa-search']") WebElement  searchclick;

@FindBy(xpath="//div[@id=\"content\"]//h1")WebElement ser;//find dynamic xpath	
@FindBy(xpath="//h1[normalize-space()='Search']") WebElement verify;	

//By Searchtextbar=xpath=("//input[@placeholder='Search']");
//By searchclick=xpath=("//i[@class='fa fa-search']");
	
	
	//Action 
	public String searchtext(String text) {
		Searchtextbar.sendKeys(text);
		searchclick.click();
		String cnfmsg=ser.getText();
		return cnfmsg;
		
	}
	

/*	
	
	public String  serarch() {
		String name= ser.getText();
		if(name != "wwwww") {
		return name;
	
	
	}
	*/

}
