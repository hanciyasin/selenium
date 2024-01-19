package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
         /*
        Eğer sadece bir webelementin resmini almak istersek;
            O elementin locate'ini alıp WE.getScreenShotAs() methodu ile webelementin resmini alabiliriz.
            Tüm sayfanın resmini almak istediğimizde TakeScreenShot arayüzünden bir obje oluşturup
        bu objeyi driver'a eşitliyorduk. Dolayısıyla driver'ın gittiği sayfanın resmini
        ts.getScreenShotAs methoduyla alabiliyorduk. Sadece bir webelementin resmini alacağimız için
        TakeScreenShot arayüzüne gerek kalmadan direk webelementin locate'i ile getScreenShotAs methodunu
        kullanarak yine aynı FileUtils class'i ile copyFile methodunu kullanarak resmi alıyoruz
         */
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //ekran resmini alalım
        ekranResmi();

        //sonuc yazısı webelementinin resmini alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/WEscreenShot"+tarih+".png";
        WebElement sonucTxt = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        FileUtils.copyFile(sonucTxt.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //ekran resmini alalım
        ekranResmi();

        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucTxt = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucTxt);



    }

}
