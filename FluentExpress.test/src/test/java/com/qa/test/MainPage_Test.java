package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.MainPage;

public class MainPage_Test extends Base {
	
	MainPage mainPage;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInitializing();
		getUrl();
		mainPage = new MainPage(driver);
	}

	@Test
	public void verifyPageTitle() {
		String title = mainPage.getTitle();
		Assert.assertEquals(title, "Get your English text checked instantly by a real person");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
