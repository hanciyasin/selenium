package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alert extends TestBase {
     /*
        Eğer bir sayfadaki butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan uyarı penceresine sağ klik
    yapamıyorsak (incele/inspect) bu tür uyarı pencerelerine js Alert denir. Bu uyarı penceresini handle edemediğimiz
    için driver'i bu pencereye geçiş yaptırmamız gerekir. Bunun içinde switchTo() methodu kullanılır.
    driver.swichTo().alert() methoduyla alert'e geçiş yaparız. Ve alert onaylamak için accept(), iptal etmek için
    dismiss(), alert üzerindeki yazıyı almak için getText() ve alertteki mesaj kutusuna bir text göndermek için
    sendKeys() methodunu kullanırız.
     */

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        WebElement alert = driver.findElement(By.xpath("(//button)[1]"));
        alert.click();  //-->1. buttona click yaptık
        bekle(2);
        driver.switchTo()   //-->Geçiş methodu
                .alert()    //-->Alerte driver'i geçirdik
                .accept();  //-->Alert'ü onayladık

        String actualMesage = driver.findElement(By.xpath("(//*[@id='result'])[1]")).getText();
        String expectedMesage = "You successfully clicked an alert";

        Assert.assertEquals(actualMesage,expectedMesage);
    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        WebElement dismissAlert = driver.findElement(By.xpath("(//button)[2]"));
        dismissAlert.click();   //-->2. buttona click yaptık
        bekle(2);
        driver.switchTo()     //-->Geçiş methodu
                .alert()      //-->Alerte driver'i geçirdik
                .dismiss();   //-->Alert'i Cancel yaptik

        String actualMesage = driver.findElement(By.xpath("(//button)[3]")).getText();
        String unexpectedMessage = "successfuly";
        Assert.assertFalse(actualMesage.contains(unexpectedMessage));

    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement sendKeysAlert = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        sendKeysAlert.click();
        bekle(2);
        driver.switchTo().alert().sendKeys("Yasin");
        bekle(2);
        driver.switchTo().alert().accept();

        String actualName = driver.findElement(By.xpath("(//*[@id='result'])[1]")).getText();
        String realName = "Yasin";

        Assert.assertTrue(actualName.contains(realName));



    }
}
