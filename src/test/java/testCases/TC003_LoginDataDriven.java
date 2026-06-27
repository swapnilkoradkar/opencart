package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountlogin;
import utilities.DataProviders;



/*Data is valid --- login sucsess -  test pass - logout  
                   login failed - test failed 
                   
   Data is Invalid --- login sucsess - test failed - logout
                       login failed  - test passed */

@Test
public class TC003_LoginDataDriven{

	public WebDriver driver;
	 public Logger logger;
	@BeforeClass
	void construct() { 
		driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		//driver.manage().window().setSize(new Dimension(1536 , 864));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		logger=LogManager.getLogger(this.driver);
	 }
	
	                                                                       //geting data from provider fromm different class 
	@Test(dataProvider="LoginData",  dataProviderClass=DataProviders.class)//presents into another package or class tat s why give the name of data providers and class name of that data providers
	public void verifyloginDDT(String email, String pwd, String exp) throws IOException{//) {//,String exp
		
	logger.info("**** test start******");
	try {
	//homepage
	HomePage hp= new HomePage(driver);
	hp.clickMyacount();
	hp.clickLogin();
	
	//loging page
	LoginPage lp=new LoginPage(driver);
	lp.email(email);
	lp.pass(pwd);
	lp.clickLgn();
	
	//Myaccountlogin
	MyAccountlogin mal= new MyAccountlogin(driver);
	boolean targetpage=mal.myaccontconfi();
	System.out.println(targetpage);
	//Assert.assertTrue(true);
	logger.info("**** test condition******"); 
		//valid credential
	if(exp.equalsIgnoreCase("Valid")) {
	if(targetpage==true) {
		mal.clicklogout();
		Assert.assertTrue(true);
		
	}else {
		Assert.assertTrue(false);
	}
	}

	
	//invalid credential
	if(exp.equalsIgnoreCase("Invalid")) {
	if(targetpage==false)
	{
		
		Assert.assertTrue(true);
	}else
	{
		mal.clicklogout();
		Assert.assertTrue(false);
      }
	}
	
	}catch(Exception e) {
		Assert.fail();
		
	}
	logger.info("**** test End******");
	}
	
	@AfterClass
	public void sutdown() {
		driver.close();
	}
}