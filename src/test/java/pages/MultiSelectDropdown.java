package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uistore.MultiSelectHomePageLocator;
import utils.WebDriverHelper;

import java.util.List;

public class MultiSelectDropdown {
    public WebDriver driver;
    public WebDriverHelper helper;
    public MultiSelectDropdown(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
    }
    public void singleSelect(){
    helper.waitForVisible(MultiSelectHomePageLocator.singleSelect);
    helper.selectDropDown(MultiSelectHomePageLocator.singleSelect,"2");
    }
    public void multiSelect(){
        helper.scrollIntoView(MultiSelectHomePageLocator.multiSelect);
        helper.waitForVisible(MultiSelectHomePageLocator.multiSelect);
       // List<WebElement> opt=driver.findElements(MultiSelectHomePageLocator.multiSelect);
       // System.out.println(opt.size());

            helper.selectDropDown(MultiSelectHomePageLocator.multiSelect,"red");
            helper.selectDropDown(MultiSelectHomePageLocator.multiSelect,"blue");
            List<WebElement> list=helper.selectDropDownList(MultiSelectHomePageLocator.multiSelect);
            Allure.step("Selected options:");
            for(WebElement element:list){
                Allure.step(element.getText());
            }


    }


}
