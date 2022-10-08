package seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateMsedgeWebDriverManager {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("title= "+ driver.getTitle());
    }
}
