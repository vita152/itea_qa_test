package test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.GoogleSearchPage;

import java.util.List;

/**
 * Created by UI дизайн on 05.08.2017.
 */
public class GoogleSearchTest {
    public WebDriver webDriver;
    GoogleSearchPage googleSearchPage;


    @BeforeClass
    public void beforeClass(){
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.google.com.ua");
        googleSearchPage  = new GoogleSearchPage(webDriver);
    }

    /**
     * Close webDriver
     */
    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void  SearchITEA (){
        String expectedText = "ITEA";

        googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.writeText("Itea");
        int incidentCardsCount = googleSearchPage.getIncidentCardsCount();

        Assert.assertEquals(googleSearchPage.getPageTitle(), "Itea - Поиск в Google", "After search Page Title is wrong");
        Assert.assertEquals(incidentCardsCount, 7, "Result is't 7" );

    }
}
