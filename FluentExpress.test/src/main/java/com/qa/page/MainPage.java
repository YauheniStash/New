package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class MainPage extends Base {
	@FindBy(linkText="Log in")
	WebElement SignInButton;
	
	@FindBy(linkText="Sign up")
	WebElement SignUpButton;
	
	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public SignInPage clickSignIn() {
		SignInButton.click();
		return new SignInPage(driver);
	}
	public SignUpPage clickSignUp() {
		SignUpButton.click();
		return new SignUpPage(driver);
	}

	
	
	public String getTitle() {
	String title=	driver.getTitle();
	return title;
	}

}
