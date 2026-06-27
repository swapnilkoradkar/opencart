package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountlogin{
	
	public WebDriver driver;
	public MyAccountlogin(WebDriver driver) {
		this.driver=driver;
		
	}
	    By confimsg =By.xpath("//h2[normalize-space()='My Account']");
	    
	    By logout=By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
	   
	    
       public boolean myaccontconfi() {
    	   try{
    	        boolean msg=driver.findElement(confimsg).isDisplayed();
    	         
    		        return msg;
    	         }catch(Exception e) {
    		   return false;
    	   }
     }
       
       	public void clicklogout() {
       		driver.findElement(logout).click();
       	}

}

