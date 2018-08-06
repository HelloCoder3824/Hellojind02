
/**
 * @Title: TestngListener.java
 * @Package util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Administrator
 * @date 2018年7月2日
 * @version V1.0
 */

package util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import testcase.TestBase;

import java.util.Iterator;

/**
 * @ClassName: TestngListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年7月2日
 *
 */

public class TestngListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {

        TestBase tb = (TestBase) tr.getInstance();
        WebDriver driver = tb.getDriver();
        TakeScreenShot.takescreen(driver);
        System.out.println(driver.getTitle());

    }

    // 此时就需要在之前写的 TestNGListener监听器类中重写onFinish 方法,
    // 但是会在结果中会发现失败的 case 会生成多个，显然这样是不好的

    @Override
    public void onFinish(ITestContext context) {
        super.onFinish(context);
        //失败后重跑，记录最后一次结果
        Iterator<ITestResult> listOfFailedTests = context.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
    }

}