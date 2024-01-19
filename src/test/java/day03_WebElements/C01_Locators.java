package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidiniz
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);    // Keys.ENTER ile enter tusuna bastiriyoruz
        //aramaKutusu.submit(); // submit() methodunu kullanarak aramayi tamamlayabiliriz

        // by name ile locate etmek
        //WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));
        //aramaKutusu.sendKeys("iphone");

        //driver.findElement(By.id("nav-search-submit-button")).click(); //arama butonuna tikladik --> kod kalabaligi


        /*
             Sayfadaki bir webelementi locat etmek icin oncelikler locate edecegimiz webelementin uzerine
        sag tiklayarak sayfanin altinda acilan webelementle alakali html kodlarina ulasabiliriz.
        Bu html kodlari yardimiyla eger webelementin html kodlarinda id attribute'une sahip bir deger varsa
        locate icin once bunu kullanabiliriz, Attribute degerine cift tiklayip ctrl+c --> ctrl+f --> ctrl+v
        yaparak ogenin unique(tek) olup olmadigini html kodlarin altindaki arama kismindan kontrol ederiz.
        Ve tek olan attribute degerini o webelement'i handle edebilmek icin cok rahat yukaridaki ornekteki
        gibi kullanabiliriz.

             Input tag'ina sahip bir webelementi locate attikten sonra senKeys() methodu ile
        o webelemente istedigimiz text'igonderebiliriz
         */



        //Sayfayi kapatiniz
        //driver.close();



    }
}
