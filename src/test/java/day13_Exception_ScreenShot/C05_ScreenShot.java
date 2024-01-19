package day13_Exception_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
         /*
        SCREENSHOT
            Selenium da tüm sayfanın resmini alabilmek için;
                1-TakeScreenShot arayüsünden bir obje oluşturup driver'a eşitleriz
                Farklı arayüzler olduğu için casting yaparız.
                2-FileUtils class'ından copyFile() method'u içe parametre olarak
                oluşturmuş olduğumuz obje ile getScreenShotAs() methodunu kullanır getScreenshot() methoduna
                parametre olarak OutputType.File ekleriz ve bunu yeni bir dosyaya kaydetmesi için
                new File() diyerek resmi kaydedeceğimiz dosyanın yolunu belirtiriz
         */
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Tüm sayfanın ekran görüntüsünü alalım\
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("src/test/java/utilities/TumSayfaResimleri/ilktest.jpeg"));

    }
    @Test
    public void test02() throws IOException {
        //Techpro sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu ="src/test/java/utilities/TumSayfaResimleri/ikincitest.jpeg";
        File file = new File(dosyaYolu);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),file);

    }
    @Test
    public void test03() throws IOException {
        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //Tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "src/test/java/utilities/TumSayfaResimleri/ucuncutest.jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
