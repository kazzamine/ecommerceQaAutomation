package tests;

import base.TestBase;
import data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authentication.SignUpAccInfo;
import pages.authentication.SignUpPage;
import pages.homepage.HomePage;
import utils.ElementActions;

public class SignUpTest extends TestBase {

    @Epic("Authentication & account")
    @Story("happy test : 1st sign up step")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sign up 1st step")
    @Test
    public void signUpStep1HappyTest(){
        driver.get(baseUrl);
        HomePage homePage=new HomePage(driver);
        homePage.navBar().goToSignInUp();
        SignUpAccInfo sign2ndStep=new SignUpAccInfo(driver);
        SignUpPage signUp1=new SignUpPage(driver).waitUrlNavigated();
        signUp1.fillSignUpFirstStep(TestData.DEFAULT_NAME,TestData.uniqueEmail());
        signUp1.signupClick();
        Assert.assertTrue(sign2ndStep.isAt());
    }

    @Epic("Authentication & account")
    @Story("negative test : 1st sign up step")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sign up 1st step : negative")
    @Test
    public void signUpStep1NegativeTest(){
        driver.get(baseUrl);
        HomePage homePage=new HomePage(driver);
        homePage.navBar().goToSignInUp();
        SignUpPage signUp1=new SignUpPage(driver).waitUrlNavigated();
        signUp1.fillSignUpFirstStep(TestData.DEFAULT_NAME,TestData.uniqueEmail());
        signUp1.signupClick();
        Assert.assertTrue(signUp1.isStillOnStep1());
        Assert.assertTrue(signUp1.errorContains("Email Address already exist!"));
    }
}
