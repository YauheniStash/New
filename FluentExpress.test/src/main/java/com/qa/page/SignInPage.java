package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class SignInPage extends Base {

	@FindBy(name="email")
	WebElement EmailTextField;
	
	@FindBy(name="password")
	WebElement PasswordTextField;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement SignInButton;



	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	}
	
	public UsersHomePage  login (String Email, String Password) {
		EmailTextField.sendKeys(Email);
		PasswordTextField.sendKeys(Password);
		SignInButton.click();
		return new UsersHomePage(driver);
	}

	public RequestsQueuePage  loginAsEditor (String editorsEmail, String editorsPassword) {
		EmailTextField.sendKeys(editorsEmail);
		PasswordTextField.sendKeys(editorsPassword);
		SignInButton.click();
		return new RequestsQueuePage(driver);
	}



	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

}
