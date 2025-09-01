package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Base {
    public WebDriver driver;
    public void openBrowser(){
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    driver.get("https://www.fnp.com/");


    }
}
