package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class SignUpPage extends Base {
	
	@FindBy(name = "email")
	WebElement EmailTextField;

	@FindBy(name = "password")
	WebElement PasswordTextField;

	@FindBy(xpath = "//button[text()='Register']")
	WebElement RegistrationButton;

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ActivateAccountPage registration(String Email, String Password) {
		EmailTextField.sendKeys(Email);
		PasswordTextField.sendKeys(Password);
		RegistrationButton.click();
		return new ActivateAccountPage(driver);

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}
}
