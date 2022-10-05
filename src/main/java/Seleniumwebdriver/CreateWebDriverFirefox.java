package Seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateWebDriverFirefox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","D:\\Project_auto\\training-automation-test\\src\\main\\resources\\driver.firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");

        driver.quit();
    }
}
