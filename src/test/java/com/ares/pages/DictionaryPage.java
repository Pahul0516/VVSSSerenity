package com.ares.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://en.wiktionary.org/wiki/Wiktionary")
public class DictionaryPage extends PageObject {

    // Use the ID from your HTML, but ensure it's the one in the header
    @FindBy(id="searchInput")
    private WebElementFacade searchTerms;

    public void enter_keywords(String keyword) {
        // Wait up to 10 seconds for the element to be visible and enabled
        searchTerms.waitUntilEnabled().waitUntilVisible();
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        // Instead of clicking the button (which might be hidden),
        // we can just press Enter on the search field
        searchTerms.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public List<String> getDefinitions() {
        // Give the page 5 seconds to load the result list
        waitForCondition().until(
                driver -> driver.findElements(By.cssSelector("ol li")).size() > 0
        );

        return findAll(By.cssSelector("ol li")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}