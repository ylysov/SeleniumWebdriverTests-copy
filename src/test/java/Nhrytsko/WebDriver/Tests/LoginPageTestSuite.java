package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTestSuite extends TestBase {

    LoginPage loginPage;
    String browserName;

    @DataProvider(name = "data-provider")
    public Object [] [] data(){
        return new Object[][]{
                {"g2his", "g3his"},
                {"g3his","g2his"}
        };
    }

    @BeforeClass
    @Parameters(value = {"hub", "browserName"})
    public void classSetUp(String hub, String browserName){
        this.loginPage = PageBase.startBrowser(hub,browserName).goToLoginPage();
        this.browserName = browserName;
    }

    @Test (groups = {"group2"}, dataProvider = "data-provider")
    public void userCannotLogInWithInvalidCredentials(String userName, String userPassword) {
        this.loginPage.logInAs(userName, userPassword);

        String warningMessage = this.loginPage.getWarningMessage();

        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Messages are not equal");
        System.out.println("Test is running the thread #"+Thread.currentThread().getId() + " in browser " + this.browserName);
    }
}
