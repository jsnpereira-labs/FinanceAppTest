package com.finance.app.test;


import java.util.Properties;

import org.junit.Test;

import com.finance.app.data.DataProperties;
import com.finance.app.data.DataUtis;
import com.finance.app.data.TestResults;
import com.finance.app.module.BaseFinanceConstants;
import com.finance.app.module.FinanceModule;
import com.finance.app.module.entities.User;
import com.finance.app.selenium.Browser;

import junit.framework.TestCase;

public class TC06_IshouldCreateNewCategory extends TestCase {
	private FinanceModule financeModule;
	private boolean isPass;

	public TC06_IshouldCreateNewCategory() {
		super("TC06 - I should create new category");
	}
	
	@Test
	public void testIshouldCreateNewCategory() {
		System.out.println("=============== Start: " + this.getClass().getName() + "======================");
		financeModule = new FinanceModule();
		Properties data = DataProperties.getProperties(BaseFinanceConstants.DATA_PROPERTIES);

		User user = new User();
		user.setUsername(data.getProperty(User.USERNAME));
		user.setPassword(data.getProperty(User.PASSWORD));
		isPass = financeModule.signInLogin(user, BaseFinanceConstants.BASE_URL, Browser.Chrome);
		assertEquals("User signed in in the login page", true, isPass);
		TestResults.addResult("User signed in in the login page: "+TestResults.check(isPass));
		
		financeModule.wait(100);
		isPass = financeModule.createNewCategory();
		assertEquals("User signed in in the login page", true, isPass);
		TestResults.addResult("User created new category: "+TestResults.check(isPass));
		TestResults.finalResults();
		TestResults.clearResults();
		financeModule.close();
		System.out.println("=============== End: " + this.getClass().getName() + "======================");
	}

}
