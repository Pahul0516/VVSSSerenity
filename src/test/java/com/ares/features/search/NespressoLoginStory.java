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
public class NespressoLoginStory {

    // These fields are automatically populated by Serenity from the CSV headers
    private String user;
    private String pass;

    @BeforeClass
    public static void setupDriver() {
        File file = new File("drivers/msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void login_to_nespresso_successfully() {
        webdriver.manage().window().maximize();

        anna.is_on_homepage();
        anna.logs_in_with_credentials(user, pass);
        anna.should_be_logged_in();
    }
}