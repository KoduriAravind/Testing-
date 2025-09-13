package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import uistore.IframeLocator;
import utils.WebDriverHelper;

public class IframesHomePage {
    public WebDriver driver;
    public WebDriverHelper helper;
    Actions actions;
    public IframesHomePage(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
        actions=new Actions(driver);

    }
   public void iframeOperations(){
        helper.switchFrame(IframeLocator.iframe);
        actions.moveToElement(helper.getWebElement(IframeLocator.textbox)).click().sendKeys("Iframe text box").build().perform();
        helper.swithOutFrame();
   }


}
