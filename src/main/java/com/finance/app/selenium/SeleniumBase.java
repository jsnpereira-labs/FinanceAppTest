package com.finance.app.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {
	private WebDriver driver;
	private WebElement element;
	
	public void browser(Browser browser){
		driver = setUpBrowser(browser);
	}
	
	public void launchURL(String URL){
		driver.get(URL);
	}
	
	public void close(){
		driver.close();
	}
	
	public void Type(String value, String locator, LocatorType locatorType){
		element = driver.findElement(Locator.get(locator, locatorType));
		element.sendKeys(value);
	}
	
	public void enter(String locator, LocatorType locatorType){
		element = driver.findElement(Locator.get(locator, locatorType));
	}
	
	public boolean findText(String value){
		return driver.getPageSource().contains(value);
	}
	
	public void Click(String locator, LocatorType locatorType){
	 WebElement element = driver.findElement(Locator.get(locator, locatorType));
	 element.click();
	}
	
	public WebDriver setUpBrowser(Browser browser){
		switch (browser) {
		case Firefox:
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			return new FirefoxDriver();
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			return new ChromeDriver();	
		default:
			return null;
		}
	}
	

	
}
