package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Button;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.PageElement;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SearchCriteria;

public class MainPage extends PageBase {

    //endregion

    //region Methods
    public boolean menuButtonIsDisplayed(){
        PageElement menuButton = new Button(SearchCriteria.Xpath, "//a[contains(.,'Menu')]");
        return menuButton.isDisplayed();
    }

    public MainPage clickMenuButton(){                       // ylysov  added this method 28.12.2015
        PageElement menuButton = new Button(SearchCriteria.Xpath, "//a[contains(.,'Menu')]");
        menuButton.click();
        return this;
    }

    public AllFeaturesPage clickAllFeaturesButton() {
        PageElement allFeaturesButton = new Button(SearchCriteria.Xpath, "//a[@feature='allFeatures']");
        allFeaturesButton.click();
        return new AllFeaturesPage();
    }

    public MainPage clickUserButton(){
        PageElement userButton = new Button(SearchCriteria.Xpath,"//a[contains(.,'G3His, DemoUser - Company Fried ')]");
        userButton.jsClick();
        return this;
    }
    public LoginPage clickLogOut(){
        PageElement logOutButton = new Button(SearchCriteria.Xpath,"//a[contains(.,'                   Logout               ')]");
        logOutButton.jsClick();
        return new LoginPage();
    }
    //endregion
}
