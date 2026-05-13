package com.ares.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class ParaBankPage extends PageObject {

    @FindBy(id = "loginPanel")
    private WebElementFacade loginContainer;

    public void enterCredentials(String username, String password) {
        // Search inside the container for the specific inputs
        loginContainer.find(By.name("username")).type(username);
        loginContainer.find(By.name("password")).type(password);
    }

    public void clickLogin() {
        // Search inside the container for the button
        loginContainer.find(By.cssSelector("input[value='Log In']")).click();
    }


    public boolean isLoginFailed() {
        return getTitle().equalsIgnoreCase("ParaBank | Error");
    }
}