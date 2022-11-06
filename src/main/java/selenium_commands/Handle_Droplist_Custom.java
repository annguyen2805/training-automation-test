package selenium_commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class Handle_Droplist_Custom {

    @Test
    public void TC02_Handle_Droplist_Custom() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Open "https://demoqa.com/select-menu"
        driver.get("https://demoqa.com/select-menu");

        //Select the Select Value using the element id
        driver.findElement(By.id("withOptGroup")).click();


        List<WebElement> selectListOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement list : selectListOptions) {
            System.out.println(list.getText());
        }
        driver.findElement(By.xpath("//div[text() ='A root option']")).click();
        driver.findElement(By.id("selectOne")).click();
        driver.findElement(By.xpath("//div[text() ='Other']")).click();


    }
}