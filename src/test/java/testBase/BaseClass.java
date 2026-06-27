package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import lombok.Builder.Default;

import org.apache.logging.log4j.LogManager;//log4j2
import org.apache.logging.log4j.Logger;//log4j2

public class BaseClass {
	
	//add the method here which we are reuasablelity or need to use again and again
 
    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    
   

	@BeforeClass(groups={"sanity","regration","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br)throws IOException {
	    //    @Optional("windows") 
	        //@Optional("chrome") ) 
		
		//loading config.properties file
		
		FileReader file =new FileReader("./src//test//resources//Config.Properties");
    	    p=new Properties();
    	    p.load(file);
    
    	    
			if(p.getProperty("execution_env").equals("remote")) {
				
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				//os
				if(os.equalsIgnoreCase("windows")) {
					
					capabilities.setPlatform(Platform.WINDOWS);
					
				}else if(os.equalsIgnoreCase("mac")) {
					
					capabilities.setPlatform(Platform.MAC);
					
				}else if(os.equalsIgnoreCase("Linux")) {
					
					capabilities.setPlatform(Platform.LINUX);
				}else {
					System.out.println("Invalid operating system...");
						return;
				}
				
				
				//browser
				if(br.equalsIgnoreCase("chrome")) {
					
					capabilities.setBrowserName("chrome");
					
				
				}else if(br.equalsIgnoreCase("edge")) {
					
					capabilities.setBrowserName("");
					
				}else if(br.equalsIgnoreCase("firefox")) {
					
					capabilities.setBrowserName("firefox");
				}else {
					System.out.println("Invalid browser....");
					return;
				}
				
    	    	
				 driver= new RemoteWebDriver(new URL("http://192.168.21.32:4444"),capabilities);
    	   
			}
    	    
    	    
    	    
    	    
    	    
   	    
    	    
    	    if(p.getProperty("execution_env").equals("local")) {
    	    	
    	    
		switch(br.toLowerCase()) {//to get a parameter of browser from xml file
		case "chrome" :driver=new ChromeDriver();break;
		case "Edge" : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default :System.out.println("Invalid browser"); return;
		
		}
		}
         //WebDriver driver=new ChromeDriver();
		logger=LogManager.getLogger(this.getClass());
		
		//driver=new ChromeDriver();
		driver.get(p.getProperty("url2"));// Reading url from the properties file
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
    @AfterClass(groups= {"sanity","regration","master"})
	public void tearDown() {
		driver.quit();
	}
	
public String randomAlphabt() {
		
		String genratestring =RandomStringUtils.randomAlphabetic(5);
		return genratestring; 
		
	}
	
	public String randomNumric() {
		String randomnumber=RandomStringUtils.randomNumeric(10);
		return randomnumber;
	}
	
	public String randomAlphaNumric() {
		String alphanume=RandomStringUtils.randomAlphanumeric(5);
		return alphanume;
	}

	public String captureScreen(String tname) throws IOException{
		
		String timeStamp = new SimpleDateFormat("yyyymmddmmss").format(new Date());//generate the time stamp beacuse the when we run test case that time it take multiple ascreenshotsthat why we give the stamp to not replace the prevoius file
		
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;// take screen shot sepecial types of the interface 
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);// save imto file  
		                                                                          
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";// generate the name with the timestamp copy that into target file
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);//just rename the file name with the timestamp    
		
		return targetFilePath;// beacuse we need the file path to attach the screenshot to the report
	}
}
