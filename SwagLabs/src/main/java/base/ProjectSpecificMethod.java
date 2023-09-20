package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadExcel;



public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public ChromeDriverService options;
	public String sheets;
	public static  ExtentReports extent;
	public ExtentTest test,node;
	public static String testName, testDescription,testAuthor, testCategory;
    @BeforeSuite
    public void startReport() {
        ExtentHtmlReporter reporter =new ExtentHtmlReporter("./reports/result1.html");
        reporter.setAppendExisting(true);
        extent =new ExtentReports();
        extent.attachReporter(reporter);
    }
    @AfterSuite
    public void stopReport() {
         extent.flush();
         
         
         
    }
    @BeforeClass
    public void testDetail() {  
    	test= extent.createTest(testName,testDescription);
        test.assignCategory(testCategory);
        test.assignAuthor(testAuthor);
    }
    public int takeSnap() throws IOException {
    	int randomNum = (int)(Math.random()*99999+100000);
    	File source = driver.getScreenshotAs(OutputType.FILE);
    	File target = new File("snaps/img"+randomNum+".png");
    	FileUtils.copyFile(source, target);
    	return randomNum;
    }
    public void reportStep(String stepDesc, String status) throws IOException {
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
    	}
    	else if (status.equalsIgnoreCase("fail")) {
    		node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
    	}
    }
	@BeforeMethod
	public void preCondition() {
		node= test.createNode(testName);
		driver = new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--enable-javascript");
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	@DataProvider
    public String[][] testData() throws IOException  {
    String[][] readData = ReadExcel.readData(sheets);
       return readData;
}
}
