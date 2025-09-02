package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class LoginPage {

    private final WebDriver driver;
    private final ElementActions elActions;
    //fields
    private final By LOGIN_EMAIL=By.cssSelector("[data-qa='login-email']");
    private final By LOGIN_PASSWORD=By.cssSelector("[data-qa='login-password']");
    private final By LOGIN_BUTTON=By.cssSelector("[data-qa='login-button']");
    private final By ERROR_MSG=By.cssSelector("form p");
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.elActions=new ElementActions(this.driver);
    }

    public LoginPage waitUrlNavigated(){
        elActions.waitUrlContains("/login");
        return this;
    }
    public void fillLogin(String name,String email){
        elActions.type(LOGIN_EMAIL,name);
        elActions.type(LOGIN_PASSWORD,email);
    }
    public void loginClick(){
        elActions.click(LOGIN_BUTTON);
    }

    public boolean errorContains(String partialText) {
        return elActions.waitTextPresent(ERROR_MSG, partialText);
    }
}
