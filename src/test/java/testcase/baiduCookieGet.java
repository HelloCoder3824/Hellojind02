package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @class: baiduCookieGet
 * @description:
 * @author: 14328
 * @create: 2018-07-18 11:25
 **/
public class baiduCookieGet {

    public WebDriver driver;

    @Test
    public void getcookie() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "e:\\driver\\chromedriver.exe");
        // 设置系统属性：chrome的启动路径
        driver = new ChromeDriver();
        // 向上转型，实例化ChromeDriver对象
        driver.get("http://www.baidu.com");
        // 增加一个 name = "name",value="value" 的 cookie
        Cookie cookie = new Cookie("name", "value");
        driver.manage().addCookie(cookie);
        // 得到当前页面下所有的 cookies ，并且输出它们的所在域、name、value、有效日期和路径
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(String.format("Domain -> name -> value -> expiry -> path"));
        for(Cookie c : cookies) System.out.println(String.format("%s -> %s -> %s -> %s -> %s",c.getDomain(), c.getName(),
                c.getValue(),c.getPath(),c.getExpiry()));
        //删除所有的cookie
       // driver.manage().deleteAllCookies();
        // 通过fiddler抓包工具，找到Host为“passport.baidu.com”的URL，在右侧窗口查看该请求的Cookie，
        // 找到重要的两个参数“BAIDUID”和“BDUSS”
       // Cookie c1 = new Cookie("BAIDUID", "41CDF7E6EAE9AB6D341336E22CACCAB6:SL=0:NR=10:FG=1");
        Cookie c2 = new Cookie("BDUSS", "GdNWnVkLURERWN5RkRxVmNJa2dXYmJ3SkhlNFQtbmlSaVBzUm1TWXpjSXVLMzFiQVFBQUFBJCQAAAAAAAAAAAEAAADYSH0~ztKwrszSu6ji1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC6eVVsunlVbW");

        //driver.manage().addCookie(c1);

        driver.manage().addCookie(c2);

        Thread.sleep(3000);
        driver.get("http://www.baidu.com");
       // driver.navigate().refresh();
        /*
        // 获得登录用户名
        String username = driver.findElement(By.className("user-name")).getText();
        System.out.println("username = " + username);
        */
        System.out.println(driver.manage().getCookies());

        Thread.sleep(3000);
       // driver.quit();

    }
}
