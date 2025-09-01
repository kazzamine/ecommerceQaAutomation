package tests;

import base.TestBase;
import data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authentication.AccountCreatedPage;
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

    @Epic("Authentication & account")
    @Story("happy test : full sign up step")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sign up : happy")
    @Test
    public void fullSignUpHappyTest(){
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.navBar().goToSignInUp();

        SignUpPage signUp1 = new SignUpPage(driver).waitUrlNavigated();
        signUp1.fillSignUpFirstStep(TestData.DEFAULT_NAME, TestData.uniqueEmail());
        signUp1.signupClick();

        SignUpAccInfo sign2ndStep = new SignUpAccInfo(driver);
        Assert.assertTrue(sign2ndStep.isAt());

        sign2ndStep.fillAllAccountInfo(
                TestData.TITLE,
                TestData.DEFAULT_NAME,
                TestData.DEFAULT_PASSWORD,
                TestData.BIRTH_DAY,
                TestData.BIRTH_MONTH,
                TestData.BIRTH_YEAR,
                TestData.FIRST_NAME,
                TestData.LAST_NAME,
                TestData.COMPANY,
                TestData.ADDRESS,
                TestData.ADDRESS2,
                TestData.COUNTRY,
                TestData.STATE,
                TestData.CITY,
                TestData.ZIP,
                TestData.MOBILE
        );
        sign2ndStep.createAccountClick();
        AccountCreatedPage createdPage = new AccountCreatedPage(driver).waitUrlNavigated();
//        Assert.assertTrue(createdPage.isAt(),"no header was found");

    }
}
