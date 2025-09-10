package tests;


import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.DriverSetup;
import pages.LoginPage;
import reports.ExtentManager;


public class LoginTest extends DriverSetup{
	ExtentReports extent;
    ExtentTest test;
    
    @DataProvider(name="phoneNumber")
	public Object[][] enterPhoneInput() {
		return new Object[][] {{"81010"},{"8101017099"}};
	}
    
    @BeforeClass
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }
    
	
	
	@Test(priority=1, dataProvider="phoneNumber")
    public void loginWithValidPhoneAndPassword(String phone) throws InterruptedException {
		test = extent.createTest("Automate test: Login with valid phone number and password/OTP and Attempt login with an invalid phone number");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPhoneNumber(phone);
        loginPage.clickLogin();
        if(!loginPage.isLoginErrorDisplayed()) {
        	driver.navigate().back();
        	loginPage.closeLoginPopup();
        }
        
    }
	

    @Test
    public void verifyLoginUIElements() {
    	test = extent.createTest("Verify presence and functionality of Login UI elements");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUiVerification();
    }
    
    @AfterClass
    public void tearDownReport() {
        extent.flush();
    }
}
