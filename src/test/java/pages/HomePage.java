package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import uistore.HomePageLocator;
import utils.WebDriverHelper;

import java.io.ByteArrayInputStream;

public class HomePage {
    public WebDriver driver;
    public WebDriverHelper helper;
    public HomePage(WebDriver driver){
    this.driver=driver;
    helper=new WebDriverHelper(driver);
    }
    public void clickSearchBar(){
    helper.waitForVisible(HomePageLocator.noThanks);
    helper.clickOnElement(HomePageLocator.noThanks);
    Allure.step("clicked on NoThanks",Status.PASSED);
    helper.clickOnElement(HomePageLocator.searchbar);

    }
    public void sendDataOnsearchBar(){
        helper.waitForVisible(HomePageLocator.searchbar);
        helper.sendOnElement(HomePageLocator.searchbar,"cakes");


    }


}
