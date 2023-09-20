package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class CheckOutPage extends ProjectSpecificMethod {
	public CheckOutPage(ChromeDriver driver,ExtentTest node) {
		this.driver= driver;
		this.node= node;
	}
	public CheckOutPage clickCheckOut () throws IOException {
		try {
			Thread.sleep(5000);
			WebElement checkOut = driver.findElement(By.xpath("//button[text()='Checkout']"));
			driver.executeScript("arguments[0].click();",checkOut);
			reportStep("CheckOut clicked Successfully", "pass");
		} catch (Exception e) {
			reportStep("CheckOut not clicked Successfully", "fail");
		}
		return this;
	}
	public CheckOutPage enterFirstName (String FName) throws IOException {
		try {
		
			driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(FName);
			reportStep(" Firstname Entered Successfully", "pass");
		} catch (Exception e) {
			reportStep("Firstname not Entered Successfully", "fail");
		}
		return this;
	}
	public CheckOutPage enterLastName (String LName) throws IOException {
		try {
		
			driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(LName);
			reportStep(" Lastname Entered Successfully", "pass");
		} catch (Exception e) {
			reportStep("Lastname not Entered Successfully", "fail");
		}
		return this;
	}
	public CheckOutPage enterPostalCode (String PCode) throws IOException {
		try {
		
			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(PCode);
			reportStep(" Postal Code Entered Successfully", "pass");
		} catch (Exception e) {
			reportStep("Postal Code not Entered Successfully", "fail");
		}
		return this;
	}
	public CheckOutPage clickSubmit () throws IOException {
		try {
		
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			reportStep("Continue clicked  Successfully", "pass");
		} catch (Exception e) {
			reportStep("Continue clicked  Successfully", "fail");
		}
		return this;
	}
	public CheckOutPage clickFinish () throws IOException {
		try {
		
			driver.findElement(By.xpath("//a[text()='FINISH']")).click();
			reportStep("Finish button clicked  Successfully", "pass");
		} catch (Exception e) {
			reportStep("Finish button clicked  Successfully", "fail");
		}
		return this;
	}
	public CheckOutPage checkValidation () throws IOException {
		try {
		
			String text = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")).getText();
			String text2 = driver.findElement(By.xpath("//div[contains(text(),'Your order has been dispatched')]")).getText();
			System.out.println(text);
			System.out.println(text2);
			reportStep("Validation done Successfully", "pass");
		} catch (Exception e) {
			reportStep("Validation not done Successfully", "fail");
		}
		return this;
	}



}
