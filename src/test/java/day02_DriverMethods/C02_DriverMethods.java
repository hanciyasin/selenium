package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String techProUrl = "https://techproeducation.com";

        // TechPro sayfasina gidelim
        driver.get(techProUrl);

        //Sayfa basligini yazdirin
        System.out.println("Sayfa Basligi: " + driver.getTitle());

        //sayfa basliginin "Techpro" icerdigini test edin
        if (driver.getTitle().contains("Techpro")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //sayfa adresini yazdirin(URL)
        System.out.println("Sayfa URL'si: " + driver.getCurrentUrl());

        //sayfa url'sinin "techpro" icerdigini test edin
        if (driver.getCurrentUrl().contains("techpro")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //sayfa handle degerini yazdirin
        String techProSayfaHandleDegeri =  driver.getWindowHandle();
        System.out.println("Sayfa Handle degeri: " + techProSayfaHandleDegeri);
        /*
        getWindowHandle() methodu ile kendimiz isteyerek baska bir oencereye gecis yaptigimnizda iki tane pencere
        acmis olucaz. Dolayisiyla ilk acitigimiz pencereye tekrar gecis yapmak istedigimizde ilk actigimiz pencereden
        sonra almis oldugumuz window handle degeri ile gacis yapailiriz. Pencereler arasi gecis konusunda bunu detayli
        gorecegiz. Birde bir sayfaya gittigimizde bir linke tikladigimizda bizimi kontrolumuz disinda yeni bir pencere
        acilabilir. Bu gibi durumlarda da getWindowHandles() method ile driver'in acmis oldugu pencerelerin handle
        degerlerine bir list'e assing ederiz ve istedigimiz pencereye index ile cok rahat gecis yapabiliriz.
         */


        //Sayfa HTML kodlarinda "Gateway" var mi kontrol ediiniz
        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().contains("text"));

        //Sayfayi kapatiniz
        driver.close();  // --> close() methodu driverin en son actigi sayfayi kapatir
        //driver.quit() methodu ise bizim actigimiz birden fazla sekme yada pencerelerin hepsini kapatmak icin kullanilir



    }
}
