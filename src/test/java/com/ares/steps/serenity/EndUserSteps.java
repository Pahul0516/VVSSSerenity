package com.ares.steps.serenity;

import com.ares.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.junit.Assert.assertTrue;

public class EndUserSteps extends ScenarioSteps {

    ParaBankPage loginPage;
    ParaBankNavigation navigation;
    OpenAccountPage openAccountPage;
    TransferFundsPage transferFundsPage;
    UpdateContactInfoPage updateContactInfoPage;

    @Step
    public void openPage(){
        loginPage.open();
    }

    @Step
    public void login(String username, String password) {
        loginPage.enterCredentials(username, password);
        loginPage.clickLogin();
    }

    @Step
    public void openAccount(){
        navigation.selectMenuOption("Open New Account");
        openAccountPage.openAccount();
    }

    public void transferFunds(){
        navigation.selectMenuOption("Transfer Funds");
        transferFundsPage.transferFunds();
    }

    @Step
    public void logOut(){
        navigation.logOut();
    }

    public Boolean loginSucceeded() {
        return !loginPage.isLoginFailed();
    }

    @Step
    public void openUpdateContactInfo() {
        navigation.selectMenuOption("Update Contact Info");
        updateContactInfoPage.updateInfo();
    }
}