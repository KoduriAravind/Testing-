package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebDriverHelper extends Base{
    public WebDriver driver;
    public WebDriverHelper(WebDriver driver){
        this.driver=driver;
    }
    public void clickOnElement(By locator){
        driver.findElement(locator).click();
    }
    public void sendOnElement(By locator,String value){
        driver.findElement(locator).sendKeys(value);
    }
    public void enterAction(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    public void hoverOnElement(By locator){
        WebElement element=driver.findElement(locator);
        Actions actions=new Actions(driver);
        actions.scrollToElement(element);
    }
    public void waitForVisible(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForClickable(By locator){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void fluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)

                .withTimeout(Duration.ofSeconds(30))

                .pollingEvery(Duration.ofSeconds(5))

                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public By replaceStringToXpath(String loc, String replaceValue) {
        String updatedLoc = loc.replace("REPLACEME", replaceValue);
        return By.xpath(updatedLoc);
    }
    public void verifyTextContains(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertEquals(actualText,expectedText);
    }


}
