package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HandleElement {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
    }

    @Test
    public void selectItemDropdown(String parentXpath, String childXpath, String expectedValueItem) {
        driver.findElement(By.cssSelector(" #app .btn-group")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("#app .btn-group ul li")));
        List<WebElement> allItems = driver.findElements(By.xpath("#app .btn-group ul li"));
        for (WebElement childElement : allItems) {
            if (childElement.getText().equals(expectedValueItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);

                explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(childXpath)));
                childElement.click();

            }
        }
    }


}
