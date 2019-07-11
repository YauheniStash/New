package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class YourTextsPage extends Base {

	@FindBy(xpath="//div[@class='mw7 center mv3 mv5-ns']/div[1]/div[1]")
	WebElement TextConfirmationTime;
	
	
	public YourTextsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public String getTextConfirmationTime() {
	String text=	TextConfirmationTime.getText();
	return text;
	}
}
