package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Label;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SearchCriteria;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class LandingPage extends PageBase {

    private WebElement episodeInput = super.driver.findElement(By.xpath("//cgm-search-field[@class='cgm-autocomplete" +
            " cgm-search-field cgm-autocomplete-empty ng-valid']"));

    private WebElement episodeLabel = new Label(SearchCriteria.Xpath, "//h1[contains(.,'Episodes')]");

    private List<WebElement> searchResults = super.driver.findElements(By.xpath("//li[@class='select2-results-dept-0 " +
            "select2-result select2-result-selectable']"));



    int resultsListSize;
    int selectFromList;
    int webElements;

    public LandingPage enterEpisode(String patientName) {
        RemoteBrowser.getInstance().waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(patientName);
       //        DriverFactory.waitForAllElements(searchResults);
        RemoteBrowser.implicitWait(10);
        return this;
    }
    //region Vol Search Patient
    public LandingPage searchPatient() throws IOException {
        RemoteBrowser.getInstance().waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(ConfigProvider.getPatientData());
        RemoteBrowser.getInstance().waitForAllElements(searchResults);
        return this;
    }
    //endregion
    public LandingPage selectTopSearchResult() {
        searchResults.get(0).click();
        return this;
    }
    public LandingPage selectRandomSearchResult(){
        resultsListSize = searchResults.size();
        Random generator = new Random();
        selectFromList = generator.nextInt(resultsListSize);
        this.searchResults.get(selectFromList).click();
        return this;
    }
    public EpisodePage selectExactResult() throws IOException {
        int i = 1 ;
       /* List<WebElement> webElements =driver.findElements(By.xpath("//li[@class='select2-results-dept-0 " +
                "select2-result select2-result-selectable']"));*/
        //webElements = searchResults.size();

        for(WebElement webElementList : searchResults) {
            if (!(i <=searchResults.size())) break;
           WebElement webElement = this.searchResults.get(i);
           //WebElement webElement =webElementList.findElement(By.xpath("//li[@class='select2-results-dept-0 " +
           //         "select2-result select2-result-selectable']["+i+"]"));
           String text = webElement.getText();
            if (text.equalsIgnoreCase(ConfigProvider.getPatientEpisode())) {
                webElement.click();
               }
            else{ break;}

           PageFactory.initElements(this.driver, webElement);

            i++;


        }
        return new EpisodePage();
    }

    public boolean searchInputIsDisplayed(){
        return this.episodeInput.isDisplayed();
    }

    public boolean labelEpisodeIsDisplayed() { return this.episodeLabel.isDisplayed(); }
}
