package Testng;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
public class EcommerceTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));     
        driver.get("https://www.demoblaze.com/");
    }
  @Test
    public void HomepageTest() {
	  String expectedHomePageTitle="STORE";
      String actualHomePageTitle=driver.getTitle();
      Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle,"Home Page is not loaded properly!");
      System.out.println("Home Page loaded successfully!");
  }
  @Test
  public void ProductpageTest() {
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='prod.html?idp_=1']")));  
        productLink.click();
        String expectedUrl = "prod.html?idp_=1";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl),"Product page did not load successfully!");
        System.out.println("product page loaded successfully!");
    }
    @AfterMethod
    public void tearDown() {
            driver.quit();
        }
    }

