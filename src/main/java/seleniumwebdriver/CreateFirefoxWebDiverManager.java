package seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateFirefoxWebDiverManager {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("title= "+ driver.getTitle());
    }
}
