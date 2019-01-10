package com.beereniche.automation.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static WebDriver driver;
    public static int TIMEOUT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void scrollNeeded(WebElement element) {
        int location_y = element.getLocation().getY() - 300;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, " + location_y + ")");
    }

    public void waitForPageToLoad(WebElement element) {
        try {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };
            WebDriverWait longWait = new WebDriverWait(driver, TIMEOUT);
            longWait.until(pageLoadCondition);
            longWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception exe) {
            System.out.println("Error");
        }
    }

}
