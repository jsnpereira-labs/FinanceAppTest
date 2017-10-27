package com.finance.app.selenium;

import org.openqa.selenium.By;

public class Locator {
	
	public static By get(String locator,LocatorType locatorType){
		switch (locatorType) {
		case XPATH:
			return By.xpath(locator);
		case CSS_SELECTOR:
			return By.cssSelector(locator);
		case NAME:
			return By.name(locator);
		case LINK_TEXT:
			return By.linkText(locator);
		case ID:
			return By.id(locator);
		case TAG_NAME:
			return By.tagName(locator);
		default:
			return null;
		}
	}
}
