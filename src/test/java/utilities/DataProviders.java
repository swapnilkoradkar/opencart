package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import pageObject.BasePage;

public class DataProviders {//use it get te data from excel file and stored in two dimentional array
	
	//Dataprovider 1
	
	@DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
		
	   String path = System.getProperty("user.dir") + "\\testData\\LoginCredential.xlsx";//taking xl file from testdata
        
	   ExcelUtility xlutil = new ExcelUtility(path);//creating an object for xlutility
        
        int totalRows = xlutil.getRowCount("Sheet1");
        int totalCols = xlutil.getCellCount("Sheet1", 1);

        String[][] logindata = new String[totalRows][totalCols];//created for two dimentional array

        for (int i=1; i<=totalRows; i++)//read the data fro xl and stored in two dimentional array             // start at 1 to skip header
        {            
        	     for (int j=0; j<totalCols; j++)//0 i is row j is col
        	     {
               logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
            }
        }

        return logindata;//returning two dimentional array
    }
}
	
	
	
	//Dataprovider 2
	
	//DataProvider 3
	
	//DataProvider 4
	


