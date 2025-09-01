package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import uistore.HomePageLocator;
import utils.WebDriverHelper;

public class DeliveryHomePage {
    public WebDriver driver;
    public WebDriverHelper helper;
    public DeliveryHomePage(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
    }

    public void clickOnWhereToDeliver(){
        helper.waitForVisible(HomePageLocator.whereToDeliver);
        helper.clickOnElement(HomePageLocator.noThanks);
        Allure.step("clicked on Nothanks");
        helper.clickOnElement(HomePageLocator.whereToDeliver);
        Allure.step("clicked on whereToDeliver");
        helper.clickOnElement(HomePageLocator.clickcountry);
        helper.sendOnElement(HomePageLocator.searchcountry, "Spain");
        helper.clickOnElement(HomePageLocator.spain);
        helper.sendOnElement(HomePageLocator.delivercity, "Madrid");
        helper.enterAction(HomePageLocator.delivercity);
        helper.waitForClickable(HomePageLocator.continueshopping);
        helper.clickOnElement(HomePageLocator.continueshopping);
    }

}
