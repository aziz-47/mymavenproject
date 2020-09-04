package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceDropdown {

    // Create class : FaceDropdown
    // Create method : Birthday
    // https://www.facebook.com adresine gidin
    // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
    // Tarayiciyi kapatin.

    WebDriver driver;

    @Before

    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.facebook.com");
    }

    @Test
    public  void dayDropDown(){
        WebElement dayElement= driver.findElement(By.id("day"));
        Select dayOptions= new Select((dayElement));
        dayOptions.selectByValue("10");


    }

    @Test

    public void monthDropDown(){
        WebElement monthtElement= driver.findElement(By.id("month"));
        Select monthOptions= new Select(monthtElement);
        monthOptions.selectByVisibleText("Jan");


    }

    @Test

    public  void yearDropDown(){
        WebElement yearElement= driver.findElement(By.id("year"));
        Select yearOptions= new Select(yearElement);
        yearOptions.selectByValue("2015");
    }


    @After

    public  void tearDown(){
        driver.close();
    }

}
