package day17_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutorSetAttribute extends TestBase {
    @Test
    public void test01() {
        /*
            sendKeys() methodu ile <input> tagına sahip bir webelemente jsscript kodlarıyla yazılmış ise
        bir veri gönderemeyiz. Bu gibi durumlarda js executor ile çok veri gönderebiliriz
         */
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusuna java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='java'", aramaKutusu);
        bekle(2);

    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusuna iphone yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys("iphone", aramaKutusu);

    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama Kutusu id attribu değerini ismimiz ile değiştirelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','yasin')", aramaKutusu);
        bekle(2);

        //Ve arama kutusunda değiştirdiğimiz attribute ile java aratalım
        WebElement aramaKutusuYeni = driver.findElement(By.id("yasin"));
        jsSendKeys("java", aramaKutusuYeni);
        bekle(3);

    }
}
