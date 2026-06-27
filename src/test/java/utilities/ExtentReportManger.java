package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManger implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public String repName;
	public void onStart(ITestContext testContext){//implements ITestListener
		
		//to adding time and date stamp
	/*	SimpleDateFormat df=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss");
		Date dt=new Date();
     	String currentdatetimestamp=df.format(dt);
	*/
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// create time stand format
		
		
		repName="Test-Report-"+timestamp+".html";
		sparkReporter =new ExtentSparkReporter("./reports/" +repName);// specify location of the reporter
		
		sparkReporter.config().setDocumentTitle("Opencart Automation Report");//Title of report
		sparkReporter.config().setReportName("Opencart Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		//fill the project specify details who test it where test in the this are print in test report 
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart"); //name of appl
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module","customers");
		extent.setSystemInfo("user Name", "Swapnil koradkar");//System.getProperty("user.name")
	    extent.setSystemInfo("Enviroment", "QA");
	
	
	    String os = testContext.getCurrentXmlTest().getParameter("os");//which operating system are use or pass in xml file 
	    extent.setSystemInfo("Operating System", os); // save the oprating system name in report
	    
	    String browser = testContext.getCurrentXmlTest().getParameter("browser");// get browser pass through xml
	    extent.setSystemInfo("Browser", browser);//save in test report
	    
	    List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();// get the list of include groups
	    if(!includedGroups.isEmpty()) {// use not operator that why if is it a element then got o inner loop
	    	
	    		extent.setSystemInfo("Groups", includedGroups.toString());//print on report a list of group if its have element
	    }
	}
	
	public void onTestSuccess(ITestResult result) { //if test is passed or success
		
		test=extent.createTest(result.getName());//.getTestClass()getting the testclass in that class getting the name of class and then creat the new test in the report
		test.assignCategory(result.getMethod().getGroups());//it getting the method and that method get groups and attach to category wise in test report 
		test.log(Status.PASS, result.getName()+" got successfull executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());//to display groups in report
		
		test.log(Status.FAIL,result.getName()+" got failed");//it get the test failure information
		test.log(Status.INFO, result.getThrowable().getMessage());//printing the error message
		try {
			
		String imgpath = new BaseClass().captureScreen(result.getName());//create the method of base class and and pass the test name which are failed and it  return the path of screen shot stored in img 
		test.addScreenCaptureFromPath(imgpath);// add the screen shot

		}catch(IOException e1){
			e1.printStackTrace();
		}
			
		}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName() + "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();//saves and writes all test logs to the report file
		
		
		// it open the report which are created automatically using below code and also u can open manually to go to the reports folder refresh it open through system editor
		String pathOfExtentReport = System.getProperty("user.dir")+ "/reports/" + repName; // path of the report
		File extentReport = new File (pathOfExtentReport);// create the file object and pass the path of report
		
		try{
			Desktop.getDesktop().browse(extentReport.toURI());// predefine class and just pass the report and it open directly
		    //Desktop.getDesktop().open(extentReport);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	/*	
		// send the email directly to the people or team member
		//First add the dependency java email in pom xml
		  try {
			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
			
			//Create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");// it changeing if u have email id u can try it 
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("vertusa12@gmail.com","password"));// who send it pass the email and password
			email.setSSLOnConnect(true);
			email.setFrom("swapnilkoradkar0573@gmail.com");// sender email
			email.setSubject("Test Result");
			email.setMsg("Please find Attached Report....");
			email.addTo("denverdensel12@gmail.com");// multiple Reciver also we can add it or team memeber email
			email.attach(url,"extent report", "please check report....");
			email.send();//send the email
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	*/
		
		
	}
	
}
