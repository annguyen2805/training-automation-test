package Seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateWebEdgeDriver {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","D:\\Project_auto\\training-automation-test\\src\\main\\resources\\driver.edge\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com.vn/?gws_rd=ssl");
        driver.quit();
    }
}
