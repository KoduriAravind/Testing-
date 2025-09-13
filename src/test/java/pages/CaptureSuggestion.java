package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uistore.SuggestionsLocator;
import utils.WebDriverHelper;

import java.util.List;

public class CaptureSuggestion {
    public WebDriver driver;
    public WebDriverHelper helper;
    public CaptureSuggestion(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
    }
    public void suggestionCapture(){
        helper.waitForClickable(SuggestionsLocator.searchBar);
        //helper.clickOnElement(SuggestionsLocator.searchBar);
        helper.sendOnElement(SuggestionsLocator.searchBar,"cakes");
    }
    public void SuggestionRecord(){
        helper.waitForVisible(SuggestionsLocator.suggestions);
        int i=1;
        List<WebElement> elements=helper.getElementsByXpath(SuggestionsLocator.sugges);
        for(WebElement element:elements){
            String suggestion=element.getText();
            if(suggestion.length()>0) {
                Allure.step("Suggestion" + i++ + " " + suggestion);
            }
        }
    }



}
