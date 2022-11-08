package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05_Handle_Iframe {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://skills.kynaenglish.vn/");
    }
    @Test
    public void Handle_Iframe() {
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fanpage ']//iframe")));
        System.out.println(driver.findElement(By.xpath("//div[@class='_1drq']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='_1drq']")).getText(), "165K likes");
        driver.switchTo().defaultContent();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
