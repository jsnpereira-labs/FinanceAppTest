package com.finance.app.test;

import java.util.Properties;

import org.junit.Test;

import com.finance.app.data.DataProperties;
import com.finance.app.data.TestResults;
import com.finance.app.module.BaseFinanceConstants;
import com.finance.app.module.FinanceModule;
import com.finance.app.module.entities.User;
import com.finance.app.selenium.Browser;

import junit.framework.TestCase;

public class TC02_IshouldSignInLogin extends TestCase {
	private boolean isPass;
	private FinanceModule financeModule;
	
	public TC02_IshouldSignInLogin() {
		super("TC01 - I should Create a new user");
	}

	@Test
	public void testIshouldSignInLogin() {
		System.out.println("=============== Start: " + this.getClass().getName() + "======================");
		financeModule = new FinanceModule();
		Properties data = DataProperties.getProperties(BaseFinanceConstants.DATA_PROPERTIES);

		User user = new User();
		user.setUsername(data.getProperty(User.USERNAME));
		user.setPassword(data.getProperty(User.PASSWORD));

		isPass = financeModule.signInLogin(user, BaseFinanceConstants.BASE_URL, Browser.Chrome);

		assertEquals("User signed in in the login page", true, isPass);
		TestResults.addResult("User signed in in the login page: "+TestResults.check(isPass));
		TestResults.finalResults();
		TestResults.clearResults();
		financeModule.close();
		System.out.println("=============== End: " + this.getClass().getName() + "======================");
	}

}
