package manage;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriverManage {

    static WebDriver driver;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver setUpChromedriver() {

        capabilities.setPlatform(Platform.ANY); // Platform secimi yaptik
        capabilities.setBrowserName("chrome"); // Browser name secimi yaptik
        capabilities.setVersion("152.0.7977.83"); // Browser version secimi yaptik

        ChromeOptions chromeOptions = new ChromeOptions();
        // Capabilities'i  bir option'in icerisine koymak icin options objesi olusturduk
        chromeOptions.merge(capabilities);

      try {
          driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"),chromeOptions);
      } catch (MalformedURLException e) {
          throw new RuntimeException(e);
      }

        return driver;
    }


    public WebDriver setUpFirefoxDriver(){

        capabilities.setPlatform(Platform.ANY); // Platform secimi yaptik
        capabilities.setBrowserName("firefox"); // Browser name secimi yaptik
        capabilities.setVersion("155.0.1"); // Browser version secimi yaptik

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);


        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"),firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        return driver;
    }


    public WebDriver setUpEdgeDriver(){

        capabilities.setPlatform(Platform.ANY); // Platform secimi yaptik
        capabilities.setBrowserName("edge"); // Browser name secimi yaptik
        //capabilities.setVersion(""); // Browser version secimi yapamadik

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.merge(capabilities);


        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.133:4444"),edgeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        return driver;

    }
}
