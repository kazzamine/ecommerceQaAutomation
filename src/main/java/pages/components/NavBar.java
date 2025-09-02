package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.products.ProductsPage;
import utils.WaitHelper;

public class NavBar {

    private final WebDriver driver;
    private final WaitHelper wait;

    public NavBar(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitHelper(driver,15);
    }

    public void goToSignInUp(){
        wait.waitForVisibility(By.cssSelector("a[href='/login']")).click();
    }
    public ProductsPage goToProducts(){
        wait.waitForVisibility(By.cssSelector("a[href='/products']")).click();
        return new ProductsPage(driver);
    }
}
