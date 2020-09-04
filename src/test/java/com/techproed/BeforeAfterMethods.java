package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfterMethods {
       // Bir class oluşturun: BeforeAfterMethods
       // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
        // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
        // imageTest => Airbnb logosunun görüntülenip görüntülenmediğini(isDisplayd) doğrulayın
        // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini(IsDisplayd) doğrulayın

    WebDriver driver;

    @Before
    public void setup(){
        //@Before annotation'i tekrarlanan kosullar icin kullanilir
        //@Before driver'i kurmak,browser'i acmak, URL'e gitmek icin kullanilir
        //@Before ve @After kullanarak tekrari engellemis oluruz
        //@Before her @Test methodundan once calisir
        //Eger internetiniz,web sitesi veya browser yavassa testiniz basarisiz olabilir.
        // bunu onlemek icin @Before icine wait ekleyebilirsiniz.
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

         if(actualTile.equals(expectedTitle)){
             System.out.println("PASS");
         }else{
             System.out.println("FAIL");

         }

     }

     @Test
    public void imageTest(){

         //Goohle image locate etmemiz lazim

         WebElement googleImage= driver.findElement(By.id("hplogo"));
         if(googleImage.isDisplayed()){
             System.out.println("pASS");
         }else{
             System.out.println("FAILL");
         }
        ;

     }

     @Test
    public  void gmailLinkTest(){

         //locate gmail link elemnentini locate edelim
         WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
         if(gmailLink.isDisplayed()){
             System.out.println("PASS");
         }else{
             System.out.println("FAILL");
         }


     }

     @After
     public  void tearDown(){
        //@After annotationa genelikle tarayci kapatmak iicn kulanilir.
         //Bu method her testen sonra calsiir.
        driver.close();
     }

}
