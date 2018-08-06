package util;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @class: RetryListener
 * @description:添加用例重跑监听器 RetryListener 继承 IAnnotationTransformer 接口实现transform方法，
 * 实现用例失败时重跑功能
 * @author: 14328
 * @create: 2018-07-11 16:41
 **/
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestngRetry.class); //注意这里的类名
        }
    }
}

