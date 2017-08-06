package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.GoogleResultPage;
import page.GoogleSearchPage;

/**
 * Created by UI дизайн on 05.08.2017.
 */
public class GoogleSearchTest {
    public WebDriver webDriver;
    GoogleSearchPage googleSearchPage;
    GoogleResultPage googleResultPage;


    @BeforeClass
    public void beforeClass() {
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.google.com.ua");
        googleSearchPage = new GoogleSearchPage(webDriver);
    }

    /**
     * Close webDriver
     */
    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void SearchITEA() {
        String expectedText = "itea";

        googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.writeText(expectedText);

        googleResultPage = new GoogleResultPage(webDriver);
        int incidentCardsCount = googleResultPage.getIncidentCardsCount();


        Assert.assertTrue(googleResultPage.isPageLoaded(), "SearchResults Page is not loaded");
        Assert.assertEquals(incidentCardsCount, 10, "Result is't 10");
        Assert.assertTrue(googleResultPage.isAllElementsContain(expectedText), "Page 1 has different words than search word \"itea\"");

        googleResultPage.goToPage(2);

        Assert.assertEquals(incidentCardsCount, 10, "Result is't 10");
        Assert.assertTrue(googleResultPage.isAllElementsContain(expectedText), "Page 2 has different words than search word \"itea\"");

    }
}
