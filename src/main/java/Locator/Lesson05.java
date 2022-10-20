package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Lesson05 {
    WebDriver driver;
    @BeforeMethod
    public void Set_Up(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void TC01_Handle_Dropdownlist(){
        ListElement listElement=new ListElement();
        Customer customer= new Customer();
        customer=customer.Random_Info_Customer();
        driver.get("https://demo.nopcommerce.com/register");
        listElement.Nopcommerce_Register_Link(driver).click();
        listElement.Nopcommerce_Register_Gender_Female(driver).click();
        listElement.Nopcommerce_Register_First_Name(driver).clear();
        listElement.Nopcommerce_Register_First_Name(driver).sendKeys(customer.getCusName());
        listElement.Nopcommerce_Register_Last_Name(driver).clear();
        listElement.Nopcommerce_Register_Button(driver).sendKeys(customer.getCusLastName());

        Select dateOfBirthDay=new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Day(driver));
        List<WebElement> Options=dateOfBirthDay.getOptions();
        Options.forEach(value -> System.out.print(value.getText()+ " "));
        Assert.assertEquals(Options.size(),32);
        dateOfBirthDay.selectByVisibleText("1");

        Select dateOfBirthMonth=new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Month(driver));
        Options=dateOfBirthMonth.getOptions();
        Options.forEach(value -> System.out.print(value.getText()+ " "));
        Assert.assertEquals(Options.size(),13);
        dateOfBirthMonth.selectByVisibleText("July");

        Select dateOfBirthYear=new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Year(driver));
        Options=dateOfBirthYear.getOptions();
        Options.forEach(value -> System.out.print(value.getText()+ " "));
        Assert.assertEquals(Options.size(),112);
        dateOfBirthYear.selectByValue("2000");

        listElement.Nopcommerce_Register_Email(driver).clear();
        listElement.Nopcommerce_Register_Email(driver).sendKeys(customer.getCusEmail());

        listElement.Nopcommerce_Register_Password(driver).clear();
        listElement.Nopcommerce_Register_Password(driver).sendKeys(customer.getCusPassword());

        listElement.Nopcommerce_Register_Confirm_Password(driver).clear();
        listElement.Nopcommerce_Register_Confirm_Password(driver).sendKeys(customer.getCusPassword());

        listElement.Nopcommerce_Register_Button(driver).click();
        Assert.assertEquals(listElement.Nopcommerce_Register_Result(driver).getText(),"Your registration completed");
        Assert.assertTrue(listElement.Nopcommerce_Register_MyAccount(driver).isDisplayed());
        Assert.assertTrue(listElement.Nopcommerce_Register_Logout(driver).isDisplayed());

        listElement.Nopcommerce_Register_MyAccount(driver).click();
        Select cusInfoDateOfBirthDay =new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Day(driver));
        Assert.assertEquals(cusInfoDateOfBirthDay.getFirstSelectedOption().getText(),"1");
        Select cusInfoDateOfBirthMonth =new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Month(driver));
        Assert.assertEquals(cusInfoDateOfBirthMonth.getFirstSelectedOption().getText(),"July");
        Select cusInfoDateOfBirthYear =new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Year(driver));
        Assert.assertEquals(cusInfoDateOfBirthYear.getFirstSelectedOption().getText(),"2000");

    }
    @AfterMethod
    public void Tear_Down(){
        driver.quit();
    }
}
