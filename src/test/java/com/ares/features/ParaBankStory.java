package com.ares.features;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.ares.steps.serenity.EndUserSteps;
import java.io.File;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("data/users.csv")
public class ParaBankStory {

    // These fields are automatically populated by Serenity from the CSV headers
    private String password;
    private String username;

    private String amount;

    @BeforeClass
    public static void setupDriver() {
        File file = new File("drivers/msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        System.setProperty("webdriver.driver", "edge");
        System.setProperty("edge.switches",
                "--headless=new,--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--window-size=1920,1080,--remote-debugging-port=0,--disable-extensions,--no-first-run");
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void loginValid() {
//        webdriver.manage().window().maximize();
        anna.openPage();
        anna.login(username,password);
        assert anna.loginSucceeded();
    }

    @Test
    public void loginInvalid(){
//        webdriver.manage().window().maximize();
        anna.openPage();
        anna.login("invalid","invalid");
        assert !anna.loginSucceeded();
    }

    @Test
    public void fullScenarioTest(){
        // login to app
//        webdriver.manage().window().maximize();
        anna.openPage();
        anna.login(username,password);
        // open account
        anna.openAccount();
        // transfer
        anna.transferFunds();
        // logout
        anna.logOut();
    }

    @Test
    public void updatePProfile(){
//        webdriver.manage().window().maximize();
        anna.openPage();
        anna.login(username, password);

        anna.openUpdateContactInfo();

        anna.logOut();
    }


}