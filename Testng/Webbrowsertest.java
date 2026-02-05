package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webbrowsertest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test
	public void sampleoutput() {
		String expected="Swag Labs";
		Assert.assertEquals(driver.getTitle(),expected,"Page is incorrect");
	System.out.println("Page is Correct");
	}
	@Test
	public void buttondisplay() {
		WebElement button=driver.findElement(By.id("login-button"));
		boolean buttondisplay=button.isDisplayed();
		Assert.assertTrue(buttondisplay,"Button is not displayed");
		System.out.println("Button Is Displayed");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
