package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod{
	public HomePage(ChromeDriver driver,ExtentTest node) {
		this.driver= driver;
		this.node= node;
	}
	public HomePage SelectHighToLow () throws IOException {
		try {
			Select dropDown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
			dropDown.selectByVisibleText("Price (high to low)");
			//WebElement clickDropDown = driver.findElement(By.xpath("//span[@class='select_container']"));
			//driver.executeScript("arguments[0].click();",clickDropDown);
			// click = driver.findElement(By.xpath("//select[@class='product_sort_container']/option[text()='Price (high to low)']"));
			reportStep("High to Low selected Successfully", "pass");
		} catch (Exception e) {
			reportStep("High to Low not selected  Successfully", "fail");
		}
		return this;
	}
	public HomePage SelectItem1 () throws IOException {
		try {
			WebElement click = driver.findElement(By.xpath("//button[text()='Add to cart']"));
			driver.executeScript("arguments[0].click();",click);
			reportStep("Item1 clicked Successfully", "pass");
		} catch (Exception e) {
			reportStep("Item1 not clicked Successfully", "fail");
		}
		return this;
	}
	
	public CheckOutPage cartButton () throws IOException {
		try {
			WebElement clickCart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/*"));
			driver.executeScript("arguments[0].click();",clickCart);
			reportStep(" Cart botton clicked Successfully", "pass");
		} catch (Exception e) {
			reportStep("Cart botton not clicked Successfully", "fail");
		}
		return new CheckOutPage(driver, node);
	}

}
