package testCases;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountLoginPage;
import pageObject.AddAtomToCart;
import pageObject.HomePage;

public class TC004_AddingTheAtom{
	
		//adding the second messag efrom git hub
		//This is adding from the git hub we want pull it in our local machine
      WebDriver driver;
	Logger logger;
	
	
	@BeforeClass
	 void construct() throws IOException {
		driver= new ChromeDriver();
		 
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		logger=LogManager.getLogger(this.driver);
	
	}
	

	@Test
	public void addAtom() throws IOException {
	try {
		logger.info("The test is start....");
		//Home Page
		HomePage hp= new HomePage(driver);
		hp.clickMyacount();
		hp.clickLogin();
		
		//LoginPage
		AccountLoginPage ag=new AccountLoginPage(driver);
	    ag.textemail("swapnilkoradkar0573@gmail.com");
	    ag.textpassword("swapnil@123");
	    ag.loginbutton();
	
	    
	    	AddAtomToCart ac=new AddAtomToCart(driver);
	    ac.desktopclick();
	    logger.info("The mac is added to cart");
	    ac.msg();
	     boolean msg=ac.msg();
	    System.out.println(msg);
	    if(msg==true) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	    
	    
	    ac.tablet();
	    Assert.assertEquals(true, ac.confirmsgTablet());
	    logger.info("The tablet is added to cart");
		
	    ac.mobilepadbtn();
	    Assert.assertEquals(true, ac.htcmobile());
	    logger.info("htc mobile add to cart");
		
	    Assert.assertEquals(true,ac.iphone());
		logger.info("The iphone is added to cart");
		
		Thread.sleep(3000);
		
		Assert.assertEquals(true,ac.palmphone());
		 logger.info("The palmphone is added to cart");
	   
		
	    }catch (Exception e) {
	    Assert.fail();
	    	
	    }
	    
	logger.info("The test is end....");
	    	
	    }

		
	}
