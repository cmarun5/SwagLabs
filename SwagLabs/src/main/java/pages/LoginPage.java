package pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	public LoginPage(ChromeDriver driver,ExtentTest node) {
		this.driver= driver;
		this.node= node;
	}
	public LoginPage enterUserName (String uname) throws IOException {
		try {
		;
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(uname,Keys.TAB);
			reportStep(uname+ "Entered username is Entered Successfully", "pass");
		} catch (Exception e) {
			reportStep(uname+ "Entered username is not Entered Successfully", "fail");
		}
		return this;
	}
		
		public LoginPage enterPassWord(String pwd) throws IOException {
		try {
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
			reportStep(pwd+ "Entered password is Entered Successfully", "pass");
		} catch (Exception e) {
			reportStep(pwd+ "Entered password is not entered successfully", "fail");
		}
		return this;
		}
		
		public HomePage clickLogInButton() throws IOException {
			try {
				driver.findElement(By.xpath("//input[@id='login-button']")).click();
				reportStep("LogIn Button is clicked Successfully", "pass");
			} catch (Exception e) {
				reportStep("LogIn Button is not clicked Successfully", "fail");
			}
			return new HomePage(driver, node);
	
	}

}


