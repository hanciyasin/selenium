package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click();    -->Tiklama işleminde windows penceresi açılacağından burda hata alırız
                                //selenium windows pencerelerine müdehale edemez


        //Yuklemek istediginiz dosyayi secelim.
        //"C:\Users\hanci\Desktop\B171.txt.txt"
        String dosyaYolu = "C:\\Users\\hanci\\Desktop\\B171.txt.txt";
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
        bekle(2);
        //uploadFilePath(dosyaYolu);

        //“File Uploaded!” textinin goruntulendigini test edelim
        WebElement resultTxt = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("File Uploaded!",resultTxt.getText());
        Assert.assertTrue(resultTxt.isDisplayed());

    }
    @Test
    public void test02() {
        driver.get("https://www.ilovepdf.com/compress_pdf");
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();
        bekle(3);
        String dosyaYolu = "C:\\Users\\hanci\\Desktop\\testng.pdf";
        uploadFilePath(dosyaYolu);

        /*
            Upload file yaparken sendKeys() methodunun işlemediği durumlarda TestBase class'ında oluşturduğumuz
         uploadFilePath() methodu ile dosyayı çok rahat yükleyebiliriz. Bu methodu kullanırken manuel olarak
         mause ve klavyeyi test esnasında hiçbir şekilde kullanmamamız gerekir. Mac kullanıcıları windows'taki
         ctrl+v tuş kombinasyonunun karşılık geldiği tuş kombinasyonunu Robot class'a belirtmesi gerekir.
         TestBase deki uploadFilePath() methodu sadece windows kullanıcıları için geçerlidir.
         */

    }
}
