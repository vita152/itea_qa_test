package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by UI дизайн on 05.08.2017.
 */
public class GoogleSearchPage extends BasePage {
    @FindBy(xpath = ".//*[@id='sb_ifc0']")
    private WebElement SearchElement;
    @FindBy(xpath = ".//*[@id='tsf']//*[@class='jsb']//input[@name='btnK']")
    private WebElement SearchButton;


    /**
     * Constructor  GoogleSearchPag have:
     * super(webDriver),
     * init Elements,
     * SearchButton is Displayed.
     *
     * @param webDriver super(webDriver)
     */
    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementDisplaued(SearchButton);
    }

    /**
     * Type text and click button search
     *
     * @param Textelement
     */
    public void writeText(String Textelement) {
        SearchElement.sendKeys(Textelement);
        SearchButton.click();
    }


}
