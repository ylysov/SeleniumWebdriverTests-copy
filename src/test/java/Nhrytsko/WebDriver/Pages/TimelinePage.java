package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TimelinePage  extends PageBase {

    @FindBy(xpath = "//span[contains(.,'Medications')]")
    @CacheLookup
    private WebElement medicationsButton;

    @FindBy(xpath = "//span[@class='ico ico-24pt ico-outline-tb-plus ico-active']")
    @CacheLookup
    private WebElement addNewMedication;

    @FindBy(xpath = "//li[contains(.,'Standard medication')]")
    @CacheLookup
    private WebElement standardMedication;

    @FindBy(xpath = "//li[contains(.,'Injection medication')]")
    @CacheLookup
    private WebElement injectionMedication;

    @FindBy(xpath = "//li[contains(.,'Infusion medication')]")
    @CacheLookup
    private WebElement infusionMedication;

    @FindBy(xpath = "//div[@class='drug-selection-title single-top-padding double-bottom-padding ng-binding']")
    @CacheLookup
    private WebElement drugHeader;

    public TimelinePage clickMedicationsButton(){
        RemoteBrowser.getInstance().waitForElement(this.medicationsButton);
        medicationsButton.click();
        return this;
    }

    public TimelinePage clickAddNewMedication(){
        RemoteBrowser.getInstance().waitForElement(this.addNewMedication);
        addNewMedication.click();
        return this;
    }

    public TimelinePage selectStandardMedication(){
        try {
            RemoteBrowser.getInstance().waitForElement(this.standardMedication);
            standardMedication.click();
            RemoteBrowser.getInstance().waitForElement(this.drugHeader);
        }
        catch (ElementNotFoundException e) {System.out.println("Service not found");}
        return this;
    }

    public TimelinePage selectInjectionMedication(){
        try {
            RemoteBrowser.getInstance().waitForElement(this.injectionMedication);
            injectionMedication.click();
            RemoteBrowser.getInstance().waitForElement(this.drugHeader);
        }
        catch (ElementNotFoundException e) {System.out.println("Service not found");}
        return this;
    }

    public TimelinePage selectInfusionMedication(){
        try {
            RemoteBrowser.getInstance().waitForElement(this.infusionMedication);
            infusionMedication.click();
            RemoteBrowser.getInstance().waitForElement(this.drugHeader);
        }
        catch (ElementNotFoundException e) {System.out.println("Service not found");}
        return this;
    }
}
