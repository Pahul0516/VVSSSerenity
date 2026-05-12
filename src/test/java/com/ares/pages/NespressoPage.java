package com.ares.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import java.time.Duration;

@DefaultUrl("https://www.nespresso.com/ro/ro/")
public class NespressoPage extends PageObject {

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElementFacade acceptCookiesButton;

    @FindBy(id = "ta-login-dropdown--not-logged")
    private WebElementFacade loginDropdownButton;

    @FindBy(id = "ta-header-username")
    private WebElementFacade usernameInput;

    @FindBy(id = "ta-header-password")
    private WebElementFacade passwordInput;

    @FindBy(id = "LoginDropdown__title")
    private WebElementFacade loginTitle;

    @FindBy(id = "ta-login-form__submit")
    private WebElementFacade loginSubmitButton;

    // Element from image_82f692.png
    @FindBy(id = "ta-logout")
    private WebElementFacade logoutButton;

    public void acceptCookiesIfPresent() {
        if (acceptCookiesButton.isPresent()) {
            acceptCookiesButton.click();
        }
    }

    public void openLoginDropdown() {
        loginDropdownButton.waitUntilClickable().click();
    }

    public void enterCredentials(String user, String pass) {
        usernameInput.type(user);
        System.out.println(user);
        passwordInput.type(pass);
        System.out.println(pass);
        if (loginTitle.isPresent()) {
            loginTitle.click();
        }
    }

    public void clickSubmit() {
        try {
            loginSubmitButton.waitUntilEnabled().click();
        } catch (Exception e) {
            evaluateJavascript("arguments[0].click();", loginSubmitButton);
        }
    }

    public boolean isUserLoggedIn() {
        // We check for the logout button which appears in your screenshot image_82f692.png
        return logoutButton.withTimeoutOf(Duration.ofSeconds(10)).isPresent();
    }
}