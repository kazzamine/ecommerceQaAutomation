package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class NavBar {

    private WebDriver driver;
    private WaitHelper wait;

    public NavBar(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitHelper(driver,15);
    }

    public void goToSignInUp(){
        wait.waitForVisibility(By.cssSelector("a[href='/login']")).click();
    }
}
