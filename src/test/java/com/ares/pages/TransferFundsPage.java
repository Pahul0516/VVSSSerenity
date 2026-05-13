package com.ares.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import java.time.Duration;

public class TransferFundsPage extends PageObject {

    public void transferFunds() {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(driver ->
                        find(By.id("fromAccountId")).getSelectOptions().size() > 0
                );

        find(By.id("amount")).type("10");

        find(By.cssSelector("input[value='Transfer']")).click();
    }
}