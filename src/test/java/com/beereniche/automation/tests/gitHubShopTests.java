package com.beereniche.automation.tests;

import com.beereniche.automation.base.SeleniumBaseTest;
import com.beereniche.automation.pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import com.beereniche.automation.base.Utils;
import org.testng.annotations.Test;
import org.testng.Assert;

/***
 * Author: Berenice Ramos
 * Github: Beereniche
 * Goal: Demo a simple UI Automation using Selenium and TestNG
 * ***/

public class gitHubShopTests extends SeleniumBaseTest {

    MainPage shopPage = PageFactory.initElements(driver, MainPage.class);

    @Test (testName = "Basic Search - GitHub Shop", priority = 1, suiteName = "gitHubShopTest", groups = {"UI", "Selenium"})
    public void searchingProducts() {
        System.out.println("Search Octocat products");
        shopPage.searchProduct("Octocat");
        System.out.println("Verify product name is present");
        Utils.waitForVisibleText("Octocat");
        Assert.assertTrue(shopPage.getSearchPageTitle().contains("Your search for \"Octocat\" revealed the following:"), "Search page title doesn't contains product name");
        System.out.println("Get list of products found");
        Assert.assertNotEquals(shopPage.getListOfProductsFound().size(), 0, "Zero products were found");
        Assert.assertTrue(shopPage.getListOfProductsFound().size() > 0, "Zero products were found");
        Assert.assertEquals(shopPage.getPageTitle(), "Octocat – GitHub", "Page title doesn't contain search reference");
        Assert.assertTrue(shopPage.getCurrentUrl().contains("search?q=Octocat"), "url doesn't contain search word references");
        System.out.println("Open Octocat Stickers");
        shopPage.selectProductByName("Octocat Stickers");
        Assert.assertTrue(shopPage.getPageTitle().contains("Octocat Stickers – GitHub"), "Page title doesn't contain opened product name");
        System.out.println("select specific product");
        System.out.println("Go back to Home Page");
        shopPage.clickGitHubShopLogo();
        System.out.println("Verify home page title");
        Utils.waitForVisibleText("Meet your new sidekick");
        Assert.assertFalse(shopPage.getPageTitle().contains("Octocat – GitHub"), "Page title doesn't contain search reference");
        Assert.assertEquals(shopPage.getPageTitle(), "GitHub Shop | Awesome GitHub T-shirts and other cool swag", "GitHub Shop page title is not correct");
        System.out.println("End");
    }
}
