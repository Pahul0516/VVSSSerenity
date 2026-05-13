package com.ares.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ParaBankNavigation extends PageObject {

    public void selectMenuOption(String optionText) {
        // Targets the specific link in the sidebar based on the text (e.g., "Log Out")
        find(By.linkText(optionText)).click();
    }
    
    public void logOut() {
        selectMenuOption("Log Out");
    }
}