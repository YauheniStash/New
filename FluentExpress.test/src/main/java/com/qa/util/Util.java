package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.Base;
import com.qa.page.GetMoreChractersPage;

public class Util extends Base {
	
	public Util (WebDriver driver) {
	this.driver=driver;
}
	public void swithToFramework(String xpath, String text) {
		int size=driver.findElements(By.tagName("iframe")).size();
		for (int i=0;i<size;i++) {
			driver.switchTo().frame(i);
		int element=	driver.findElements(By.xpath(xpath)).size();
			if(element>0) {
				driver.findElement(By.xpath(xpath)).sendKeys(text);;
			}
		}
	}
public void swithingToFramework(String name) {
	driver.switchTo().frame(name);
}

}
