package pages.homepage;

import org.openqa.selenium.WebDriver;
import pages.components.NavBar;
import utils.WaitHelper;

public class HomePage {

    private WebDriver driver;
    private WaitHelper wait;
    private NavBar nav;

    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitHelper(driver,15);
        this.nav=new NavBar(driver);

    }

    public NavBar navBar(){
        return nav;
    }

}
