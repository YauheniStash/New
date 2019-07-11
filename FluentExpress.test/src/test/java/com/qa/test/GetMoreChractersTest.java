package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.GetMoreChractersPage;
import com.qa.page.MainPage;
import com.qa.page.SignInPage;
import com.qa.page.UsersHomePage;

public class GetMoreChractersTest extends Base {
	
	MainPage mainPage;
	SignInPage signInPage;
	UsersHomePage usersHomePage;
	GetMoreChractersPage getMoreChractersPage;

	@BeforeMethod
	public void setUp() throws IOException {
		
		browserInitializing();
		getUrl();
		mainPage = new MainPage(driver);
		signInPage = mainPage.clickSignIn();
		usersHomePage = signInPage.login(prop.getProperty("email"), prop.getProperty("password"));
		getMoreChractersPage=usersHomePage.clickLink();

}
	@Test
	public void paymentViaCard() {
		usersHomePage=	getMoreChractersPage.paymentViaCard();
		Assert.assertEquals(usersHomePage.getTitle(), prop.getProperty("usersHomePageTitle"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}