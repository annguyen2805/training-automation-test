package Seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateWebEdgeDriverManager {
    public static void main(String[] args) {
        WebDriver driver;

        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com.vn/");

        driver.quit();


    }

}
