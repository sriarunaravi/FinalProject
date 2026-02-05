package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependsontest {
	@Test
	public void testlogin() {
		Assert.assertTrue(false);
	}
@Test (dependsOnMethods = {"testlogin"})
public void testhome() {
	System.out.println("A");
}
//@Test 
//public void testhome1() {
//	System.out.println("C");
//}
@Test (dependsOnMethods = {"testlogin","testhome"})
public void testhome1() {
	System.out.println("testC");
}
}
