package handle.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC05_HandleIframe {
    WebDriver driver;

    @Test
    public void Test() {
        driver.get("https://kyna.vn/");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='face-content']//iframe")).isDisplayed());

        WebElement element = driver.findElement(By.xpath("//iframe[contains(@src,'facebook')]"));
        driver.switchTo().frame(element);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='lfloat']/div[contains(text(),'lượt thích')]")).getText(),
                "165K lượt thích");
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
