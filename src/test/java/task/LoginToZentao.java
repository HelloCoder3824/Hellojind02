package task;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.ElementLocation;
import util.ReadProperties;
import util.TakeScreenShot;

public class LoginToZentao {
	
	public static void besearch (WebDriver driver,String username,String password) throws InterruptedException, Exception, IOException{
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","username")).clear();
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","username")).sendKeys(username);
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","password")).clear();
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","password")).sendKeys(password);
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","loginbt")).click();
		Thread.sleep(2000);	
	}
}
