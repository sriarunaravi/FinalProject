package Testng;

import org.testng.annotations.Test;

public class Groupingtest {
    @Test (groups = {"Smoke"})
      public void testlogin() {
	System.out.println("TestLogin");
}
    @Test (groups= {"Smoke"})
    public void testsearch() {
    	System.out.println("TestSearch");
    }
    @Test (groups= {"Smoke"})
    public void testproduct() {
    	System.out.println("TestProduct");
    }
    @Test (groups= {"Regression"})
    public void testcheckout() {
    	System.out.println("TestSearch");
    }
}
