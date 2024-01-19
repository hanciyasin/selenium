package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu extends TestBase {
     /*
        Dropdown menü; alt başlıkların listelendiği sayfadaki bir webelemente denir.

    Dropdown webelementine sendKeys() methodu ile listede bulunan seçeneklerden istediğimizi gönderebiliriz.

    Gönderemediğimiz durumlarda Select class'ından bir obje oluşturarak bu oluşturduğumuz objeye parametre olarak
    locate ettiğimiz dropdown webelementini yazarız.Bu oluşturduğumuz obje ile byIndex,byvisibletext ve byValue
    methodları ile dropdown menudeki seceneklerden istediğimizi secebiliriz.

    getOptions() methodu ile tüm dropdown menüdeki seçenekleri listeleyebiliriz.

    getFirstSelectedOption() methodu ile dropdown menüde ilk seçili olan seçeneği getirir.

    Bir Dropdown menu <select> tag'ına sahip değilse Select class'ını kullanamazsınız.
     */

    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() throws InterruptedException {
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement ay = driver.findElement(By.cssSelector("select#month"));  //--> css - select[id='month']
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));

        //b. Select objesi olustur
        Select selectyil = new Select(yil);
        Select selectay = new Select(ay);
        Select selectgun = new Select(gun);

        //c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        //selectyil.selectByIndex(5);
        selectIndex(yil,5);//-->TestBase class'ındaki methodu kullandık
        selectay.selectByVisibleText("May");
        selectgun.selectByValue("22");

    }

    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement eyalet = driver.findElement(By.cssSelector("select#state"));
        Select selectEyalet = new Select(eyalet);
        List<WebElement> eyaletListesi = selectEyalet.getOptions();

        for (WebElement each:eyaletListesi){
            System.out.println(each.getText());
        }

        //eyaletListesi.forEach(t-> System.out.println(t.getText()));//-->Lamda


    }
    @Test
    public void test03() {
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement eyalet = driver.findElement(By.cssSelector("select#state"));
        Select selectEyalet = new Select(eyalet);
        String seciliSecenek = selectEyalet.getFirstSelectedOption().getText();

        String expectedSecili = "Select a State";

        Assert.assertEquals(seciliSecenek,expectedSecili);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
