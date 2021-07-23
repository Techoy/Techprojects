package StepDefs;

import Pages.EtsyResultPage;
import Pages.EtsyWebElements;
import Utilities.Configuration;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

public class EtsyStep1 {
    WebDriver driver = Driver.getDriver();
    EtsyWebElements etsyHomePage = new EtsyWebElements();
    EtsyResultPage etsyResultPage=new EtsyResultPage();

    @Given("User is on Etsy homepage")
    public void user_is_on_Etsy_homepage() throws Throwable {
        driver.get(Configuration.getProperty("etsyUrl"));
        Thread.sleep(5000);
    }
    @Then("User verifies homepage title (string)")
    public void user_verifies_homepage_title(String string) {
        String homepageTitle=driver.getTitle();
        Assert.assertEquals(homepageTitle, driver.getTitle());
    }
    @When("User clicks on (string)")
    public void user_clicks_on(String section) {
        if (section.equalsIgnoreCase(etsyHomePage.jewelerySection.getText())) {
            etsyHomePage.jewelerySection.click();
        } else if (section.equalsIgnoreCase(etsyHomePage.clothingSection.getText())) {
            etsyHomePage.clothingSection.click();
        } else if (section.equalsIgnoreCase(etsyHomePage.homeSection.getText())) {
            etsyHomePage.homeSection.click();
        } else if (section.equalsIgnoreCase(etsyHomePage.weddingSection.getText())) {
            etsyHomePage.weddingSection.click();
        } else if (section.equalsIgnoreCase(etsyHomePage.toysSection.getText())) {
            etsyHomePage.toysSection.click();
        }


    }

    @Then("User verifies (string) of title")
    public void user_verifies_of_title(String title) {
        String actualTitle = driver.getTitle();

        Assert.assertEquals(title, driver.getTitle());
    }







    @When("User searches for (string)")
    public void user_searches_for(String item) {
        etsyHomePage.searchBox.sendKeys(item + Keys.ENTER);
    }


    @Then("Verify that (string) is displayed in search message")
    public void verify_that_is_displayed_in_search_message(String item) {
        String actualMessage= etsyResultPage.resultText.getText();
        Assert.assertEquals("Expected "+item+" didn't match with actual"+ actualMessage, item, actualMessage);
    }
    @Then("User selects over (int) price ranges")
    public void user_selects_over_price_ranges(Integer int1) {
        WebDriverWait wait=new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(etsyResultPage.ovver50Button));
        etsyResultPage.ovver50Button.click();
    }


    @Then("User verifies that result prices are over (int)")
    public void user_verifies_that_result_prices_are_over(Integer expectedPrice) {
        for(WebElement price: etsyResultPage.listOfPrices) {
            if (!price.getText().equals("")) {
                Integer actualPrice = Integer.parseInt(price.getText());
                Assert.assertTrue(actualPrice >= expectedPrice);
            }
        }
    }
}
