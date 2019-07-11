package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class TextPage extends Base {

	@FindBy (xpath="//div[contains(text(),'Submitted on')]")
	WebElement SubmittedConfirmation;
	
	@FindBy (linkText="My texts")
	WebElement MyTextsButton;
	
	@FindBy (xpath="//div[@class='fl w-50-ns w-100 mb4 ph4']/div[1]/span")
	WebElement TextSubmittedTime;
	
	@FindBy (xpath="//b[contains(text(),'characters')]")
	WebElement NumberOfLeftChar;
	
	@FindBy(xpath="//div[@data-test='original-text']")
	WebElement SubmittedText;
	
	@FindBy(linkText="Log out")
	WebElement LogOutButton;
	
	public TextPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public MainPage clickLogOut() {
		LogOutButton.click();
		return new MainPage(driver);
			}
	
	public String GetSubmittedText() {
	String text=SubmittedText.getText();
	return text;
		}
	
	public String GetNumberOfLeftChar() {
	String number=	NumberOfLeftChar.getText();
	return number;
	}
	
	
	public String getTextSubmittedTime() {
		String comfirmation=TextSubmittedTime.getText();
		return comfirmation;
	}
	
	
	public YourTextsPage clickMyTextsButton() {
		MyTextsButton.click();
		return new YourTextsPage(driver);
	}
	
	public boolean submittedConfirmation() {
	boolean b=	SubmittedConfirmation.isDisplayed();
	return b;
	}
	
	
public String getTitle() {
	String title=driver.getTitle();
	return title;
}
}
