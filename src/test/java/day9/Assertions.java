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

public class Assertions {

    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu assertion kullanarak doğrulayın
    // imageTest => Google resminin görüntülenip görüntülenmediğini(isDisplayed()) assertion kullanarak doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini(isDisplayed()) assertion kullanarak doğrulayın
    // Her testten sonra tarayıcıyı kapatin.
    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //yavas siteler icin implicitle wait kullanilabilir
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void titleTest(){

        String actualTile =driver.getTitle();
        String expectedTitle= "Google";

       //Assert Juintteng gelir
        // assertEquals() iki stringi alir ve birbirine esit olup olmadigi kontrol eder.
        Assert.assertEquals(expectedTitle,actualTile);

//        if(actualTile.equals(expectedTitle)){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//
//        }

    }

    @Test
    public void imageTest(){

        //Goohle image locate etmemiz lazim

        WebElement googleImage= driver.findElement(By.id("hplogo"));
       // assertTrue() =>googleImage.isDisplayed() ture ise test Pass olur false ise test Faill olur.
        //asserTrue kullnadigimizda neticenin True olmasini bekliyoruz.
        Assert.assertTrue(googleImage.isDisplayed());

        //AssertFalse kullandigiizda neticenin Flase olmasini bekliyoruz
        //googleImage.isDisplayed() ifadesi TRue oldugu icin test Faill olur .
        Assert.assertFalse(googleImage.isDisplayed());
    }

    @Test
    public  void gmailLinkTest(){

        //locate gmail link elemnentini locate edelim
        WebElement gmailLink= driver.findElement(By.linkText("Gmail"));

        Assert.assertTrue(gmailLink.isDisplayed());

    }

    @After
    public  void tearDown(){
        //@After annotationa genelikle tarayci kapatmak iicn kulanilir.
        //Bu method her testen sonra calsiir.
        driver.close();
    }



}
