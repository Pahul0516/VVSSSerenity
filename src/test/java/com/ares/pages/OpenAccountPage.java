package com.ares.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

public class OpenAccountPage extends PageObject {
    public void openAccount(){
        find(By.buttonText("Open New Account")).click();
    }
}
