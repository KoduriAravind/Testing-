package uistore;

import org.openqa.selenium.By;

public class HomePageLocator {
    public static By searchbar = By.xpath("//input[@id='search_bar']");
    public static By noThanks = By.xpath("//button[@id='wzrk-cancel']");
    public static By whereToDeliver = By.xpath("//span[text()='Where to deliver?']");
    public static By clickcountry = By.xpath("//div[text()='India']");
    public static By searchcountry = By.xpath("//input[@id='searchCountry']");
    public static By spain = By.xpath("//span[text()='Spain']");//2
    public static By delivercity = By.xpath("//input[@placeholder='Enter Delivery City']");
    public static By continueshopping = By.xpath("//div[text()='Continue Shopping']");//4
    public static By downloadcatalogueBy = By.xpath("//button[text()='Download Catalogue']");
    public static String divtext = "//div[text()='REPLACEME']";
    public static By pincodeinput = By.xpath("//input[@id='pincode-location-input']");
    public static By cityList = By.xpath("//ul[@id='location-list-dropdown']");
    public static By sameday = By.xpath("//div[text()='Same Day']");
    public static By closeLocation = By.xpath("//img[@src='/icons/close-circle.svg']");
    public static String clickquick = "//div[@class='w-[calc(19.5%-8px)] xll:w-[calc(19.7%-8px)]']//div[@aria-label='30-60 mins']";
}
