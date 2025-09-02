package tests;

import base.TestBase;
import data.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authentication.LoginPage;
import pages.homepage.HomePage;

public class LoginTest extends TestBase {

    @Epic("Authentication & account")
    @Story("happy test : login happy")
    @Feature("Login happy")
    @Test
    public void loginHappyTest(){
        driver.get(baseUrl);
        HomePage homePage=new HomePage(driver);
        homePage.navBar().goToSignInUp();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.fillLogin(TestData.EMAIL,TestData.DEFAULT_PASSWORD);
        loginPage.loginClick();

    }

    @Epic("Authentication & account")
    @Story("negative test : login negative")
    @Feature("Login negative")
    @Test
    public void loginNegativeTest(){
        driver.get(baseUrl);
        HomePage homePage=new HomePage(driver);
        homePage.navBar().goToSignInUp();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.fillLogin(TestData.EMAIL,"wrongpass");
        loginPage.loginClick();
        Assert.assertTrue(loginPage.errorContains("Your email or password is incorrect!"));
    }
}
