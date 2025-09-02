package pages.products;

import org.openqa.selenium.*;
import pages.components.NavBar;
import utils.ElementActions;

public class ProductsPage {
    private final WebDriver driver;
    private final ElementActions elActions;
    private final NavBar nav;

    public  ProductsPage(WebDriver driver){
        this.driver=driver;
        this.elActions=new ElementActions(this.driver);
        this.nav=new NavBar(driver);
    }

    public NavBar navBar(){
        return nav;
    }

    public ProductsPage waitUrlNavigated(){
        elActions.waitUrlContains("/products");
        return this;
    }

    public void consultProductDetail(String productId)
    {
        closeAdIfPresent();
        By productDetailLocator = By.xpath("//a[contains(@href,'/product_details/"+productId+"')]");
        elActions.scrollToElement(productDetailLocator);
        elActions.click(productDetailLocator);
    }

    public void closeAdIfPresent() {
            WebElement grippyHost = elActions.visible(By.cssSelector("div.grippy-host"));
        elActions.pause(2);
        grippyHost.click();

    }

}
