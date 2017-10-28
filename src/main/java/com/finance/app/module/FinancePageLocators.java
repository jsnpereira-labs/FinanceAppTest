package com.finance.app.module;

public interface FinancePageLocators {
	public static String REGISTER_NEW_USER_XPATH = "//a[@href='register.jsp']";
	public static String REGISTER_NEW_USERNAME_XPATH = "//*[@name='login']";
	public static String REGISTER_NEW_PASSWORD_XPATH = "//*[@name='password1']";
	public static String REGISTER_REPEAT_PASSWORD_XPATH = "//*[@name='password2']";
	public static String REGISTER_BUTTON_XPATH = "//*[@id='submit']";
	public static String EDIT_ACCOUNT_XPATH = "//*[@id='editaccount']";
	public static String LOGIN_USERNAME_XPATH = "//*[@id='login']";
	public static String LOGIN_PASSWORD_XPATH = "//*[@id='password']";
	public static String LOGIN_BUTTON_XPATH = "//input[@id='submit']";  
	public static String MENU_LIST_CATEGORIES_XPATH = "//*[@id='go_list_categories']";
	public static String CATEGORIES_ADD_CATEGORY_XPATH = "//*[@id='go_add_category']";
	public static String CATEGORIES_NAME_CATEGORY_XPATH = "//*[@id='name']";
	public static String CATEGORIES_CREATE_CATEGORY_BUTTON_XPATH = "//*[@id='submit']";
	public static String CATEGORIES_TABLE_XPATH = "//table/tbody/tr";
	public static String EXPENSES_ADD_EXPNESE_XPATH = "//*[@id='go_add_expense']";
	public static String EXPENSES_DATE_DAY_XPATH = "//*[@id='day']";
	public static String EXPENSES_DATE_MONTH_XPATH = "//*[@id='month']";
	public static String EXPENSES_DATE_YEAR_XPATH = "//*[@id='year']";
	public static String EXPENSES_CATEGORIES_XPATH = "//*[@id='category']";
	public static String EXPENSES_AMOUNT_XPATH = "//*[@id='amount']";
	public static String EXPENSES_REASON_XPATH = "//*[@id='reason']";
	public static String EXPENSES_CREATE_EXPENSE_BUTTON_XPATH = "//*[@id='submit']";
	public static String ACCOUNT_OLD_PASSWORD_XPATH = "//*[@id='password']";
	public static String ACCOUNT_NEW_PASSWORD_XPATH = "//*[@id='newpassword1']";
	public static String ACCOUNT_REPEAT_PASSWORD_XPATH = "//*[@id='newpassword2']";
	public static String ACCOUNT_CREATE_PASSWORD_BUTTON_XPATH = "//*[@id='submit']";
	public static String LOGOUT_ACCOUNT_XPATH = "//*[@id='logout']";
	public static String MATCH_COLUMN_XPATH ="//td[contains(text(),'$VARIABLE$')]";
	public static String TR_TABLE_XPATH = "//td[$NUMBER$]";
}
