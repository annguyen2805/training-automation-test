package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02_DropdownList_Customer {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

    }
    @Test
    public void DropdownList_Customer() {
        String parentElementValue = "withOptGroup";
        String childElementValue = "react-select-2-option-2";
        String parentElementOne = "selectOne";
        String childElementOne = "react-select-3-option-0-5";
        driver.findElement(By.id(parentElementValue)).click();
        driver.findElement(By.id(childElementValue)).click();
        driver.findElement(By.id(parentElementOne)).click();
        driver.findElement(By.id(childElementOne)).click();
    }

}
