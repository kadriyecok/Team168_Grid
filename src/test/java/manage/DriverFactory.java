package manage;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.lang.module.Configuration;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {


    static WebDriver driver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();
    static Capabilities options;

    public static WebDriver getDriver(String browser, boolean isRemote) {

        if (isRemote) {
            getRemoteDriver(browser);
        } else {
            getLocalDriver(browser);
        }

        return driver;
    }

    private static WebDriver getLocalDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "src/test/grid/BrowsersDrivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                System.out.println("***** Local Chrome Driver *****");
                break;

            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "src/test/grid/BrowsersDrivers/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("***** Local Firefox Driver *****");
                break;

            default:
                throw new IllegalArgumentException("Browser bulunamadi");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }

    private static WebDriver getRemoteDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities.setPlatform(Platform.MAC);
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("152.0.7977.83");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(capabilities);
                options = chromeOptions;
                System.out.println("***** Grid Chrome Driver *****");
                break;
            case "firefox":
                capabilities.setPlatform(Platform.MAC);
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("155.0.1");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.merge(capabilities);
                options = firefoxOptions;
                System.out.println("***** Grid Firefox Driver *****");
                break;

            default:
                throw new IllegalArgumentException("Browser bulunamadi");
        }

        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("gridUrl")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

}