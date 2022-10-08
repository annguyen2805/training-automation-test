package javabasic_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateWebDriverWithME {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver;
//        System.setProperty("webdriver.edge.driver", "E:\ANpro\02-trainning\training-automation-test\src\main\resources\driver.edge\msedgedriver.exe");
        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com.vn");

        String title = driver.getTitle();
        System.out.println("Title : "+title);

    }
}
