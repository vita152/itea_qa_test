package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage extends BasePage {
    @FindBy(xpath = ".//*[@id='rso']//*[@class='rc']")
    private List<WebElement> SearchResult;
    @FindBy(xpath = "//*[@id='resultStats']")
    private WebElement ResultSearch;

    /**
     * Constructor  GoogleResultPage have:
     * super(webDriver),
     * init Elements,
     * ResultSearch is Displayed.
     *
     * @param webDriver super(webDriver)
     */
    public GoogleResultPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementDisplaued(ResultSearch);
    }

    /**
     * Counts how many SearchResult are on the Page
     *
     * @returnNumber of SearchResult on page
     */
    public int getIncidentCardsCount() {
        return SearchResult.size();
    }

    /**
     * SearchResults Page is Loaded when WebElement ResultSearch is displayed
     *
     * @return ResultSearch is displayed or not (tru or false)
     */
    public boolean isPageLoaded() {
        return ResultSearch.isDisplayed();
    }

    /**
     * Check or found Elements equals to the required value
     *
     * @param requiredValue Search text
     * @return true/false Search text and actual result
     */
    public boolean isAllElementsContain(String requiredValue) {
        for (WebElement ListSearchResult : SearchResult) {
            if (!ListSearchResult.getText().toLowerCase().contains(requiredValue.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Choose Page number
     *
     * @param number number Page
     * @return WebElement  Page number
     */
    public WebElement choicePage(int number) {
        return webDriver.findElement(By.xpath(String.format(".//*[@id='nav']//*[@aria-label='Page %d']", number)));
    }

    /**
     * Click on Page number and wait
     *
     * @param number number Page
     */
    public void goToPage(int number) {
        choicePage(number).click();
        waitUntilElementDisplaued(ResultSearch);
    }
}
