package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class AccountCreatedPage {

    private final WebDriver driver;
    private final ElementActions elActions;
    //fields
   private final By ACCOUNT_CREATED = By.cssSelector("h2[data-qa='account-created'] b");
    public AccountCreatedPage(WebDriver driver){
        this.driver=driver;
        this.elActions=new ElementActions(this.driver);
    }
    public AccountCreatedPage waitUrlNavigated(){
        elActions.waitUrlContains("/account_created");
        return this;
    }
    public boolean isAt(){
        return elActions.waitTextPresent(ACCOUNT_CREATED, "Account Created!");
    }
}
