package location.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Web_TechPanda {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.manage().window().maximize();

    }

    @Test
    public void tc03() {
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//button[@id='send2']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");

    }

    @Test
    public void tc04() {
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("trainningautomation@hotmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");

        driver.findElement(By.xpath("//button[@id='send2']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']")).getText(),"Invalid login or password.");
    }

    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }
}
