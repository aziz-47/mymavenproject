package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tekrar_Before_After_BetBuy {

            //Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    //Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun      https://www.bestbuy.com/
    // titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    //Her testten sonra tarayıcıyı kapatin
    //@Before ve @After metotlarini kullanarak yapalim.




    WebDriver driver;

    @Before
    public void  stup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
    }

    @Test

    public void titleTest(){
        String actualTitle= driver.getTitle();
        String expectedTitle="Best";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

//        if(actualTitle.contains(expectedTitle)){
//            System.out.println("PASS");
//
//        }else{
//            System.out.println("FAILL");
//        }

    }

    @Test
    public void logoTest(){
        WebElement bestBuyLogo= driver.findElement(By.className("logo"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());
//
//        if(bestBuyLogo.isDisplayed()){
//            System.out.println("PASS");
//        }else {
//            System.out.println("FAILL");
//        }

    }

    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLinkElement = driver.findElement(By.linkText("Mexico"));

        Assert.assertTrue(mexicoLinkElement.isDisplayed());

//        if(mexicoLinkElement.isDisplayed()){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }
    }
    // Her testten sonra tarayıcıyı kapatin

    @After
    public void tearDown(){
        driver.close();
    }

}
