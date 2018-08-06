package task;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.ElementLocation;
import util.ReadProperties;

public class CreateNewProduct {
	
	public static void CeateProduct (WebDriver driver,String prodname,String prodcode) throws InterruptedException, Exception, IOException{
		//进入产品界面
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","productwindow")).click();
		//进入产品界面
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","create")).click();
		
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","productname")).sendKeys(prodname);
		//进入产品界面
		ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","productcode")).sendKeys(prodcode);
		//利用js将不可见元素设为可见
		String js = "document.getElementById('PO').style.display='block';";
        ((JavascriptExecutor)driver).executeScript(js);
        WebElement po=ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","productowner"));
        //包装成下拉框元素
        Select productowner = new Select(po);
        productowner.selectByValue("admin");
        
        driver.switchTo().frame(0);
        ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","productdescription")).sendKeys("jindong");
        driver.switchTo().defaultContent();
        //移动到页面最底部  
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");  
        ElementLocation.locate(driver,"xpath", ReadProperties.getprop("zentao","savebutton")).click();
        Thread.sleep(3000);
		
	}

}
