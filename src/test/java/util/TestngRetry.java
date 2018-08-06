package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @class: TestngRetry
 * @description:创建一个 TestngRetry 类并继承 IRetryAnalyzer 接口实现 retry 方法，并实现重跑逻辑
 * @author: 14328
 * @create: 2018-07-11 16:31
 **/
public class TestngRetry implements IRetryAnalyzer {


    /*
    返回 true ： 代表重跑
    返回 false ：关闭重跑
    */
    private int  retryCount = 0;
    // 定义重跑次数
    private int  maxRetryCount = 1;
    // 定义最大重跑次数

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount){
            retryCount ++;
            return true;
        }
        return false;
    }

}
