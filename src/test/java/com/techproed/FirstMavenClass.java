package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {

    public static void main(String[] args) {
       // Driveri baslatmak icin bunu java projelrinde kullnaiyourz. System.setProperty("","")
        // Bunun yerine Maven projesinde WebDriverManager
        //chrome diriver icin

       WebDriverManager.chromedriver().setup();//krimizi olmasinin sebebi ekisk dependensy lerin olmasindadir
        //Dependesy ler nerden aliniz? https://mvnrepository.com/ git ve WebDriverManager ara
        WebDriver driver = new ChromeDriver();//https://mvnrepository.com/ git ve selenium java dependyse arayacagiz

        driver.get("https://www.google.com");

        //fake data nasil olustrulur?
        //fake data olustrumak icin "JavaFaker" denilen bir dependenc gerekir
       //serac box elementini locat ettik
        WebElement searcBox= driver.findElement(By.name("q"));

        // faker objesini olusturduk.
        Faker faker= new Faker();
        // Searc box a fake data gonder ve ENTER a bas.
        searcBox.sendKeys(faker.name().fullName()+ Keys.ENTER);


       // searcBox.sendKeys(faker.country().flag());=
        //searcBox.submit();

        System.out.println(faker.country().capital());


    }
}
