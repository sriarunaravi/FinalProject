package Testng;


	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.*;

	
	public class Parabankfinalproject {
	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        driver.get("https://parabank.parasoft.com/parabank/register.htm");
	    }

	    // ✅ REGISTER
	    @Test
	    public void registerTest() {
	        driver.findElement(By.name("customer.firstName")).sendKeys("ABC");
	        driver.findElement(By.name("customer.lastName")).sendKeys("Doe");
	        driver.findElement(By.name("customer.address.street")).sendKeys("123 main street");
	        driver.findElement(By.name("customer.address.city")).sendKeys("New York");
	        driver.findElement(By.name("customer.address.state")).sendKeys("NY");
	        driver.findElement(By.name("customer.address.zipCode")).sendKeys("10001");
	        driver.findElement(By.name("customer.phoneNumber")).sendKeys("1234567890");
	        driver.findElement(By.name("customer.ssn")).sendKeys("123-45-6789");
	        driver.findElement(By.name("customer.username")).sendKeys("arunaa");
	        driver.findElement(By.name("customer.password")).sendKeys("987654");
	        driver.findElement(By.name("repeatedPassword")).sendKeys("987654");
	        driver.findElement(By.xpath("//input[@value='Register']")).click();

	        // ✅ Assertion – verify registration success
	        WebElement successMsg = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Welcome']")));
	        Assert.assertTrue(successMsg.isDisplayed(), "Registration failed!");
	    }

	    // ✅ LOGIN → runs only if registerTest passes
	    @Test(dependsOnMethods = "registerTest")
	    public void loginTest() {
	        driver.findElement(By.name("username")).sendKeys("arunaa");
	        driver.findElement(By.name("password")).sendKeys("987654");
	        driver.findElement(By.xpath("//input[@value='Log In']")).click();

	        // ✅ Assertion – verify login success
	        WebElement accountOverview = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts Overview")));
	        Assert.assertTrue(accountOverview.isDisplayed(), "Login failed!");
	    }

	    // ✅ OPEN NEW ACCOUNT → runs only if loginTest passes
	    @Test(dependsOnMethods = "loginTest")
	    public void openAccountTest() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open New Account"))).click();

	        Select accountType = new Select(driver.findElement(By.id("type")));
	        accountType.selectByVisibleText("CHECKING");

	        Select fromAccount = new Select(driver.findElement(By.id("fromAccountId")));
	        fromAccount.selectByIndex(0);

	        driver.findElement(By.xpath("//input[@value='Open New Account']")).click();

	        WebElement newAccountId = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId")));

	        // ✅ Assertion – verify new account created
	        Assert.assertTrue(newAccountId.isDisplayed(), "Account creation failed!");
	        newAccountId.click();
	    }

	    // ✅ LOGOUT → runs only if openAccountTest passes
	    @Test(dependsOnMethods = "openAccountTest")
	    public void logoutTest() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out"))).click();

	        // ✅ Assertion – verify logout success
	        WebElement loginBtn = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Log In']")));
	        Assert.assertTrue(loginBtn.isDisplayed(), "Logout failed!");
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	}
