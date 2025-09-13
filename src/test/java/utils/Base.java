package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Base {
    public WebDriver driver;
    public static FileInputStream fileInputStream;
    public static Properties properties;





    public void openBrowser(){
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties=new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout"))));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout"))));
    driver.get(properties.getProperty("base_url"));


    }
}
