package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelect {
	
	public static WebDriver  browser(WebDriver driver,String browsername,String url) throws InterruptedException{
	
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "e:\\driver\\chromedriver.exe");
			// 设置系统属性：chrome的启动路径
			 driver = new ChromeDriver();
			// 向上转型，实例化ChromeDriver对象
		}
		else if(browsername.equals("ie")){
			
			System.setProperty("webdriver.chrome.driver", "e:\\driver\\iedriverserver.exe");
			// 设置系统属性：chrome的启动路径
			 driver = new InternetExplorerDriver();
			// 向上转型，实例化ChromeDriver对象
			
		}
		else if(browsername.equals("firefox")){
			
			System.setProperty("webdriver.chrome.driver", "e:\\driver\\iedriverserver.exe");
			// 设置系统属性：chrome的启动路径
			 driver = new FirefoxDriver();
			// 向上转型，实例化ChromeDriver对象
			 
		}
		driver.manage().window().maximize();
		Thread.sleep(1000);	
		driver.get(url);
		Thread.sleep(1000);	

		return driver;
			
	}

}
