package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.MainPage;
import com.qa.page.SignInPage;
import com.qa.page.UsersHomePage;

public class SignInPageTest extends Base {
	MainPage mainPage;
	SignInPage signInPage;
	UsersHomePage usersHomePage;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInitializing();
		getUrl();
		mainPage = new MainPage(driver);
		signInPage=mainPage.clickSignIn();
		 
	}

	@Test
	public void verifyTitle() {
		String title = signInPage.getTitle();
		Assert.assertEquals(title, "Log in to fluent.express");
	}

	@Test
	public void login() {
		usersHomePage=signInPage.login(prop.getProperty("email"), prop.getProperty("password"));
		String title=usersHomePage.getTitle();
		Assert.assertEquals(title, prop.getProperty("usersHomePageTitle"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}}
