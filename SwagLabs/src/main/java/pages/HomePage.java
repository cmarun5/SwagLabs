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
	public HomePage clickMenu () throws IOException {
		try {
			WebElement clickmenu = driver.findElement(By.xpath("//button[text()='Open Menu']"));
			driver.executeScript("arguments[0].click();",clickmenu);
			reportStep(" Menu clicked Successfully", "pass");
		} catch (Exception e) {
			reportStep("Menu not clicked Successfully", "fail");
		}
		return this;
	}
	public HomePage clickAbout () throws IOException {
		try {
			WebElement clickAbout = driver.findElement(By.xpath("//a[text()='About']"));
			driver.executeScript("arguments[0].click();",clickAbout);
			Thread.sleep(5000);
	        driver.navigate().back();
			reportStep(" About clicked Successfully", "pass");
		} catch (Exception e) {
			reportStep("About not clicked Successfully", "fail");
		}
		return this;
	}
	public HomePage SelectHighToLow () throws IOException {
		try {
			Select dropDown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
			dropDown.selectByVisibleText("Price (high to low)");
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
