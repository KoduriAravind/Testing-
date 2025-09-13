package runner;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Base;

import java.awt.*;
import java.io.ByteArrayInputStream;


public class TestSample extends Base {
    @BeforeMethod(alwaysRun = true)
    public void open(){
        openBrowser();
    }
//    @Test(enabled = false)
//    @Epic("HomePage tests")
//    @Feature("Search Functionality")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("verify searchbar functionality")
//    @Story("User searches for item")
//    @Owner("Aravind")
//    public void searchBar(){
//        System.out.println("Testng");
//        HomePage homePage=new HomePage(driver);
//        homePage.clickSearchBar();
//        homePage.sendDataOnsearchBar();
//    }
//    @Test(groups = {"smoke"})
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("verifies deliveryPage")
//    @Story("User user deliver service")
//    @Owner("Aravind")
//    public void Delivery(){
//        DeliveryHomePage deliveryHomePage=new DeliveryHomePage(driver);
//        deliveryHomePage.clickOnWhereToDeliver();
//    }
//    @Test(groups = {"smoke"})
//    @Severity(SeverityLevel.NORMAL)
//    @Description("verifies Catalogue page")
//    @Story("user uses catalogue page")
//    @Owner("Aravind")
//    public void downloadCatalogue(){
//        DownloadCatalogueHomePage downloadCatalogueHomePage=new DownloadCatalogueHomePage(driver);
//        downloadCatalogueHomePage.catalogue();
//        downloadCatalogueHomePage.verifyStatement();
//    }
//    @Test
//    @Severity(SeverityLevel.NORMAL)
//    @Description("captures auto suggestions")
//    @Owner("Aravind")
//    public void capturingSuggestions(){
//        CaptureSuggestion captureSuggestion=new CaptureSuggestion(driver);
//        captureSuggestion.suggestionCapture();
//        captureSuggestion.SuggestionRecord();
//    }
//    @Test(groups = {"smoke"})
//    @Severity(SeverityLevel.NORMAL)
//    @Description("verifies the product page")
//    @Owner("Aravind")
//    public void multiplewindowHandling(){
//        SameDayProductsHomePage sameDayProductsHomePage =new SameDayProductsHomePage (driver);
//        sameDayProductsHomePage.verfySameDayProducts();
//    }
//    @Test
//    @Severity(SeverityLevel.NORMAL)
//    @Description("verifies table sorter")
//    @Owner("Aravind")
//    public void tableSorter(){
//        TableDataSorter tableDataSorter=new TableDataSorter(driver);
//        tableDataSorter.tableSorter();
//    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("User uploads the file")
    @Owner("Aravind")
    public void fileUploads(){
        FileUploads fileUploads=new FileUploads(driver);
        try {
            fileUploads.uploadFIle();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        fileUploads.clickDownload();
    }
//    @Test
//    @Severity(SeverityLevel.NORMAL)
//    @Description("user selects from dropdown")
//    @Owner("Aravind")
//    public void dropDownTesting(){
//        MultiSelectDropdown multiSelectDropdown=new MultiSelectDropdown(driver);
//      // multiSelectDropdown.singleSelect();
//        multiSelectDropdown.multiSelect();
//    }
//    @Test
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Handling iframes")
//    @Owner("Aravind")
//    public void handlingIframes(){
//       IframesHomePage iframesHomePage=new IframesHomePage(driver);
//       iframesHomePage.iframeOperations();
//    }



    @AfterMethod(alwaysRun = true)
    public void close(){

        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));

        driver.quit();

    }


}
