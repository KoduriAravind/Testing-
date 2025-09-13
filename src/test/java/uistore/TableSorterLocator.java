package uistore;

import org.openqa.selenium.By;

public class TableSorterLocator {
    public static By decline=By.xpath("//button[contains(text(),'Decline')]");
    public static By termsconditions=By.xpath("//a[text()='Terms & Conditions']");
    public static String rows ="//*[@id='overview']/div[1]/table/tbody/tr";
    public static By row =By.xpath("//*[@id='overview']/div[1]/table/tbody/tr");
    public static By privacyPolicy=By.xpath("//a[text()='Privacy Policy']");
    public static By disclaimer=By.xpath("//div[@class='w-1/6 border-r border-gray-200 p-40']//a[text()='Disclaimer']");
    public static By termsofuse=By.xpath("//div[@class='w-1/6 border-r border-gray-200 p-40']//a[text()='Terms of Use']");
    public static String header="//*[@id='overview']/div[1]/table/thead/tr/th";

}
