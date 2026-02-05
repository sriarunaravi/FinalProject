**Selenium Automation Final Project – ParaBank**
**Project Overview**
This project automates end-to-end testing of the ParaBank web application using Selenium WebDriver,Java and TestNG.
**The automation flow covers:**
User Registration
User Login
Opening a New Bank Account
Logout
**Technologies Used**
Java
Selenium WebDriver
TestNG
ChromeDriver
Maven / IDE (Eclipse or IntelliJ)

**Application Under Test**

**URL: https://parabank.parasoft.com/parabank/register.htm**

**Prerequisites**
Before running this project, ensure you have the following installed:
Java JDK 8 or above
Google Chrome browser
ChromeDriver (compatible with your Chrome version)
IDE (Eclipse / IntelliJ)
TestNG plugin (if using Eclipse)
**Project Structure**
FinalProjectCode.java
**Test Scenarios**
**Register Test**
Fills out the registration form
Submits user details to create a new account
**Login Test**
Logs in using the registered username and password
Depends on registerTest
**Open Account Test**
Navigates to Open New Account
Selects account type (CHECKING)
Opens a new bank account
Depends on loginTest
**Logout Test**
Logs out from the application
Depends on openAccountTest
The browser is closed automatically after all tests using @AfterClass.
