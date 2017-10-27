package com.finance.app.test;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.finance.app.selenium.Browser;
import com.finance.app.selenium.LocatorType;
import com.finance.app.selenium.SeleniumBase;


public class Google {

	@Test
	public void test() {
		String GOOGLE = "https://www.google.com.br";
		SeleniumBase sb = new SeleniumBase();
		
		sb.browser(Browser.Chrome);
		sb.launchURL(GOOGLE);
		sb.Type("Awesome", ".//*[@id='lst-ib']", LocatorType.XPATH);
		sb.Click(".//input[@name='btnK']", LocatorType.XPATH);
		boolean isFind = sb.findText("Awesome");
		sb.close();
		
		assertTrue("Google was found one word", isFind);
	}

}
