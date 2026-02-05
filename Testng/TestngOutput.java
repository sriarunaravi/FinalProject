package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngOutput {
	@Test
	public void Output() {
		System.out.println("Hi");
	}
	@Test
	public void Fail() {
		Assert.assertEquals("https://www.google.com", "https://www.googles.com");

	}

}
