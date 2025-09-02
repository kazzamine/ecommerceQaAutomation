package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.NavBar;
import utils.ElementActions;

public class ProductDetailPage {
    private final WebDriver driver;
    private final ElementActions elActions;
    private final NavBar nav;
    private final By ADD_TO_CART_BUTTON=By.cssSelector("button.btn.btn-default.cart");
        private final By QUANTITY_INPUT=By.id("quantity");

    public  ProductDetailPage(WebDriver driver){
        this.driver=driver;
        this.elActions=new ElementActions(this.driver);
        this.nav=new NavBar(driver);
    }

    public NavBar navBar(){
        return nav;
    }

    public ProductDetailPage waitUrlNavigated(){
        elActions.waitUrlContains("/product_details");
        return this;
    }

    public void increaseDecreaseQuantity(String direction)
    {
        elActions.inputNumber(QUANTITY_INPUT,direction);
    }
    public void changeQuantity(int quantity)
    {
        elActions.type(QUANTITY_INPUT,String.valueOf(quantity));
    }
    public void addToCart()
    {
        elActions.click(ADD_TO_CART_BUTTON);
    }
}
