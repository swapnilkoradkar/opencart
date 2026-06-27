package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.AccoutRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void Verify_Account_Registration() throws InterruptedException, IOException {
		
		logger.info("This is a starting test ....");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyacount();
		hp.clickRegister();
		Thread.sleep(3000);
		//driver.navigate().back();
		logger.info("Click on the Register ....");
		
		AccoutRegistrationPage regpage=new AccoutRegistrationPage(driver);
		logger.info("Providing the information detals....");
		regpage.firstname(randomAlphabt().toUpperCase());
		regpage.lastname(randomAlphabt());
		
		regpage.email(randomAlphabt()+randomNumric()+"@gmail.com");
		regpage.phonenu(randomNumric());
		
		String pass= randomAlphaNumric();
		
		regpage.password(pass);
		regpage.confpass(pass);
		
		regpage.checkbox();
		regpage.continued();
		
		String message =regpage.verifymsg();
		System.out.println(message);
		logger.info("Validating the message...");
		if(message.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
			
		}else {
			
			logger.info("Test failed...");
			logger.error("Test got some error...");
			logger.debug("Test debug...");
		     Assert.assertTrue(false);
		
		}
		
		}catch(Exception e){
	
			Assert.fail();
			
		}
		
		logger.info("The test cases is End...");
	}
	
	
	
}
