package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UI дизайн on 05.08.2017.
 */
public class GoogleSearchPage extends BasePage  {
    @FindBy(xpath = ".//*[@id='sb_ifc0']")
    private WebElement SerchElement;
    @FindBy(xpath = ".//*[@id='tsf']/div[2]/div[3]/center/input[1]")
    private WebElement SerchButton;
    @FindBy(xpath =".//*[@id='rso']//*[@class='rc']")
    private List<WebElement> SearchResult;

    public  GoogleSearchPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementDisplaued(SerchButton);
    }

    public void writeText (String Textelement)
    {
        SerchElement.sendKeys(Textelement);
        SerchButton.click();
    }

    public int getIncidentCardsCount() {
       return SearchResult.size();
    }
}
