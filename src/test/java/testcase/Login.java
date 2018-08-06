
/**  
* @Title: Login.java
* @Package testcase
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator
* @date 2018年7月1日
* @version V1.0  
*/

package testcase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.BrowserSelect;
import util.TestngListener;

/**
 * @ClassName: Login
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年7月1日
 *
 */
//@Listeners({ TestngListener.class })
public class Login extends TestBase {

	@Test
	public void login() throws InterruptedException {
		/**
		* @Description:
		* @Param: []
		* @return: void
		* @Author: jd
		* @Date: 2018/7/11
		* @Time: 15:28
		*/

		//driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("op");
		driver.findElement(By.id("suy")).click();
		Thread.sleep(2000);
		

	}

}
