package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class UsersHomePage extends Base {
	
	@FindBy(linkText="Get more characters!")
	WebElement GetMoreCharactersLink;
	
	@FindBy(id="text-to-check")
	WebElement EnterTextField;
	
	@FindBy(id="submit-btn")
	WebElement SubmitButton;
	
	@FindBy(xpath="//b[contains(text(),'24472 characters')]")
	WebElement NumberOfCharactersLeft;
	
	@FindBy(xpath="//span[text()='5 characters']")
	WebElement NumberOfCharactersEntered;
	
	@FindBy(name="note")
	WebElement LeaveNotesTextField;
	
	

	public UsersHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	public void clickSubmitButton() {
		SubmitButton.click();
		}
	
	public void getEnterText(String text) {
		EnterTextField.sendKeys(text);
		}
	
	
	public String getNumberOfCharactersLeft() {
	String numberOfCharactersLeft=NumberOfCharactersLeft.getText();
	return numberOfCharactersLeft;
	}
	
	public String getNumberOfCharactersEntered() {
		String numberOfCharactersEntered=NumberOfCharactersEntered.getText();
		return numberOfCharactersEntered;
		}
	
	public TextPage submitTextWithNotes (String text, String notes) {
		EnterTextField.sendKeys(text);
		LeaveNotesTextField.sendKeys(notes);
		SubmitButton.click();
		return new TextPage (driver);
	}
	
	public GetMoreChractersPage clickLink() {
		GetMoreCharactersLink.click();
		return new GetMoreChractersPage(driver);
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
}
