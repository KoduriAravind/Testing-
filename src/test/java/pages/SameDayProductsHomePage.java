package pages;

import java.util.List;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import uistore.HomePageLocator;

import uistore.TableSorterLocator;
import utils.WebDriverHelper;


/**
 * Author: K.Aravind
 * Description: This class handles verification and iteration of products available for same-day delivery.
 */
public class SameDayProductsHomePage {
    public WebDriver driver;
    public WebDriverHelper helper;
    JavascriptExecutor javascriptExecutor;


    /**
     * Constructor to initialize WebDriver, ExtentTest, and helper classes.
     */
    public SameDayProductsHomePage(WebDriver driver) {
        this.driver = driver;

        helper = new WebDriverHelper(driver);
    }

    /**
     * Method name: verfySameDayProducts
     * Author name: K.Aravind
     * Short description: Verifies the presence of the same-day delivery section and its header text.
     * Return type: void
     * Parameter list: None
     */
    public void verfySameDayProducts() {
            helper.clickOnElement(HomePageLocator.noThanks);
            helper.hoverOnElement(TableSorterLocator.termsconditions);
            helper.switchToWindow(TableSorterLocator.termsconditions);
        Allure.step("clicked on termsAndConditions");
        helper.waitForVisible(TableSorterLocator.privacyPolicy);
        helper.switchToWindow(TableSorterLocator.privacyPolicy);
        Allure.step("clicked on the privacypolicy");
        helper.waitForVisible(TableSorterLocator.disclaimer);
        helper.switchToWindow(TableSorterLocator.disclaimer);
        Allure.step("clicked on the disclaimer");
        helper.waitForVisible(TableSorterLocator.termsofuse);
        helper.switchToWindow(TableSorterLocator.termsofuse);
        Allure.step("clicked on the TermsOfUse");
    }


    /**
     * Method name: iteration
     * Author name: K.Aravind
     * Short description: Iterates through quick delivery products and verifies a specific product page.
     * Return type: void
     * Parameter list: None
     */
    public void iteration() {

            List<WebElement> elements = helper.getElementsByXpath(HomePageLocator.clickquick);
            for (WebElement element : elements) {
                if (element.getText().contains("30-60")) {
                    helper.switchWindow(element);
                }
            }

    }

}
