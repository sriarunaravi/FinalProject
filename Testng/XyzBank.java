package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class XyzBank {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void customerLoginAndDepositTest() {
        WebElement customerLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Customer Login']")));
        customerLogin.click();
        WebElement userDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
        Select customerDropdown = new Select(userDropdown);
        customerDropdown.selectByVisibleText("Harry Potter");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and text()='Login']")));
        loginButton.click();
        WebElement depositTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='deposit()']")));
        depositTab.click();      
        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='amount']")));
        amountInput.sendKeys("2000");      
        WebElement depositButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Deposit']")));
        depositButton.click();      
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-show='message']")));
        Assert.assertEquals(successMessage.getText(),"Deposit Successful","Deposit failed");
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Logout']")));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button not visible");
        logoutButton.click();     
        WebElement customerLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Customer Login']")));
        Assert.assertTrue(customerLoginButton.isDisplayed(),"Customer Login button not visible");
    }
    @AfterMethod
    public void tearDown() {     
        driver.quit();
    }
}

	

