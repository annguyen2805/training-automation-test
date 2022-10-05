package seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateFireFoxWebDriver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver","D:\\AutomationProject\\training-automation-test\\src\\main\\resources\\driver.firefox\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title= driver.getTitle();
        System.out.println("title:"+title);
        driver.quit();
    }
}
