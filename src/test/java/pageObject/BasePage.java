package pageObject;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.collections4.Get;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	public Logger logger;
	public Properties p;
      public  BasePage(WebDriver driver) throws IOException{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		FileReader file=new FileReader(".//src//test//resources//Config.Properties");
		p= new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
	}

}
