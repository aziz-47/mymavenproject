package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations {
    //Bir JUnit projesinde testi calsitirmak icin @test annotation u kullanilabilr.
    //"test1 adinda bir void method olusturlim.


    @Before// her @Test den once calisir
    public void runBeforeTest(){
        System.out.println("@Before=>run Before test");
    }

    @Test//@test test caseleri main method olamdan calsitrimamzi saglar.
    public void test1(){
        System.out.println("Test1 i yazdir");
    }



    @Ignore//@Ignore test metdodunu gormezden gelmeyi saglar
    @Test
    public void test2(){
        System.out.println("Test 2 yi yazidr");
    }


    @Test
    public void test3(){
        System.out.println("Test3 u yazdir.");
    }

    @After//Her @Test en sonra calisir.
    public void runAfterTest(){
        System.out.println("@After => run after test");
    }

}
