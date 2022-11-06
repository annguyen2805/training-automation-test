package selenium_commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Handle_Window_Tap {

    @Test
    public void TC06_Handle_Window_Tap(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Step 01: truy cập trang https://dictionary.cambridge.org/vi/
        driver.get("https://dictionary.cambridge.org/vi/");

        //Step 02: Click vào button Đăng nhâp/ đăng kí
        driver.findElement(By.xpath("//span[text()='Đăng nhập']/parent::span")).click();

        //switch to new tab
        String idWindow = driver.getWindowHandle();
        Set<String> setId = driver.getWindowHandles();

        for (String id : setId){
            if (!id.equals(idWindow)){
                driver.switchTo().window(id);
                break;
            }
        }
        driver.findElement(By.xpath("//div[@id='login_content']//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='login_content']//span[@data-bound-to='loginID']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='login_content']//span[@data-bound-to='password']")).getText(),"This field is required");


    }

}
