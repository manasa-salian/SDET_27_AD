package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {
@Test(retryAnalyzer=com.crm.autodesk.genericutility.RetryAnalyserImpl.class)
public void retryAnalyserDemoTest() {
	System.out.println("Retry Analyzer");
	Assert.fail();
}
		
}
