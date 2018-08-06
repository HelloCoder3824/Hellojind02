package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementLocation {
	public static WebElement locate(WebDriver dr,String locatetype,String locatepath){
		WebElement el=null;
		WebDriverWait w=new WebDriverWait(dr,30);
		if(locatetype.equals("id")){
			w.until(ExpectedConditions.elementToBeClickable(By.id(locatepath)));
			el=dr.findElement(By.id(locatepath));
		}
		else if (locatetype.equals("name")) {
			w.until(ExpectedConditions.elementToBeClickable(By.name(locatepath)));
			el=dr.findElement(By.name(locatepath));
		}
		else if (locatetype.equals("classname")) {
			w.until(ExpectedConditions.elementToBeClickable(By.className(locatepath)));
			el=dr.findElement(By.className(locatepath));
		}
		else if (locatetype.equals("tagname")) {
			w.until(ExpectedConditions.elementToBeClickable(By.tagName(locatepath)));
			el=dr.findElement(By.tagName(locatepath));
		}
		else if (locatetype.equals("linktext")) {
			w.until(ExpectedConditions.elementToBeClickable(By.linkText(locatepath)));
			el=dr.findElement(By.linkText(locatepath));
		}
		else if (locatetype.equals("xpath")) {
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(locatepath)));
			el=dr.findElement(By.xpath(locatepath));
		}
		return el;
	}

}                                           
