package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebDriverHelper extends Base{
    public WebDriver driver;
    JavascriptExecutor javascriptExecutor;
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
    public List<WebElement> getElementsByXpath(String value) {
        return driver.findElements(By.xpath(value));
    }
    public String parent = "";
    public void switchWindow(WebElement element) {
        parent = driver.getWindowHandle();
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() > 1);
        Set<String> windows =driver.getWindowHandles();
        for (String window : windows) {
            if (!driver.equals(window)) {
                driver.switchTo().window(window);
            }
        }
    }
    public void switchToWindow(By locator) {
        String originalWindow = driver.getWindowHandle();


        driver.findElement(locator).click();


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));

                break;
            }
        }


        driver.switchTo().window(originalWindow);
    }
    public void scrollToFooter(){
        javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void selectDropDown(By locator, String value) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void selectDropDownVisible(By locator, String value) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(value);

    }
    public List<WebElement> selectDropDownList(By locator) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        List<WebElement> list=select.getAllSelectedOptions();
        return list;
    }
    public void switchFrame(By locator){
        WebElement element=driver.findElement(locator);
        driver.switchTo().frame(element);
    }
    public void swithOutFrame(){
        driver.switchTo().defaultContent();
    }
    public WebElement getWebElement(By locator){
        WebElement element=driver.findElement(locator);
        return element;
    }






}
