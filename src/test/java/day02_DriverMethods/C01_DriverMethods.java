package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String amazonUrl = "https://amazon.com";
        String techProUrl= "https://techproeducation.com";

        //Amazon sayfasina gidiniz
        driver.get(amazonUrl);

        //Sayfa basligini konsola yazidiriniz
        String amazonActualTitle = driver.getTitle(); // --> Icinde olunan sayfanin basligini String olarak getirir
        System.out.println("Amazon Sayfa Basligi:"+ amazonActualTitle);

        // Amazon Sayfanin URL'sini konsola yazdiriniz
        String amazonActualUrl = driver.getCurrentUrl();
        System.out.println("Amazon Sayfa URL'si :"+amazonActualUrl); // --> Icinde olunan sayfanin URL'sini String olarak getirir

        //TechProEdu sayfasina gidiniz
        driver.get(techProUrl);

        //TechProEdu sayfa baslgini konsola yazidiriniz
        String techProActualTitle = driver.getTitle();
        System.out.println("TecPro sayfa basligi:"+techProActualTitle);

        // techPro Sayfanin URL'sini konsola yazdiriniz
        String techProActualUrl = driver.getCurrentUrl();
        System.out.println("TechPro sayfa URL'si:"+techProActualUrl);





    }
}
