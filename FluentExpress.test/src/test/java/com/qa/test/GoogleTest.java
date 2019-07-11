package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.ActivateAccountPage;
import com.qa.page.GooglePage;
import com.qa.page.MainPage;
import com.qa.page.SignUpPage;

public class GoogleTest extends Base {
	
	MainPage mainPage;
	SignUpPage signUpPage;
	ActivateAccountPage activateAccountPage;
	GooglePage googlePage;
	@BeforeMethod
	public void setUp() throws IOException {
	browserInitializing();
	getUrl();
	mainPage = new MainPage(driver);
	signUpPage = mainPage.clickSignUp();
	activateAccountPage=signUpPage.registration(prop.getProperty("email2"),prop.getProperty("password2"));
	googlePage=activateAccountPage.clickGoToEmail();
	
	}
	@Test
	public void verifyPageTitle() {
		Assert.assertEquals(googlePage.getTitle(), "Gmail");
		
	}
	@Test
	public void accountActivation() throws InterruptedException {
		googlePage.GmailSignIn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
