package firefoxdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class CreateFirefoxDriver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver","C:\\autotest\\chieudo\\training-automation-test\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://booking.kiotviet.vn/spazone1");
    }
}
