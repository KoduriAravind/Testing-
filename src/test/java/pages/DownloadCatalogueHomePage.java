package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebDriver;
import uistore.DownloadCatalogueHomePageLocator;
import uistore.HomePageLocator;
import utils.WebDriverHelper;

public class DownloadCatalogueHomePage {
    public WebDriver driver;
    public WebDriverHelper helper;
    public DownloadCatalogueHomePage(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
    }
    public void catalogue(){
        helper.waitForVisible(helper.replaceStringToXpath(HomePageLocator.divtext, "Corporate"));
        helper.clickOnElement(HomePageLocator.noThanks);
        helper.clickOnElement(helper.replaceStringToXpath(HomePageLocator.divtext, "Corporate"));
        helper.clickOnElement(HomePageLocator.downloadcatalogueBy);
        helper.waitForVisible(helper.replaceStringToXpath(DownloadCatalogueHomePageLocator.contactform,"Contact Person"));
        helper.sendOnElement(helper.replaceStringToXpath(DownloadCatalogueHomePageLocator.contactform,"Contact Person"),"Rohit");
        helper.sendOnElement(helper.replaceStringToXpath(DownloadCatalogueHomePageLocator.contactform,"Contact Number"),"79939745668");
        helper.sendOnElement(helper.replaceStringToXpath(DownloadCatalogueHomePageLocator.contactform,"Contact Email"),"Koduriaravind@gmail.com");
        helper.sendOnElement(helper.replaceStringToXpath(DownloadCatalogueHomePageLocator.contactform,"Quantity"), "30");
        helper.sendOnElement(helper.replaceStringToXpath(DownloadCatalogueHomePageLocator.contactform, "Company Name"),"LTIMINDTREE");
        helper.clickOnElement(DownloadCatalogueHomePageLocator.downloadnow);
        Allure.step("clicked on the download catalogue");
    }
 public void verifyStatement(){
        try {

        helper.waitForVisible(DownloadCatalogueHomePageLocator.Thanjoyou);
        helper.verifyTextContains(DownloadCatalogueHomePageLocator.Thanjoyou,"Thank you for submitting your corporate query");
            Allure.step("verified catalouge page", Status.PASSED);
        } catch (Exception e) {
            Allure.step("Not verified catalogue page",Status.FAILED);
        }
 }
}
