package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.FrameworkConstants;
import driver.Driver;
import driver.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;
import utils.PropertyUtils;

public class SignupTest extends BaseTest
{
	HomePage homepage;
	LoginPage loginpage;
	SignupPage signuppage;
	
	
	private SignupTest()
	{
		homepage = new HomePage();
		loginpage = new LoginPage();
		signuppage = new SignupPage();
	}
	
	@BeforeMethod(groups= {"SmokeTest"})
	public void clickLoginButton() throws Exception
	{
		DriverManager.getDriver().get(PropertyUtils.get("url"));		
		homepage.clickLoginButton();
		Thread.sleep(2000);	
		loginpage.clickSignupLink();
		Thread.sleep(2000);
	}
	
	@Test(groups= {"SmokeTest"})
	public void signupWithoutDetails()throws Exception
	{
		signuppage.clickSignup();
		Thread.sleep(2000);
		
		Assert.assertTrue(signuppage.isExistsNameError());
		Assert.assertTrue(signuppage.isExistsEmailError());
	}
	
	
}
