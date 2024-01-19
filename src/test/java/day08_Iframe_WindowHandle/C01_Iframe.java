package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        WebElement anaSayfaText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']"));
        Assert.assertTrue(anaSayfaText.getText().contains("black border"));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);   //-->Driver'i index kullanarak iframe geçiş yaptırdık
        bekle(2);
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        String expectedText = "Applications lists";
        Assert.assertEquals(actualText,expectedText);

        //Son olarak ana sayfadaki, sayfanın en altındaki daki ‘Povered By’ yazisini varligini test edelim
        driver.switchTo().defaultContent();
        String poveredByTxt = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        String expectedTxt = "Povered By";

        Assert.assertTrue(poveredByTxt.contains(expectedTxt));

        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        String anasayfaIframeTxt = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(anasayfaIframeTxt,"iframe");



    }

     /*
        Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline Frame(iframe) denir.
    Sayfadaki bir webelementi locate ettiğimizde nosuchelementexception alıyorsak önce locate'i kontrol ederiz,
    ve yine aynı hatayı alıyorsak locate etmek istediğimiz webelement iframe içinde olabilir. Dolayısıyla
    iframe içindeki bir webelementi locate etmek için driver'imizi iframe geçirmemiz gerekir.
        Alert'ten de bildiğimiz aynı geçiş komutu olan switchTo() methodunu kullanarak frame() methodu ile
    iframe'e geçiş yaparız. frame() methodu bizden parametre olarak hangi frame geçileceğini ister.
        driver.switchTo.frame(1.sayfadaki iframe'in Index'i(index 0'dan başlar))
        driver.switchTo.frame(2.<iframe> tag'ındaki id/name attribute değeri)
        driver.switchTo.frame(3.iframe'in locate'i)
        Bu 3 yöntem ile Iframe'e geçiş yapabiliriz.
        Tekrar ana sayfaya geçmek istersek defaultContent() methodu ile iframe'den çıkıp anasayfaya geçeriz.
    Eğer içi içe iframe'lere geçiş yaptıysak ve bir üst frame tekrar driver'i taşımak istersek
    parentFrame() methodu ile bir üst frame'e geçiş yapabiliriz.
     */

    // -->Refresh() methodu'da bizi anasayfaya götürür fakat iframe içinde bir form
    // doldurma gibi işlemler yaparsak bunları sıfırlar.
    // refresh() kullandığımızda tüm elementleride yenilediği için tekrar locate almamız
    // gerekebilir.-->staleElementReferansException
}
