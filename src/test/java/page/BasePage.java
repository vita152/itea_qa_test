package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by UI дизайн on 05.08.2017.
 */
public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Waits until element is displayed using specific max timeout.
     *
     * @param element Webelement to wait for
     * @param timeout Max timeout in seconds
     * @return WebElement after expected condition.
     */
    public WebElement waitUntilElementDisplaued(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until element is displayed.
     *
     * @param element Webelement to wait for
     * @return WebElement after expected condition using specific max timeout
     */
    public WebElement waitUntilElementDisplaued(WebElement element) {
        return waitUntilElementDisplaued(element, 10);
    }

    /**
     * Common method to get current Page URL
     *
     * @return String with current Page URL
     */
    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }
    /**
     * Common method to get current Page title
     *
     * @return String with current Page title
     */
    public String getPageTitle() {
        return webDriver.getTitle();
    }

}
