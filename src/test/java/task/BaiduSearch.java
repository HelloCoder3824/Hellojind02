package task;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.ElementLocation;
import util.ReadProperties;

public class BaiduSearch {
	public static void besearch (WebDriver driver,String search) throws InterruptedException, Exception, IOException{
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","search")).clear();
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","search")).sendKeys(search);
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","button")).click();
		Thread.sleep(3000);
		
	}

}
