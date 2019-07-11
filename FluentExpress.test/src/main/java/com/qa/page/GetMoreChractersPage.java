package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;
import com.qa.util.Util;

public class GetMoreChractersPage extends Base {
	Util util;
	

	@FindBy(xpath = "//button[text()='Get for $4.99']")
	WebElement Get5$Button;

	@FindBy(xpath = "//button[@class='f4 db center w5 mb2 input-reset bg-blue hover-bg-dark-blue bg-animate white ph4 b pointer bn lh-copy outline-0 br2 js-stripe-btn']")
	WebElement CardButton;

	@FindBy(xpath = "//input[@placeholder='Card number']")
	WebElement CardNumberTextField;
	
	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	WebElement CardExperationDateTextField;
	
	@FindBy(xpath = "//input[@placeholder='CVC']")
	WebElement CardCodeTextField;
	
	@FindBy(className = "Section-button")
	WebElement PayButton;
	
	@FindBy(xpath = "//b[contains(text(),'characters')]")
	WebElement numberOfCharacters;
	
	@FindBy(linkText = "Check new text")
	WebElement CheckNewTextButton;
	
	
	public GetMoreChractersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
public void clickGet4_99$(){
	Get5$Button.click();
}
public void clickCard(){
	CardButton.click();
}
public UsersHomePage clickCheckNewTextButton(){
	CheckNewTextButton.click();
	return new UsersHomePage(driver);
}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public UsersHomePage paymentViaCard() {
		Get5$Button.click();
		CardButton.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']")));
		CardNumberTextField.sendKeys("4242424242424242");
		CardExperationDateTextField.sendKeys("1020");
		CardCodeTextField.sendKeys("123");
		PayButton.click();
		driver.switchTo().defaultContent();
		numberOfCharacters.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", CheckNewTextButton);
		
		return new UsersHomePage(driver);
	}
}
	

	
