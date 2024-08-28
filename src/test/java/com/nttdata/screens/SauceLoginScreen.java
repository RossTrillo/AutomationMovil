package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLoginScreen extends PageObject {

    private By titleElement = By.xpath("//android.widget.ImageView[@content-desc='App logo and name']");
    private By productTextElement = By.className("android.widget.TextView");
    private By increaseQuantityButton = By.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private By cartButton = By.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private By cartValue = By.id("com.saucelabs.mydemoapp.android:id/cartTV");


    public boolean isTitleElementVisible() {
        return $(titleElement).isDisplayed();
    }

    public boolean isProductTextElementVisible() {
        // Verifica si al menos un elemento con la clase android.widget.TextView está visible
        WebElement element = getDriver().findElement(productTextElement);
        return element != null && element.isDisplayed();
    }

    public void selectProductByText(String productName) {
        By productLocator = By.xpath("//android.widget.TextView[@text='" + productName + "']");
        WebElement productElement = getDriver().findElement(productLocator);
        productElement.click();
    }

    public boolean isIncreaseQuantityButtonVisible() {
        WebElement button = getDriver().findElement(increaseQuantityButton);
        return button != null && button.isDisplayed();
    }

    public void clickIncreaseQuantity() {
        WebElement button = getDriver().findElement(increaseQuantityButton);
        if (button != null && button.isDisplayed()) {
            button.click();
        }
    }

    public void clickCartButton() {
        WebElement cart = getDriver().findElement(cartButton);
        if (cart != null && cart.isDisplayed()) {
            cart.click();
        }
    }

    public String getCartValue() {
        WebElement cartValueElement = getDriver().findElement(cartValue);
        return cartValueElement != null ? cartValueElement.getText() : "";
    }

}
