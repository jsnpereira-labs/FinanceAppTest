package com.finance.app.selenium;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBase {
	private static WebDriver driver;
	private WebElement element;
	private static String BROWSER_FOLDER = "/src/main/resources/browsers/";

	public void browser(Browser browser) {
		System.out.println("Browser: " + browser.getBrowserName());
		driver = setUpBrowser(browser);
	}

	public void launchURL(String URL) {
		System.out.println("URL: " + URL);
		driver.get(URL);
	}

	public void close() {
		driver.close();
	}

	public void Type(String value, String locator, LocatorType locatorType) {
		System.out.println("--------------------");
		System.out.println("Type: " + value);
		System.out.println("Locator: " + locator);

		element = driver.findElement(Locator.get(locator, locatorType));
		element.sendKeys(value);
	}

	public void ArrowUpField(int time, String locator, LocatorType locatorType) {
		System.out.println("--------------------");
		System.out.println("ARROW_UP:");
		System.out.println("Times: " + time);
		System.out.println("Locator: " + locator);

		element = driver.findElement(Locator.get(locator, locatorType));

		for (int i = 0; i < time; i++) {
			element.sendKeys(Keys.ARROW_UP);
		}
	}

	public void ArrowDownField(int time, String locator, LocatorType locatorType) {
		System.out.println("--------------------");
		System.out.println("ARROW_UP:");
		System.out.println("Times: " + time);
		System.out.println("Locator: " + locator);

		element = driver.findElement(Locator.get(locator, locatorType));

		for (int i = 0; i < time; i++) {
			element.sendKeys(Keys.ARROW_UP);
		}
	}

	public boolean containsValue(String value, String locator, LocatorType locatorType) {
		System.out.println("--------------------");
		System.out.println("Contains: " + value);
		System.out.println("Locator: " + locator);
		element = driver.findElement(Locator.get(locator, locatorType));

		if (element.getText().equals(value)) {
			return true;
		}
		return false;
	}

	public boolean findText(String value) {
		System.out.println("--------------------");
		System.out.println("Find text value: " + value);
		return driver.getPageSource().contains(value);
	}

	public void clickNumber(int number, String locator, LocatorType locatorType) {
		for (int i = 0; i <= number; i++) {
			Click(locator, locatorType);
		}
	}

	public void Click(String locator, LocatorType locatorType) {
		System.out.println("--------------------");
		System.out.println("Click locator: " + locator);
		WebElement element = driver.findElement(Locator.get(locator, locatorType));
		element.click();
	}

	public boolean checkRowsOnTable(String value, String column, String locator, LocatorType locatorType) {
		System.out.println("--------------------");
		System.out.println("Value: " + value);
		System.out.println("Column: " + column);
		System.out.println("Locator: " + locator);
		List<WebElement> rows = getRowsFromTable(locator, locatorType);

		for (WebElement row : rows) {
			WebElement elemnt = row.findElement(Locator.get(column, LocatorType.XPATH));
			if (elemnt.getText().equals(value)) {
				return true;
			}
		}
		return false;
	}

	public List<WebElement> getRowsFromTable(String locator, LocatorType locatorType) {
		return driver.findElements(Locator.get(locator, locatorType));
	}

	public void wait(int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectValueDropDown(String value, String locator, LocatorType locatorType) {
		Select dropDown = new Select(driver.findElement(Locator.get(locator, locatorType)));
		dropDown.selectByVisibleText(value);
	}
	
	public Boolean isBrowserOpen() {
	    try {
	        driver.getCurrentUrl();//or driver.getTitle();
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}

	public WebDriver setUpBrowser(Browser browser) {
		String address = System.getProperty("user.dir") + BROWSER_FOLDER;
		switch (browser) {
		case Firefox:
			System.setProperty("webdriver.gecko.driver", address + "geckodriver.exe");
			return new FirefoxDriver();
		case Chrome:
			System.setProperty("webdriver.chrome.driver", address + "chromedriver.exe");
			return new ChromeDriver();
		default:
			return null;
		}
	}

}
