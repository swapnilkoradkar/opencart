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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountlogin;
import testBase.BaseClass;
public class TC002_LoginTest extends BaseClass{
	
	//WebDriver driver;
	//public Logger logger;
	//public Properties p;
	
/*	@BeforeClass(groups={"sanity","regration","master"})
	 void construct() throws IOException {
		// driver= new ChromeDriver();
		 
		 FileReader file=new FileReader(".//src//test//resources//Config.Properties");
		p=new Properties();
		p.load(file);
		 
		 
		//driver.get(p.getProperty("url2"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		logger=LogManager.getLogger(this.driver);
	}
	*/
	@Test(groups= {"regration","master"})
	void Login() throws IOException, InterruptedException {
		logger.info("Starting the test case....");
		
		
			HomePage hp=new HomePage(driver);
			try {
		hp.clickMyacount();;
		
		logger.info("Clicking on my account...");
		hp.clickLogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.email(p.getProperty("username"));
		lp.pass(p.getProperty("password"));
		logger.info("Sucsesfully providing the email and password....");
		lp.clickLgn();
		
	    //Thread.sleep(3000);
		MyAccountlogin mlg= new MyAccountlogin(driver);
		//LoginPage lpg=new LoginPage(driver);
		boolean msg=mlg.myaccontconfi();
		
		System.out.println(msg);
		//Thread.sleep(3000);
		Assert.assertTrue(msg);
		
			//Assert.assertTrue(mlg.ismyacontExists());
		
		}catch(Exception e){
			logger.error("Test got fail...");
			Assert.fail();	
		
		}
		
		logger.info("Ending the test cases....");
		

}}

