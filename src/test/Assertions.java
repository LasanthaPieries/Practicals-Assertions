package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	SoftAssert soft = new SoftAssert();
	WebDriver driver = null;
	
	@Test
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(dependsOnMethods= {"launch"})
	public void sauceDemo() {
		driver.get("https://www.saucedemo.com");
		soft.assertEquals(driver.getTitle(), "abc");
	}
	
	@Test(dependsOnMethods= {"sauceDemo"})
	public void login() {
		driver.findElement(By.id("login-button")).click();
		soft.assertEquals(driver.findElement(By.xpath("//button[@class='error-button']")).getText(), "Epic sadface: Username is required");
		soft.assertAll();
	}
}
