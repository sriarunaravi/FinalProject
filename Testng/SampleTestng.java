package Testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestng {

	@BeforeTest
	public void beforetest() {
	System.out.println("I am Inside @Before Test");
}
	@BeforeMethod
	public void beforemethod() {

		System.out.println("I am Inside @BeforeMethod");
	}
	@Test
	public void testoutput() {
		System.out.println("I am Inside @Test");

	}
	@Test
	public void testfail() {
	Assert.assertEquals(false,true);
	}
	@AfterTest
	public void aftertest() {
		System.out.println("I am Inside @@AfterTest");

	}
@AfterMethod
public void aftermethod() {
	System.out.println("I am Inside @@Aftermethod");
}
}
