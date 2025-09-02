package tests.products;

import base.TestBase;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.products.ProductDetailPage;
import pages.products.ProductsPage;

public class ProductsHomeTest extends TestBase {

    @Epic("Products")
    @Story("positive test : consult product detail")
    @Feature("Consult product detail")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void consultProductDetailTest() {
        driver.get(baseUrl);
        ProductsPage productsPage=new HomePage(driver).navBar().goToProducts().waitUrlNavigated();
        Assert.assertTrue(driver.findElement(By.id("search_product")).isDisplayed(),"product title is not displayed");
        productsPage.consultProductDetail("1");
        Assert.assertTrue(driver.findElement(By.className("product-information")).isDisplayed(),"product title is not displayed");
    }

    @Epic("Products")
    @Story("positive test : add to cart")
    @Feature("Add to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addToCartDifferentQuantitiesTest(){
        driver.get(baseUrl);
        ProductsPage productsPage=new HomePage(driver).navBar().goToProducts().waitUrlNavigated();
        Assert.assertTrue(driver.findElement(By.id("search_product")).isDisplayed(),"product title is not displayed");
        productsPage.consultProductDetail("1");
        ProductDetailPage detailPage=new ProductDetailPage(driver).waitUrlNavigated();
        detailPage.changeQuantity(5);
        detailPage.increaseDecreaseQuantity("up");
        detailPage.increaseDecreaseQuantity("down");
        detailPage.addToCart();
    }

}
