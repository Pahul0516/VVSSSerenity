package com.ares.steps.serenity;

import com.ares.pages.NespressoPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.junit.Assert.assertTrue;

public class EndUserSteps extends ScenarioSteps {

    NespressoPage nespressoPage;

    @Step
    public void is_on_homepage() {
        nespressoPage.open();
        nespressoPage.acceptCookiesIfPresent();
    }

    @Step
    public void logs_in_with_credentials(String user, String pass) {
        nespressoPage.openLoginDropdown();
        nespressoPage.enterCredentials(user, pass);
        nespressoPage.clickSubmit();
    }

    @Step
    public void should_be_logged_in() {
        assertTrue("Assertion Failed: Logout button not found. User is not logged in.",
                nespressoPage.isUserLoggedIn());
    }
}