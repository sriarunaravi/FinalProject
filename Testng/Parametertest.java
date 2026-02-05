package Testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametertest {
@Test
@Parameters ({"url","Browser"})
public void Testresult(String url ,String Browser) {
System.out.println("Url:"+url);
System.out.println("Browser:"+Browser);
}
}
