package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class ActivateAccountPage extends Base {
	
	@FindBy(linkText="Go to GMail")
	WebElement GoToGmailLink;
	

	public ActivateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
public GooglePage clickGoToEmail() {
	GoToGmailLink.click();
	return new GooglePage(driver);
}
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyUserEmail(String Email) {
		boolean b=driver.findElement(By.xpath("//span[contains(text(),'"+Email+"')]")).isDisplayed();
		return b;
	}

}
