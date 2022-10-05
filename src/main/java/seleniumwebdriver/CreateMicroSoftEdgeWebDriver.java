package seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateMicroSoftEdgeWebDriver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.edge.driver","D:\\AutomationProject\\training-automation-test\\src\\main\\resources\\driver.microsoft.edge\\msedgedriver.exe");
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title= driver.getTitle();
        System.out.println("title:"+title);
        driver.quit();
    }
}
