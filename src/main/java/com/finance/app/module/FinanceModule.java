package com.finance.app.module;

import java.util.Properties;

import com.finance.app.data.DataProperties;
import com.finance.app.data.DataUtis;
import com.finance.app.module.entities.Expense;
import com.finance.app.module.entities.User;
import com.finance.app.selenium.Browser;
import com.finance.app.selenium.LocatorType;
import com.finance.app.selenium.SeleniumBase;

public class FinanceModule {
	private SeleniumBase driver;
	private boolean isPass;

	public FinanceModule() {
		driver = new SeleniumBase();
	}

	public boolean registerNewUser(User user, String url, Browser browser) {
		driver.browser(browser);
		driver.launchURL(url);

		driver.Click(FinancePageLocators.REGISTER_NEW_USER_XPATH, LocatorType.XPATH);
		driver.Type(user.getUsername(), FinancePageLocators.REGISTER_NEW_USERNAME_XPATH, LocatorType.XPATH);
		driver.Type(user.getPassword(), FinancePageLocators.REGISTER_NEW_PASSWORD_XPATH, LocatorType.XPATH);
		driver.Type(user.getPassword(), FinancePageLocators.REGISTER_REPEAT_PASSWORD_XPATH, LocatorType.XPATH);
		driver.Click(FinancePageLocators.REGISTER_BUTTON_XPATH, LocatorType.XPATH);

		Properties data = new Properties();

		data.setProperty(User.USERNAME, user.getUsername());
		data.setProperty(User.PASSWORD, user.getPassword());

		isPass = driver.containsValue(user.getUsername(), FinancePageLocators.EDIT_ACCOUNT_XPATH, LocatorType.XPATH);

		if (isPass) {
			DataProperties.saveProperties(BaseFinanceConstants.DATA_PROPERTIES, data);
		}
		return isPass;
	}

	public boolean signInLogin(User user, String url, Browser browser) {
		
		if(!driver.isBrowserOpen()) {
			driver.browser(browser);
			driver.launchURL(url);
		}

		driver.Type(user.getUsername(), FinancePageLocators.LOGIN_USERNAME_XPATH, LocatorType.XPATH);
		driver.Type(user.getPassword(), FinancePageLocators.LOGIN_PASSWORD_XPATH, LocatorType.XPATH);
		driver.Click(FinancePageLocators.REGISTER_BUTTON_XPATH, LocatorType.XPATH);

		isPass = driver.containsValue(user.getUsername(), FinancePageLocators.EDIT_ACCOUNT_XPATH, LocatorType.XPATH);

		return isPass;
	}

	public boolean createNewCategory() {
		
		String category = DataUtis.getGenerateString("category-");
		
		driver.Click(FinancePageLocators.MENU_LIST_CATEGORIES_XPATH, LocatorType.XPATH);
		driver.Click(FinancePageLocators.CATEGORIES_ADD_CATEGORY_XPATH, LocatorType.XPATH);
		driver.Type(category, FinancePageLocators.CATEGORIES_NAME_CATEGORY_XPATH, LocatorType.XPATH);
		driver.Click(FinancePageLocators.CATEGORIES_CREATE_CATEGORY_BUTTON_XPATH, LocatorType.XPATH);
		
		isPass = driver.checkRowsOnTable(category, FinancePageLocators.MATCH_COLUMN_XPATH.replace("$VARIABLE$", category), FinancePageLocators.CATEGORIES_TABLE_XPATH, LocatorType.XPATH);
		
		if (isPass) {
			Properties props = new Properties();
			props.setProperty("category", category);
			DataProperties.saveProperties(BaseFinanceConstants.DATA_PROPERTIES, props);
		}
		
		return true;
	}
	
	public boolean createNewExpense(Expense expense) {
		
		driver.Click(FinancePageLocators.EXPENSES_ADD_EXPNESE_XPATH, LocatorType.XPATH);
		driver.Type(String.valueOf(expense.getDate().atStartOfDay().getDayOfMonth()), FinancePageLocators.EXPENSES_DATE_DAY_XPATH, LocatorType.XPATH);
		driver.ArrowUpField(expense.getDate().atStartOfDay().getMonthValue(), FinancePageLocators.EXPENSES_DATE_MONTH_XPATH, LocatorType.XPATH);
		driver.Type(String.valueOf(expense.getDate().atStartOfDay().getYear()), FinancePageLocators.EXPENSES_DATE_YEAR_XPATH, LocatorType.XPATH);
		driver.selectValueDropDown(expense.getCategory(), FinancePageLocators.EXPENSES_CATEGORIES_XPATH, LocatorType.XPATH);
		driver.Type(expense.getAmount(), FinancePageLocators.EXPENSES_AMOUNT_XPATH, LocatorType.XPATH);
		driver.Type(expense.getReason(), FinancePageLocators.EXPENSES_REASON_XPATH, LocatorType.XPATH);
		driver.Click(FinancePageLocators.EXPENSES_CREATE_EXPENSE_BUTTON_XPATH, LocatorType.XPATH);
		
		isPass = driver.checkRowsOnTable(expense.getReason(), FinancePageLocators.MATCH_COLUMN_XPATH.replace("$VARIABLE$", expense.getReason()), FinancePageLocators.CATEGORIES_TABLE_XPATH, LocatorType.XPATH);
		
		return isPass;
	}
	
	public boolean updatePasswordAccount(User user) {
		driver.Click(FinancePageLocators.EDIT_ACCOUNT_XPATH, LocatorType.XPATH);
		driver.Type(user.getPassword(), FinancePageLocators.ACCOUNT_OLD_PASSWORD_XPATH, LocatorType.XPATH);
		
		String newPassword = DataUtis.generatePassword();
		
		driver.Type(newPassword, FinancePageLocators.ACCOUNT_NEW_PASSWORD_XPATH, LocatorType.XPATH);
		driver.Type(newPassword, FinancePageLocators.ACCOUNT_REPEAT_PASSWORD_XPATH	, LocatorType.XPATH);
		driver.Click(FinancePageLocators.ACCOUNT_CREATE_PASSWORD_BUTTON_XPATH, LocatorType.XPATH);
		isPass = driver.containsValue(user.getUsername(), FinancePageLocators.EDIT_ACCOUNT_XPATH, LocatorType.XPATH);
		
		Properties data = new Properties();
		data.setProperty(User.PASSWORD, newPassword);
		DataProperties.saveProperties(BaseFinanceConstants.DATA_PROPERTIES, data);
		
		driver.Click(FinancePageLocators.LOGOUT_ACCOUNT_XPATH, LocatorType.XPATH);
		return isPass;
	}
	
	public void wait(int sleep) {
		driver.wait(sleep);
	}

	public void close() {
		driver.close();
	}
}
