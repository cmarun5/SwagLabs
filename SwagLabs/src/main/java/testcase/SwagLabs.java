package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class SwagLabs extends ProjectSpecificMethod {
	@BeforeTest
	public void setup() {
		sheets="SwagLab";
		testName = "MitrahSoft_SwagLab";
		testDescription ="Adelaide_Login";
		testCategory = "Regression";
		testAuthor ="Arun";
	}
		
		@Test(dataProvider = "testData")
		
		public void salesforceTest(String uname, String pwd, String FName, String LName,String PCode) throws IOException {
			LoginPage lpage=new LoginPage(driver,node);
			lpage.enterUserName(uname).enterPassWord(pwd).clickLogInButton().clickMenu().clickAbout().SelectHighToLow()
			.SelectItem1().cartButton()
			.clickCheckOut().enterFirstName(FName).enterLastName(LName).enterPostalCode(PCode).clickSubmit().clickFinish().checkValidation();
			
		}

}
