package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.Base;
import com.qa.page.GetMoreChractersPage;
import com.qa.page.MainPage;
import com.qa.page.SignInPage;
import com.qa.page.TextPage;
import com.qa.page.UsersHomePage;
import com.qa.page.YourTextsPage;

public class UsersHomePageTest extends Base {
	SoftAssert softAssert;
	MainPage mainPage;
	SignInPage signInPage;
	UsersHomePage usersHomePage;
	GetMoreChractersPage getMoreChractersPage;
	YourTextsPage yourTextsPage;
	TextPage textPage;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInitializing();
		getUrl();
		mainPage = new MainPage(driver);
		signInPage = mainPage.clickSignIn();
		usersHomePage = signInPage.login(prop.getProperty("email"), prop.getProperty("password"));
		softAssert = new SoftAssert();
		textPage = new TextPage(driver);
	}

	@Test
	public void verifyGetMoreCharactersLink() {
		getMoreChractersPage = usersHomePage.clickLink();
		Assert.assertEquals(getMoreChractersPage.getTitle(), prop.getProperty("getMoreCharactersPageTitle"));
	}

	@Test
	public void verifySubmitText() throws InterruptedException {
		textPage = usersHomePage.submitText("hello everyone");
		String text1 = textPage.getTextSubmittedTime();
		yourTextsPage = textPage.clickMyTextsButton();
		String text2 = yourTextsPage.getTextConfirmationTime();
		softAssert.assertEquals(text1, text2);
		softAssert.assertAll();
	}

	@Test
	public void verifyNumberOfCharEntered() {
		// 1. Enter 2 characters
		usersHomePage.getEnterText("ttttt");
		// 2. get number of entered characters and compare with "2 characters"
		Assert.assertEquals(usersHomePage.getNumberOfCharactersEntered(), "5 characters");

	}

	@Test
	public void verifyNumberOfCharLeft() throws InterruptedException {
		// 1. Enter 10 characters
		usersHomePage.getEnterText("aaaaaaaaaa");
		// 2. Click submit button;
		usersHomePage.clickSubmitButton();
		// 3. Compare
		String number = textPage.GetNumberOfLeftChar();
		Assert.assertEquals(number, "24348 characters");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}