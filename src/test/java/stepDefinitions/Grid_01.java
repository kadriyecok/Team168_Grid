package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_01 {

    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.151:4444"),new ChromeOptions());
        // local driver'i (WebDriver) Remote driver'a (RemoteWebDriver) cevirdik. Bu islemi yaparken
        // RemoteWebDriver'in calisacagi NODE'u belirttik. (URL girerek).
        // Ayrıca NODE icerisinde hangi browser'da test kosulacagini da Options girerek belirledik.

        driver.get("https://www.babayigit.net");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }

    @Test
    void firefoxGriTest() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.151:4444"),new FirefoxOptions());
        // Bu satirda testimizin kosumunun yapilacagi NODE
        // ve NODE icerisinde bulunan browser'i (firefox) sectik.

        driver.get("https://www.babayigit.net");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }


    // Bu test kosumlarimizi hazirladigimiz GRID ortaminda yaptik
    // Ancak capalities gondermeden mevcuttaki options'i  kullanarak basit kosumlar gerceklestirdik


}
