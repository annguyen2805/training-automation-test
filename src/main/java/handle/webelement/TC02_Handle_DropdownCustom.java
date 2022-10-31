package handle.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TC02_Handle_DropdownCustom {
    WebDriver driver;

    @Test
    public void Test() {
        driver.get("https://demoqa.com/select-menu");
        selectDropdown("//div[@id='withOptGroup']",
                "//div[@id='selectMenuContainer']//div[contains(@id,'react-select-2-option')]","A root option");

        selectDropdown("//div[@id='selectOne']",
                "//div[@id='selectOne']//div[contains(@id,'react-select-3-option')]","Other");
    }

    public void selectDropdown(String parentLocation, String childLocator, String expect){
        driver.findElement(By.xpath(parentLocation)).click();

        List<WebElement> listOptions = driver.findElements(By.xpath(childLocator));
        System.out.println("List options : ");
        for (WebElement item : listOptions){
            System.out.print(item.getText()+"\n");
//            if (item.getText().contains(expect)){
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].scrollIntoView(true);",item);
//                item.click();
//            }
        }
        for (WebElement item : listOptions){
//            System.out.print(item.getText()+"\n");
            if (item.getText().contains(expect)){
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);",item);
                item.click();
                break;
            }
        }
    }


    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void AfterTest(){
//        driver.close();
    }
}
