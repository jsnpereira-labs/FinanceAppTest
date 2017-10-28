package com.finance.app.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TC01_IshouldCreateNewUser.class, TC02_IshouldSignInLogin.class, TC05_IshouldUpdatePasswordAccount.class,
		TC06_IshouldCreateNewCategory.class, TC09_IshouldTrackMyExpense.class })
public class AllTests {

}
