package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObject.SearchPage;
import testBase.LoginComan;

public class TC005_SearchProductTest extends LoginComan {
	

 @Test
	public void search() {
		
			
		//search atom page
		try {	
		SearchPage sp= new SearchPage(driver);
		String name=sp.searchtext("Mobile");
		//System.out.println(name);
		
		if(name != "search") {
			Assert.assertTrue(true);
		}

		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	
}
