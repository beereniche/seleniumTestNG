package com.beereniche.automation.base;

import com.beereniche.automation.pages.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;

public class SeleniumBaseTest {

    protected static WebDriver driver;
    protected static BasePage basePage;
    private static final String URL = "https://github.myshopify.com";

    @BeforeClass(alwaysRun = true)
    public static void launchBrowser() {
        System.out.println("Open Chrome Browser");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
        Utils.waitForPageToLoad(driver);
        basePage = new BasePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public static void closeBrowser() {
        System.out.println("Closing ChromeDriver");
        driver.close();
        driver.quit();
    }

}
