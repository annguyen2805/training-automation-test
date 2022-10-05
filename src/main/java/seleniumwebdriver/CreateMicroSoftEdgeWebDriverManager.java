package seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateMicroSoftEdgeWebDriverManager {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String title= driver.getTitle();
        System.out.println("title:"+title);
        driver.quit();
    }
}
