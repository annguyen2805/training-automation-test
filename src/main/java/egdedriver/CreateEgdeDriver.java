package egdedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateEgdeDriver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.edge.driver", "C:\\autotest\\chieudo\\training-automation-test\\src\\main\\resources\\msedgedriver.exe");
        driver  = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://booking.kiotviet.vn/spazone1");

    }
}
