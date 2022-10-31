package handle.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TC03_HandleAlert {
    WebDriver driver;

    @Test
    public void Test() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String result = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
        Assert.assertTrue(result.contains("Ok"));

        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        result = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
        Assert.assertTrue(result.contains("Cancel"));

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
