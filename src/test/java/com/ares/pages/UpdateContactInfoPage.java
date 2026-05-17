package com.ares.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class UpdateContactInfoPage extends PageObject {

    public void updateInfo() {

        find(By.id("customer.firstName")).type("UpdateFirstName");
        find(By.id("customer.lastName")).type("UpdateLastName");
        find(By.id("customer.address.street")).type("UpdateSddressStreet");
        find(By.id("customer.address.city")).type("UpdateCity");
        find(By.id("customer.address.state")).type("UpdateState");
        find(By.id("customer.address.zipCode")).type("2769");
        find(By.id("customer.phoneNumber")).type("310-447-4121");

        find(By.cssSelector("input[value='Update Profile']")).click();
    }
}
