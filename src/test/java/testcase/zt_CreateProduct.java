package testcase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import net.sourceforge.htmlunit.cyberneko.HTMLElements.ElementList;
import task.BaiduSearch;
import task.CreateNewProduct;
import task.LoginToZentao;
import util.BrowserSelect;
import util.ElementLocation;
import util.RangeDatabyPOI;
import util.ReadProperties;
import util.TakeScreenShot;

public class zt_CreateProduct {
	private static Logger log=Logger.getLogger(Test.class);
	WebDriver driver=null;
	String starturl;
	String br;
	String uname;
	String upassword;
	String prodname="jd";
	String prodcode="001";
	
	@Parameters({"url","browser","username","password"})
	//@BeforeMethod
	@BeforeTest
	public void c(String url,String browser,String username,String password) throws InterruptedException{
		starturl=url;
		br=browser;
		uname=username;
		upassword=password;
		/*
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
		// 设置系统属性：chrome的启动路径
		 driver = new ChromeDriver();
		// 向上转型，实例化ChromeDriver对象
		}
		driver.manage().window().maximize();
		 Thread.sleep(1000);
		 driver.get(url);
			Thread.sleep(1000);
		*/
	}

	
	/*@DataProvider(name="exceltest")
	public Object[][] excelread() throws IOException{
		Object[][] array=RangeDatabyPOI.poiRangeData("D:/myeclipse01/selenium05/test.xlsx");
		return array;
	}
	*/
	
	
	//@Test(dataProvider="exceltest")
	@Test
	public void aa() throws Exception {
		//执行打开浏览器操作
		BrowserSelect.browser(driver, br, starturl);
		//执行登录操作
		LoginToZentao.besearch(driver, uname, upassword);
		//截图
		TakeScreenShot.takescreen(driver);
		
		CreateNewProduct.CeateProduct(driver, prodname, prodcode);
		
		/*BaiduSearch.besearch(driver,content1 );
		log.info("kgc");
		BaiduSearch.besearch(driver,content2 );
		
		/*
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","search")).clear();
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","search")).sendKeys(content1);
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","button")).click();
		Thread.sleep(3000);
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","search")).clear();
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","search")).sendKeys(content2);
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("element","button")).click();
		/*
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys(content1);
		driver.findElement(By.id("su")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys(content2);
		driver.findElement(By.id("su")).click();
		*/
		driver.close();
		
		
	}


}
