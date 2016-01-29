package Nhrytsko.WebDriver.WrappedDriver;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class ConfigProvider {

    static File configFile;
    static Properties properties;
    static FileInputStream inputStream;

    private static Properties ConfigurationParameters() throws IOException {
        configFile = new File("TestConfiguration.properties");
        properties = new Properties();
        inputStream = new FileInputStream(configFile);
        properties.load(inputStream);

        return properties;
    }

    public static String getValidUserName() {
        try {
            return ConfigurationParameters().getProperty("userName");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getValidUserPassword() {
        try {
            return ConfigurationParameters().getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static long getPageLoadTimeout(){
        try{
            long pageLoadTimeout = Long.parseLong(ConfigurationParameters().getProperty("pageLoadTimeout"));
            return pageLoadTimeout;
    }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getThreadSleepTimeout(){
        try{
            long pageLoadTimeout = Long.parseLong(ConfigurationParameters().getProperty("threadSleepTimeout"));
            return pageLoadTimeout;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static URL getBaseURL() {
        try {
            URL url = new URL (ConfigurationParameters().getProperty("130_VirtualMachineURL"));
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPingUrl() {
        try {
            return ConfigurationParameters().getProperty("pingUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPageUrl() {
        try {
            return ConfigurationParameters().getProperty("39_VirtualMachineURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPatientData() {
        try {
            return ConfigurationParameters().getProperty("patient");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getInvalidUserName(){
        try {
            return ConfigurationParameters().getProperty("wrongName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getInvalidUserPassword() {
        try {
            return ConfigurationParameters().getProperty("wrongPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPatientName() {
        try {
            return ConfigurationParameters().getProperty("patientName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPatientEpisode() {
        try {
            return ConfigurationParameters().getProperty("patientEpisode");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getSolutionFolderPath(){
        String folderPath = System.getProperty("user.dir");
        return folderPath;
    }

    public static String getSeleniumGridPath(){
        String seleniumGridPath = getSolutionFolderPath() + "\\src\\seleniumGridFiles\\";
        return seleniumGridPath;
    }

    public static String getGridBatPath(){
        String gridBatPath = getSeleniumGridPath() + "StartGrid.bat";
        return gridBatPath;
    }

    public static void setChromeDriverPath() {
        String chromeDriverPath = null;
        try {
            chromeDriverPath = getSolutionFolderPath()+
                    ConfigurationParameters().getProperty("chromeDriverPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    public static void setIEDriverPath() {
        String ieDriverPath = null;
        try {
            ieDriverPath = getSolutionFolderPath()+
                    ConfigurationParameters().getProperty("ieDriverPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.ie.driver", ieDriverPath);
    }

    public static String getDefaultHubURL() {
        return System.getProperty("defaultHubURL");
    }
}
