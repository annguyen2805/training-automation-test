package selenium_commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Handel_Iframe {
    @Test
    public void TC05_Handle_Iframe(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Step 01: truy cập trang https://kyna.vn/
        driver.get("https://skills.kynaenglish.vn/");

        //switch to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='face-content']//iframe")));

        //Step 02: Verify số lượng like facebook
        String likeFb = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
        Assert.assertEquals(likeFb,"165K lượt thích");

    }

}
