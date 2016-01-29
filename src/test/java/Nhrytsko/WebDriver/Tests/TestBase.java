package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        ConfigProvider.setChromeDriverPath();
        ConfigProvider.setIEDriverPath();
    }

//    @AfterSuite
//    public void classTearDown(){
//        PageBase.closeBrowser();
//    }
}