package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    @Test
    public void test01() {
         /*
        STALEELEMENTREFERENCEEXCEPTION
            Bir webelementi locate ettikten sonra sayfada refresh(navigate.refresh),back() yada forward() işlemi
        yaptıysanız ve tekrar locate'ini aldığınız webelementi kullanmak isterseniz bu hatayı alırsınız.
        Çünkü sayfa yenileme, sayfada ileri geri yapma işleminden sonra driver locate'ini aldığını elementi
        eskimiş element olarak görür ve bu hatayı handle etmek için o elementi tekrar locate etmeniz gerekir.
            List<Webelement> linkler = driver.findElements(By.xpath("sdfsdf"))
            Yukarıdaki linklerin olduğu listeyi bir loop içinde hepsine klik yapıcaz
            for(i=0, i<linkler.size, i++){
            linkler.get(i).click
            driver.navigate().back()
            linkler = driver.findElements(By.xpath("sdfsdf"))-->Eğer tekrar liste atama yapmazsak aynı şekilde
            listin içindeki elementleri eskimis kabul edip STALEELEMENTREFERENCEEXCEPTION fırlatacak.
            Dolayısıyla loop içinde list'e tekrar elementlerin atamasını yaparsak bu exception'ı handle etmiş oluruz
         */
        // TechPro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Events linkine tıklayalım
        WebElement events = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        events.click();

        //Back() ile ana sayfaya dönelim
        driver.navigate().back();
        bekle(2);

        //Tekrar Events linkine tıklayalım
        events.click();
        bekle(2);

    }
    @Test
    public void test02() {
        // Amazona gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        bekle(2);

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        bekle(2);

        //Back() ile ana sayfaya dönelim
        driver.navigate().back();
        bekle(2);

        //Tekrar arama kutusunda samsung aratalım
        aramaKutusu.sendKeys("samsung",Keys.ENTER);
        bekle(2);

         /*
        refresh,back ve forward işlemlerinde sonra eğer elementin locate'ini tazelemezsek StaleElementReferenceException
        hatasını yukarıdaki örnekteki gibi alırız.
         */

    }
    @Test
    public void test03() {
        // TechPro sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement events = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        events.click();

        //Sayfayı yenile
        driver.navigate().refresh();

        //Tekrar Events linkine tıklayalım
        events.click();

    }
}
