package Seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateWebDriverManagerFirefox {
    public static void main(String[] args) {
        WebDriver driver;

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com.vn/");

        driver.quit();
    }
}
