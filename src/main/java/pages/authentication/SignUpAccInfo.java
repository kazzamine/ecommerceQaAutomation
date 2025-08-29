package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.NavBar;
import utils.ElementActions;

public class SignUpAccInfo
{
    private WebDriver driver;
    private NavBar nav;
    private ElementActions elActions;
    //fields
    private final By PASSWORD   = By.cssSelector("[data-qa='password']");
    private final By CREATE_BTN = By.cssSelector("[data-qa='create-account']");

    public SignUpAccInfo(WebDriver driver){
        this.driver=driver;
        this.nav=new NavBar(driver);
        this.elActions=new ElementActions(driver);
    }

    public SignUpAccInfo waitUrlNavigated(){
        elActions.waitUrlContains("/signup");
        return this;
    }

    public boolean isAt(){
        try {
            elActions.visible(PASSWORD);
            elActions.visible(CREATE_BTN);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
}
