package com.beereniche.automation.base;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.beereniche.automation.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Utils {
    public static WebDriver driver;

    public static void waitForVisibleText(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BasePage.TIMEOUT);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body"), text));
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }

    public static void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

}
