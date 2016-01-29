package Nhrytsko.WebDriver.WrappedDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class URLBuilder {

    public static URL getRemoteSeleniumServerUrl(String hubUrl) {
        try {
            return new URL(String.format("http://"+ hubUrl +":4444/wd/hub"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
