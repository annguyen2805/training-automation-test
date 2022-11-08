package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC03_Handle_Alert {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

    }
    @Test
    public void HandleAlert() {
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.id("confirmResult")).isDisplayed();
        Assert.assertEquals(driver.findElement(By.className("text-success")).getText(), "You selected Ok");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
