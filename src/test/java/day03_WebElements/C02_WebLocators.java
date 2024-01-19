package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //TechPro sayfasina gidelim
        driver.get("https://www.techproeducation.com");

        //Arama kutusunda java aratalim
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        aramaKutusu.sendKeys("java");
        Thread.sleep(3000);

        //Cikan seceneklerden full stack java developer secenegine tiklayalim
        List<WebElement> javaDeveloperList = driver.findElements(By.linkText("Full Stack Java Developer"));

        /*
            linktext'i Full Stack Java Developer olan bütün webelementleri javaDeveloperListesi isimli liste attık.
        Html kodlari arasindan yukarı aşağı ok tuşları ile hangi webelement tıklamak istediğim web element ise onu
        4. de bulduk. List'te index 0 dan başladığı için 3 element benim isteğim element olacaktır
         */
        javaDeveloperList.get(0).click();

        //javaDeveloperList.forEach(t-> System.out.println(t.getText()));


        //Basligin java icerdigini test edelim
        if (driver.getTitle().contains("Java")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //Sayfada kac tane link oldugunu konsola yazdiralim
        List<WebElement> linklerSayisi = driver.findElements(By.tagName("a"));

        /*
            Tag'ı a olan webelementlerin hepsini bir liste attık. List kullanımında birden fazla webelemente ulaşmak
        istediğimiz için findElement() methodu yerine findElements() methodunu kullanırız.
         */
        System.out.println("Sayfadaki linklerin sayisi : "+linklerSayisi.size());

        //Linkleri konsola yazdiralim
        for (WebElement w:linklerSayisi) {if (!w.getText().isEmpty()){
            System.out.println(w.getText());}
        }
        /*
        Bir webelementin sahip olduğu text'i yazdırmak isterseniz getText() methodunu kullanmamız gerekir
         */

        //Lambda ile ;
        //linklerSayisi.forEach(t-> System.out.println(t.getText()));
        linklerSayisi.forEach(link->{if (!link.getText().isEmpty()){ System.out.println(link.getText());}});

        //sayfayi kapatiniz
        driver.close();




    }
}
