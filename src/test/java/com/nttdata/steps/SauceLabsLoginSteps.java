package com.nttdata.steps;

import com.nttdata.screens.SauceLoginScreen;
import net.thucydides.core.annotations.Step;

public class SauceLabsLoginSteps {

    SauceLoginScreen sauceLoginScreen;

    @Step
    public boolean isTitleElementVisible() {
        return sauceLoginScreen.isTitleElementVisible();
    }

    public boolean isProductTextElementVisible() {
        return sauceLoginScreen.isProductTextElementVisible();

    }
    @Step
    public void selectProduct(String productName) {
        sauceLoginScreen.selectProductByText(productName);
    }

    @Step
    public boolean isIncreaseQuantityButtonVisible() {
        return sauceLoginScreen.isIncreaseQuantityButtonVisible();
    }

    @Step
    public void clickIncreaseQuantity() {
        sauceLoginScreen.clickIncreaseQuantity();
    }

    @Step
    public void clickCartButton() {
        sauceLoginScreen.clickCartButton();
    }

    @Step
    public String getCartValue() {
        return sauceLoginScreen.getCartValue();
    }
}
