package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.Base;

public class GooglePage extends Base{
	public GooglePage(WebDriver driver) {
		this.driver=driver;
	}
public String getTitle() {
	String title=driver.getTitle();
	return title;
}
public void GmailSignIn() throws InterruptedException {
	driver.findElement(By.id("identifierId")).sendKeys("stashaniny@gmail.com");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("tel6051443");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(9000);
	int size=driver.findElements(By.tagName("iframe")).size();
	for (int i=0;i<size;i++) {
		driver.switchTo().frame(i);
		driver.findElements(By.xpath("//tr[@id=':2u']")).size();
		if(size>0) {
			driver.findElement(By.xpath("//tr[@id=':2u']")).click();
		}
	}
	
	//WebElement button=driver.findElement(By.xpath("//tr[@id=':2u']"));
	//button.click();
	
/*WebElement button=	driver.findElement(By.xpath("//span[@id=':32']//span[contains(text(),'Fluent.Express: Complete your registration')]"));
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", button);*/

}
private void click() {
	// TODO Auto-generated method stub
	
}
}
