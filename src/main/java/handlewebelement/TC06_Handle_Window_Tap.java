package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TC06_Handle_Window_Tap {
    WebDriver driver;

    @Test
    public void Handle_Window_Tap() throws InterruptedException {
        driver.findElement(By.className("cdo-login-button")).click();
        Set<String> setID = driver.getWindowHandles();
        for (String id : setID) {
            if (driver.getTitle().equals("Login"))
                break;
            driver.switchTo().window(id);
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='login_content']//span[@data-bound-to='loginID']")).getText(), "This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='login_content']//span[@data-bound-to='password']")).getText(), "This field is required");

    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dictionary.cambridge.org/vi/");
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
}
