package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uistore.TableSorterLocator;
import utils.ExcelReader;
import utils.WebDriverHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableDataSorter {
    public WebDriver driver;
    public WebDriverHelper helper;
    public TableDataSorter(WebDriver driver){
        this.driver=driver;
        helper=new WebDriverHelper(driver);
    }
    public void tableSorter(){
        helper.clickOnElement(TableSorterLocator.decline);
        helper.waitForVisible(TableSorterLocator.row);
        List<WebElement> header=helper.getElementsByXpath(TableSorterLocator.header);
        List<WebElement> headers=helper.getElementsByXpath(TableSorterLocator.rows);
        List<String> coldata=new ArrayList<>();
        int i=0;
        int j=0;
        for(int rowindex=1;rowindex<=header.size();rowindex++) {
            for (int colindex = 1; colindex <= headers.size(); colindex++) {
                WebElement cell = driver.findElement(By.xpath("//*[@id='overview']/div[1]/table/tbody/tr[" + colindex + "]/td[" + rowindex + "]"));

                coldata.add(cell.getText().trim());
              ExcelReader.writeData("Employee",i,j,cell.getText().trim());

                i++;
            }
            i=0;
            j++;

           // ExcelReader.writeData("Employee",i,j,"Aravind");
            Collections.sort(coldata);

            Allure.step("Sorted Column Data:");
            String result=coldata.toString();

            Allure.step(result);


            coldata.clear();
        }






    }

}
