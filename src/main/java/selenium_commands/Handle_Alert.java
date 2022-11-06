package selenium_commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Handle_Alert {
    @Test
    public void TC03_Handle_Alert(){
        WebDriver driver ;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Alert alert;

        //Step 01: Launch the website "https://demoqa.com/alerts".
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();

        // accept alert
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Do you confirm action?");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("confirmResult")).getText(),"You selected Ok");

        // dismiss alert
        driver.navigate().refresh();
        driver.findElement(By.id("confirmButton")).click();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Do you confirm action?");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("confirmResult")).getText(),"You selected Cancel");
        driver.quit();

    }
}