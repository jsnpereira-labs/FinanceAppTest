package com.finance.app.module;

import java.util.Properties;

import com.finance.app.data.DataProperties;

public class TestRun {

	public static void main(String[] args) {
		String ADDRESS = "test.properties";
		// String GOOGLE = "https://www.google.com.br";
		// SeleniumBase sb = new SeleniumBase();
		//
		// sb.browser(Browser.Firefox);
		// sb.launchURL(GOOGLE);
		//
		// sb.Type("Awesome", ".//*[@id='lst-ib']", LocatorType.XPATH);
		//
		// sb.Click(".//input[@name='btnK']", LocatorType.XPATH);

		String username = "John.doe4";
		
		Properties newData = new Properties();
		newData.setProperty("username", username);
		DataProperties.saveProperties(ADDRESS, newData);

	}

}
