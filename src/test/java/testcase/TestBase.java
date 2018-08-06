
    /**  
    * @Title: TestBase.java
    * @Package testcase
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年7月2日
    * @version V1.0  
    */
    
package testcase;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import util.BrowserSelect;

import java.sql.Driver;

    /**
    * @ClassName: TestBase
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年7月2日
    *
    */

public class TestBase {
	
	public WebDriver driver;   
    
    
   public WebDriver getDriver() {

       return driver;
   }
   @Parameters({"url","browser"})
   @BeforeMethod
   public WebDriver setUp(String url,String browser) throws InterruptedException {
       driver=BrowserSelect.browser(driver,browser,url);
		/*
       System.setProperty("webdriver.chrome.driver", "e:\\driver\\chromedriver.exe");
		// 设置系统属性：chrome的启动路径
		 driver = new ChromeDriver();
		// 向上转型，实例化ChromeDriver对象
       /*
       driver.manage().window().maximize();
       driver.navigate().to("http://www.baidu.com");   
       */
		return driver;
   }
    
   @AfterMethod
   public void tearDown(){
       driver.close();

   }

}
