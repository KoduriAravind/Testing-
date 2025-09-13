package pages;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.WebDriver;
import uistore.FileUploadHomePageLocator;
import utils.WebDriverHelper;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploads {
    public WebDriver driver;
    public WebDriverHelper helper;
    public FileUploads(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
    }
    public void uploadFIle() throws RuntimeException, AWTException {
        helper.waitForVisible(FileUploadHomePageLocator.selectPdf);
        helper.clickOnElement(FileUploadHomePageLocator.selectPdf);

            Robot robot=new Robot();
            robot.delay(2000);
            StringSelection filepath=new StringSelection("\"C:\\Users\\10835592\\Downloads\\Initial Relocation policy - Trainees - campus hires 01042023.pdf\"");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            System.out.println("uploaded");
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);


    }
    public void clickDownload(){
        helper.fluentWait(FileUploadHomePageLocator.verifyFile);
        helper.verifyTextContains(FileUploadHomePageLocator.verifyFile,"Your file is ready");
    }



}
