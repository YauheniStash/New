package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.MainPage;
import com.qa.page.SignUpPage;


public class SignUpPageTest extends Base {
	MainPage mainPage;
	SignUpPage signUpPage;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInitializing();
		getUrl();
		mainPage = new MainPage(driver);
		signUpPage = mainPage.clickSignUp();
	}

	@Test
	public void verifyTitle() {
		String title = signUpPage.getTitle();
		Assert.assertEquals("Sign up for fluent.express", title);
	}
	
	@Test
	public void registrationWithEmail() {
		signUpPage.registration(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	@Test
	public void registrationWithEmail2() {
		signUpPage.registration(prop.getProperty("email2"), prop.getProperty("password2"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
