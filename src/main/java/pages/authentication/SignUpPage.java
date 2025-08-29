package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.NavBar;
import utils.ElementActions;
import utils.WaitHelper;

public class SignUpPage {

    private WebDriver driver;
    private NavBar nav;
    private ElementActions elActions;
    //fields
    private final By signup_name=By.cssSelector("[data-qa='signup-name']");
    private final By signup_email=By.cssSelector("[data-qa='signup-email']");
    private final By signup_button=By.cssSelector("[data-qa='signup-button']");
    private final By ERROR_MSG=By.cssSelector(".signup-form .alert-danger, .signup-form p");
    public SignUpPage(WebDriver driver){
        this.driver=driver;
        this.nav=new NavBar(driver);
        this.elActions=new ElementActions(driver);
    }
    public SignUpPage waitUrlNavigated(){
        elActions.waitUrlContains("/login");
        return this;
    }

    public void fillSignUpFirstStep(String name,String email){
        elActions.type(signup_name,name);
        elActions.type(signup_email,email);
    }
    public void signupClick(){
        elActions.click(signup_button);
    }
    public boolean isStillOnStep1() {
        try {
            elActions.visible(By.cssSelector("[data-qa='signup-name']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean errorContains(String partialText) {
        return elActions.waitTextPresent(ERROR_MSG, partialText);
    }
}
