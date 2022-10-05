package seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateFireFoxWebDriverManager {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String title= driver.getTitle();
        System.out.println("title:"+title);
        driver.quit();
    }
}
