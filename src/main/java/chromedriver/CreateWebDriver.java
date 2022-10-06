package chromedriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class CreateWebDriver {
    public static void main(String[] args) {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\autotest\\chieudo\\training-automation-test\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://booking.kiotviet.vn/spazone1");
        String title = driver.getTitle();
        System.out.println("title" + title);

    }
}
