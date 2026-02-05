package Testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Loginlandedcorrectly {
		WebDriver driver;
		@BeforeMethod
		public void setup() {
			driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			}
		@Test
        public void LoginCorrectly() {
		WebElement Username=driver.findElement(By.id("user-name"));
		Username.sendKeys("standard_user");
		WebElement Password=driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		WebElement Loginbutton=driver.findElement(By.id("login-button"));
		Loginbutton.click();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
	    String Actualurl=driver.getCurrentUrl();
	    Assert.assertEquals(Actualurl,expectedUrl,"Given Username or Password Incorrect");
	    System.out.println("Page Is Login Correctly");
}
@AfterMethod
public void close() {
	driver.close();
	
}
}
