package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public  void browserInitializing() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\My workspace\\FluentExpress.test\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(file);
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\My programs\\\\Java projects\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\\\My programs\\\\Java projects\\\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void getUrl() {
		driver.get(prop.getProperty("URL"));
	}
}
