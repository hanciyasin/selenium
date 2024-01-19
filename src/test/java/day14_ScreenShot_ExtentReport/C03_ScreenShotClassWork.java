package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement events = driver.findElement(By.xpath("(//*[@href='/events'])[1]"));
        events.click();

        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));

        //Ve sayfanın resmini alalım
        ekranResmi();

        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Ve sayfanın resmini alalım
        ekranResmi();

        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //Çıkan sonun yazısının resmini alalım
        WebElement sonucTxt = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucTxt);

        //Techpro sayfasına geri dönelim
        window(0);

        //ve sayfanın resmini alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/screenShot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
    @Test
    public void test02() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement events = driver.findElement(By.xpath("(//*[@href='/events'])[1]"));
        events.click();

        //Basliğin Events içerdiğini doğrulayalım


        //Ve sayfanın resmini alalım


        //Yeni bir sekmede amazon sayfasına gidelim


        //Ve sayfanın resmini alalım


        //Arama kutusunda iphone aratalım


        //Çıkan sonun yazısının resmini alalım


        //Techpro sayfasına geri dönelim


        //ve sayfanın resmini alalım


    }
}
