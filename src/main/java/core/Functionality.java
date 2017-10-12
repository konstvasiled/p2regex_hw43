package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.htmlunit.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

class Functionality {
    WebDriver driver;
    void proceedSafari(String url) {
        Logger.getLogger("").setLevel(Level.OFF);
        if (!System.getProperty("os.name").toUpperCase().contains("MAC")) throw new IllegalArgumentException("Safari available on MAC only.");
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url); }
    void proceedFirefox(String url) {
        String driverPath;
        Logger.getLogger("").setLevel(Level.OFF);
        if (System.getProperty("os.name").toUpperCase().contains("MAC")) driverPath = "./resources/webdriver/mac/geckodriver.sh";
        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "resources/webdriver/pc/geckodriver.exe";
        else throw new IllegalArgumentException("Unknown OS");
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
    void proceedChrome(String url) {
        String driverPath;
        Logger.getLogger("").setLevel(Level.OFF);
        if (System.getProperty("os.name").toUpperCase().contains("MAC")) driverPath = "./resources/webdriver/mac/chromedriver";
        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "./resources/webdriver/pc/chromedriver.exe";
        else throw new IllegalArgumentException("Unknown OS");
        System.setProperty("webdriver.chrome.driver", driverPath);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions setoption = new ChromeOptions();
        setoption.addArguments("disable-infobars");
        setoption.addArguments("--disable-notifications");
        setoption.addArguments("--disable-annotations");
        if (System.getProperty("os.name").toUpperCase().contains("MAC")) setoption.addArguments("--start-fullscreen");
        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) setoption.addArguments("--start-maximized");
        else throw new IllegalArgumentException("Unknown OS");
        driver = new ChromeDriver(setoption);
        driver.get(url);
    }
    void proceedHtmlUnit(String url) {
        Logger.getLogger("").setLevel(Level.OFF);
        driver = new HtmlUnitDriver();
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
    void open(String browser, String url) {
        switch (browser.toUpperCase()) {
            case "CHROME": proceedChrome(url); break;
            case "SAFARI": proceedSafari(url); break;
            case "FIREFOX": proceedFirefox(url); break;
            case "HTMLUNIT": proceedHtmlUnit(url); break;
            default: throw new IllegalArgumentException("Unknows Browser");
        }
    }
    void quit() { driver.quit(); }
    String gatherText(By by) {
        String data = driver.findElement(by).getText();
        return data;
    }
    void senddata(By by, double calculateddata) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(String.valueOf(calculateddata));
    }
    void click(By by) { driver.findElement(by).click(); }
    String returnUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }
}
