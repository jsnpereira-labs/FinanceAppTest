package com.finance.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.finance.app.data.DataUtis;
import com.finance.app.data.TestResults;
import com.finance.app.module.BaseFinanceConstants;
import com.finance.app.module.FinanceModule;
import com.finance.app.module.entities.User;
import com.finance.app.selenium.Browser;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class TC01_IshouldCreateNewUser extends TestCase {
	private boolean isPass;
	
	public TC01_IshouldCreateNewUser() {
		super("TC01 - I should Create a new user");
	}
	
	@Test
	public void testCreateNewUser() {
		System.out.println("=============== Start: "+this.getClass().getName()+"======================");
		FinanceModule financeModule = new FinanceModule();
		
		String username = DataUtis.getGenerateString("bart");
		
		System.out.println("Username generated: "+username);
		User user = new User();
		user.setUsername(username);
		user.setPassword(BaseFinanceConstants.USER_PASSWORD);
		
		isPass = financeModule.registerNewUser(user, BaseFinanceConstants.BASE_URL, Browser.Chrome);
		
		assertEquals("It was created a new user", true, isPass);
		TestResults.addResult("It was created a new user: "+ TestResults.check(isPass));
		TestResults.finalResults();
		TestResults.clearResults();
		financeModule.close();
		System.out.println("=============== End: "+this.getClass().getName()+"======================");
		
	}

}
