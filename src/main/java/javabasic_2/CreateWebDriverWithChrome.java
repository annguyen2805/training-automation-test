package javabasic_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateWebDriverWithChrome {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver", "E:\ANpro\02-trainning\training-automation-test\src\main\resources\driver.chrome\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com.vn");

        String title = driver.getTitle();
        System.out.println("Title : "+title);

    }
}
