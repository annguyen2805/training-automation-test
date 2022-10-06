package firefoxdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class CreateFirefoxDriver {
    public static void main(String[] args) {
        WebDriver driver;
//        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver","C:\\autotest\\chieudo\\training-automation-test\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://booking.kiotviet.vn/spazone1");
    }
}
