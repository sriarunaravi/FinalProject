package Testng;

import org.testng.annotations.Test;

public class prioritytest {
@Test(priority=3)
	public void testB() {
		System.out.println("B");
	}
@Test(priority=2)
	public void testA() {
		System.out.println("A");
	}
@Test(priority=1)
public void testc() {
	System.out.println("C");
}
}
