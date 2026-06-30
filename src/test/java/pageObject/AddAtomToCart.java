package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

  
public class AddAtomToCart extends BaseClass{
WebDriver driver;
	
	public AddAtomToCart(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this );
	}
	
//for mac
@FindBy(xpath="//a[@class='dropdown-toggle'][normalize-space()='Desktops']") WebElement desktop;
@FindBy(xpath="//a[normalize-space()='Mac (1)']") WebElement mac;
@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-shopping-cart']")WebElement addmac;
 

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement sucmsg;

//for tablet

@FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]") WebElement tabletbtn;
@FindBy(xpath="//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//button[1]") WebElement addtabletbtn;


@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement msgaddtablet;

//for phones and pad
@FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Phones & PDAs')]") WebElement mobilepadbtn;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement addmobile;
@FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//i[1]") WebElement addcarthtc;

@FindBy(xpath="//body//div[@id='product-category']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]//div[2]//button[1]") WebElement addcartiphone;

@FindBy(xpath="//div[3]//div[1]//div[2]//div[2]//button[1]//i[1]") WebElement addcartpalm;




//Action
	//for mac 
	public void desktopclick() {
		desktop.click();
		mac.click();
		addmac.click();
	}

	
	public boolean msg() {
		boolean addmsg=sucmsg.isDisplayed();
		
		return addmsg; 
	}
	
//for tablet
  public void tablet() {
	  tabletbtn.click();
	  addtabletbtn.click();
 
  }
  
  
  public boolean confirmsgTablet() {
	 boolean tabmsg= msgaddtablet.isDisplayed();
	 return tabmsg;
	  
  }
	
//for phones&ipad
  
  public void mobilepadbtn() {
	  mobilepadbtn.click();
	  
	  
  }
  
  public boolean htcmobile() {
	  addcarthtc.click();
	  boolean msgmobile= addmobile.isDisplayed();
	  return msgmobile;
  }
  
  public boolean iphone() {
	  
	  addcartiphone.click();
	  boolean msgmobile= addmobile.isDisplayed();
	  return msgmobile;
	  
  }
  
  public boolean palmphone() {
	  addcartpalm.click();
	  boolean msgmobile= addmobile.isDisplayed();
	  return msgmobile;
  }
  
  
}

