package com.finance.app.test;


import java.util.Properties;

import org.junit.Test;

import com.finance.app.data.DataProperties;
import com.finance.app.data.DataUtis;
import com.finance.app.data.TestResults;
import com.finance.app.module.BaseFinanceConstants;
import com.finance.app.module.FinanceModule;
import com.finance.app.module.entities.Expense;
import com.finance.app.module.entities.User;
import com.finance.app.selenium.Browser;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

import junit.framework.TestCase;

public class TC09_IshouldTrackMyExpense extends TestCase {
	private FinanceModule financeModule;
	private boolean isPass;

	public TC09_IshouldTrackMyExpense() {
		super("TC06 - I should track my expense");
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
		
		Expense expense = new Expense();
		expense.setCategory(data.getProperty("category"));
		expense.setReason(DataUtis.getGenerateString("expense-"));
		expense.setDate(DataUtis.generateDate(30));
		expense.setAmount(String.valueOf(DataUtis.generateMoneyCurrency()));
		
		financeModule.createNewExpense(expense);
		financeModule.close();
		assertEquals("User created the new expense", true, isPass);
		TestResults.addResult("User created the new expense: "+TestResults.check(isPass));
		TestResults.finalResults();
		TestResults.clearResults();
		System.out.println("=============== End: " + this.getClass().getName() + "======================");
	}

}
