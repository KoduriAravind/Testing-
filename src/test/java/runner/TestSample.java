package runner;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DeliveryHomePage;
import pages.DownloadCatalogueHomePage;
import pages.HomePage;
import utils.Base;

import java.io.ByteArrayInputStream;


public class TestSample extends Base {
    @BeforeMethod
    public void open(){
        openBrowser();
    }
    @Test(enabled = true)
    @Epic("HomePage tests")
    @Feature("Search Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify searchbar functionality")
    @Story("User searches for item")
    @Owner("Aravind")
    public void searchBar(){
        System.out.println("Testng");
        HomePage homePage=new HomePage(driver);
        homePage.clickSearchBar();
        homePage.sendDataOnsearchBar();
    }
    @Test(enabled = true)
    @Severity(SeverityLevel.BLOCKER)
    @Description("verifies deliveryPage")
    @Story("User user deliver service")
    @Owner("Aravind")
    public void Delivery(){
        DeliveryHomePage deliveryHomePage=new DeliveryHomePage(driver);
        deliveryHomePage.clickOnWhereToDeliver();
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("verifies Catalogue page")
    @Story("user uses catalogue page")
    @Owner("Aravind")
    public void downloadCatalogue(){
        DownloadCatalogueHomePage downloadCatalogueHomePage=new DownloadCatalogueHomePage(driver);
        downloadCatalogueHomePage.catalogue();
        downloadCatalogueHomePage.verifyStatement();
    }


    @AfterMethod
    public void close(){

        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));

        driver.quit();
    }


}
