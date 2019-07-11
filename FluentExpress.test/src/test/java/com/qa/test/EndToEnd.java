package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.Base;
import com.qa.page.GetMoreChractersPage;
import com.qa.page.MainPage;
import com.qa.page.RequestsQueuePage;
import com.qa.page.SignInPage;
import com.qa.page.TextPage;
import com.qa.page.UsersHomePage;

public class EndToEnd extends Base {
	SignInPage signInPage;
	MainPage mainPage;
	UsersHomePage usersHomePage;
	GetMoreChractersPage getMoreChractersPage;
	TextPage textPage;
	RequestsQueuePage requestsQueuePage;

	@Test
	public void endToEnd() throws IOException, InterruptedException {
    //1. launch browser 
	browserInitializing();
	//2. get main url
	getUrl();
	//3. click loginButton
    mainPage=new MainPage(driver);
	signInPage=mainPage.clickSignIn();
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(signInPage.getTitle(), "Log in to fluent.express");
	//4. enter login
	//5. enter password
	//6. click login
	usersHomePage=signInPage.login(prop.getProperty("email"), prop.getProperty("password"));
	//7. click get more characters
	getMoreChractersPage=usersHomePage.clickLink();
	softAssert.assertEquals(getMoreChractersPage.getTitle(), "Get more characters!");
	usersHomePage= getMoreChractersPage.paymentViaCard();
	//8. click get 4.99$
	//getMoreChractersPage.clickGet4_99$();
	//9. click card
	Thread.sleep(5000);
	//getMoreChractersPage.clickCard();
	//10. click check new text
	//getMoreChractersPage.clickCheckNewTextButton();
	softAssert.assertEquals(usersHomePage.getTitle(),"Submit new text");
	//11. enter text to be edited with notes
	textPage=usersHomePage.submitTextWithNotes(prop.getProperty("text"), prop.getProperty("notes"));
	// 12. verify text is submitted
	softAssert.assertTrue(textPage.submittedConfirmation(),null);
	// 13. get text with time of confirmation
     String confirmationTime=textPage.getTextSubmittedTime();
	System.out.println(confirmationTime);
	//14. Get text to compare it later
	String originalText=textPage.GetSubmittedText();
	//15. log out
	mainPage=textPage.clickLogOut();
	//16. verify main page title
	softAssert.assertEquals(mainPage.getTitle(), prop.getProperty("maiPageTitle")); 
	//16. click log in 
	signInPage=mainPage.clickSignIn();
	//17. enter editors login,	18. enter editors password, 19. click log in
	requestsQueuePage=signInPage.loginAsEditor("casusdr@gmail.com", "Ro7I6kCW6enbwKm1zJUk");
	softAssert.assertEquals(requestsQueuePage.getTitle(), prop.getProperty("queuePage"));
	driver.findElement(By.xpath("//div[@class='gray mb3 f6']//span[text()='"+confirmationTime+"']//div[2]//a[1]")).click();
	softAssert.assertAll();
	
	
	}
}
