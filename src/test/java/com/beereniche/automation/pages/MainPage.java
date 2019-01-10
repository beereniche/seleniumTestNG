package com.beereniche.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    private static final String SEARCH_PAGE_TITLE_XPATH = ".//*[contains(@class,'page__title')]";
    private static final String SEARCH_ICON_CLASS_NAME = "nav__search__input";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickGitHubShopLogo() {
        driver.findElement(By.className("site-header__logo")).click();
    }

    public void searchProduct(String productName) {
        driver.findElement(By.className(SEARCH_ICON_CLASS_NAME)).click();
        driver.findElement(By.className(SEARCH_ICON_CLASS_NAME)).sendKeys(productName + Keys.ENTER);
    }

    public String getSearchPageTitle() {
        return driver.findElement(By.xpath(SEARCH_PAGE_TITLE_XPATH)).getText();
    }

    public List<String> getListOfProductsFound() {
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        List<String> productList = new ArrayList<String>();
        for (WebElement product : driver.findElements(By.xpath(".//*[contains(@class,'search__results')]/div")))
            productList.add(product.findElement(By.className("product-thumbnail__title")).getText());
        return productList;
    }

    public boolean selectProductByName(String productName) {
        for (WebElement product : driver.findElements(By.xpath(".//*[contains(@class,'search__results')]/div")))
            if (product.findElement(By.className("product-thumbnail__title")).getText().equals(productName)) {
                scrollNeeded(product);
                product.click();
                waitForPageToLoad(driver.findElement(By.id("MainContent")));
                return true;
            }
        return false;
    }

}
