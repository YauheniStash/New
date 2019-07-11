package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.ActivateAccountPage;
import com.qa.page.MainPage;
import com.qa.page.SignUpPage;

public class ActivateAccountTest extends Base {
	MainPage mainPage;
	SignUpPage signUpPage;
	ActivateAccountPage activateAccountPage;

	@BeforeMethod

	public void setUp() throws IOException {
		browserInitializing();
		getUrl();
		mainPage = new MainPage(driver);
		signUpPage = mainPage.clickSignUp();
		activateAccountPage = signUpPage.registration(prop.getProperty("email"), prop.getProperty("password"));

	}

	@Test(enabled=false) 
	public void verifyPageTitle() {
		String title = activateAccountPage.getPageTitle();
		Assert.assertEquals(title, "Activate your account");
	}

	@Test(enabled=false)
	public void verifyUsersEmail() {
		boolean b = activateAccountPage.verifyUserEmail(prop.getProperty("email"));
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
