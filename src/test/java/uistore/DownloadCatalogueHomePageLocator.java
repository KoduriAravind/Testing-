package uistore;

import org.openqa.selenium.By;

public class DownloadCatalogueHomePageLocator {
    public static String contactform ="//form[@wfa_instance_id='1']//input[@placeholder='REPLACEME']";
    public static By downloadnow = By
            .xpath("//input[@class='formsubmit btn btn-success w-100 zcwf_button' and @value='Download Now']");
    public static By Thanjoyou=By.xpath("//h1[text()='Thank you for submitting your corporate query']");



}
