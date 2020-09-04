package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_BeforeAfterAirbnb {
       // Bir class oluşturun: Homework_BeforeAfterAirbnb
       // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
       // titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
       // logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
       // helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
       // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;


    @Before

    public void stup(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
         driver.get("https://www.Airbnb.com/");
    }

      @Test

    public void titleTest(){

        String actualTitle= driver.getTitle();
        String expectedTitle= "Airbnb";

        if(actualTitle.contains("Airbnb")){
            System.out.println("PASS");

        }else{
            System.out.println("FAILL");
        }



      }

      @Test

    public void logoTest(){
          WebElement logoTest= driver.findElement(By.xpath("//div[@class='_3hmsj']"));

          if(logoTest.isDisplayed()){
              System.out.println("PASS");
          }else{
              System.out.println("FAILL");
          }



      }

      @Test

    public void helpLinkTest(){
        WebElement helpLinkTest= driver.findElement(By.linkText("Help"));
        if(helpLinkTest.isDisplayed()){
            System.out.println("PASS");
        } else {
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
