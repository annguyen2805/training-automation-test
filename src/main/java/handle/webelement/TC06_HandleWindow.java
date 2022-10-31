package handle.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class TC06_HandleWindow {
    WebDriver driver;

    @Test
    public void Test() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();
        String parentID = driver.getWindowHandle();
        System.out.println("parentID: " + parentID);
        Set<String> allWindown = driver.getWindowHandles();
        for (String s: allWindown) {
            if (!s.contains(parentID)){
                driver.switchTo().window(s);
                System.out.println("s: " + s);
                break;
            }
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='login_content']//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='login_content']//span[@data-bound-to='loginID']")).getText(),
                "This field is required");
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
