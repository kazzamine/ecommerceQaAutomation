package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class ElementActions {

    private final WebDriver driver;
    private final WaitHelper wait;

    public ElementActions(WebDriver driver) {
        this(driver, 15);
    }
    public ElementActions(WebDriver driver, int secondsTimeout) {
        this.driver = driver;
        this.wait   = new WaitHelper(driver, secondsTimeout);
    }

    public WebElement visible(By loc)   { return wait.waitForVisibility(loc); }
    public WebElement clickable(By loc) { return wait.waitForClickable(loc); }

    public void click(By loc) {
        clickable(loc).click();
    }

    public void type(By loc, String text) {
        WebElement el = visible(loc);
        el.clear();
        el.sendKeys(text);
    }

    public void inputNumber(By loc,String direction) {
        WebElement el = visible(loc);
        if(direction.equals("up")) {
            el.sendKeys(Keys.ARROW_UP);
        }else if(direction.equals("down")) {
            el.sendKeys(Keys.ARROW_DOWN);
        }else {
            throw new RuntimeException("Invalid direction: " + direction);
        }
    }

    public void typeStrict(By loc, String text) {
        for (int i = 0; i < 3; i++) {
            WebElement el = visible(loc);
            el.click();
            el.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            el.sendKeys(text);
            if (text.equals(el.getAttribute("value"))) return;
        }
        throw new RuntimeException("Failed to set value for: " + loc);
    }

    public void clear(By loc) {
        visible(loc).clear();
    }

    public String text(By loc) {
        return visible(loc).getText();
    }

    public String value(By loc) {
        return visible(loc).getAttribute("value");
    }

    public void setCheckbox(By loc, boolean shouldBeChecked) {
        WebElement box = clickable(loc);
        if (box.isSelected() != shouldBeChecked) box.click();
    }

    public void selectByText(By selectLoc, String visibleText) {
        new Select(visible(selectLoc)).selectByVisibleText(visibleText);
    }
    public void selectByValue(By selectLoc, String value) {
        new Select(visible(selectLoc)).selectByValue(value);
    }

    public boolean waitUrlContains(String partial) {
        return wait.waitForUrlContains(partial);
    }

    public boolean waitTextPresent(By loc, String partialText) {
        return wait.waitForTextPresent(partialText, loc);
    }

    public void pause(int seconds) {
        WaitHelper.pause(seconds);
    }
    public void scrollToElement(By locator) {
        WebElement element = wait.waitForVisibility(locator);
        new Actions(driver).moveToElement(element).perform();
    }
}
