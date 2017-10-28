# FinanceAppTest

This project is developed the tests for Code assignment in company.

Requisites 
I was tested this project and it was working this versions

- java version "1.8.0_144"
- ache Maven 3.3.9 
- Eclipse Java EE IDE for Web Developers version: Oxygen.1a Release (4.7.1a)
- ChromeDriver 2.33
- geckodriver v0.19.0

You need to clone this project for your repository.
```
git clone git@github.com:jsnpereira/FinanceAppTest.git
```
After you cloned your repository and needs to execute for install the plugins, following:

```
mvn clean install
````

# Download the third party´s browser
First, needs to download the chrome and firefox browsers to setting in project, following:

- Chrome: https://sites.google.com/a/chromium.org/chromedriver/downloads
- Firefox: https://github.com/mozilla/geckodriver/releases

The downloads were completed, so extract two zip files and move them to resources/browsers folder inside the project.
 
# How do run the test cases

From test folders (src/test/java) has test case classes, execute one of the test cases and check the results, also, you can execute AllTest.java to execute all test cases.

Move mouse to AllTests.java and click right button, displays drop down and go to runs menu, you can to see the JUnit test menu and click it to start the tests.
