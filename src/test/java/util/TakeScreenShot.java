package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {



	public static void takescreen(WebDriver driver){


		//获取当前磁盘路径
		String curpath=System.getProperty("user.dir");
		//System.out.println(curpath);
		Date date = new Date();
	 	String sj = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(date);
/*
		//获取当前时间
		Long date=System.currentTimeMillis();
		//转换为String类型
		String path=String.valueOf(date);
	*/
		//设置截图名称
		String screenpath=curpath+"/"+sj+".png";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenFile = new File(screenpath);

		try {
	      FileUtils.copyFile(srcFile,screenFile);


		} catch (IOException e) {


			e.printStackTrace();
	    }
		
	}

}
