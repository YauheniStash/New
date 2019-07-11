package com.qa.page;

import org.openqa.selenium.WebDriver;

import com.qa.base.Base;

public class RequestsQueuePage extends Base {

	public RequestsQueuePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}

}
