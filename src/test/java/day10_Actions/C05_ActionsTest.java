package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C05_ActionsTest extends TestBase {
    @Test
    public void actions01() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));

        actions.keyDown(Keys.SHIFT).    //-->Arama kutusunda shift tuşuna basılı tutar
                sendKeys("selenium").    //-->Shift tuşuna basılı tutarak SELENIUM yazdıracak
                keyUp(Keys.SHIFT).    //-->Shift tuşundan elini çek
                sendKeys(" - java",Keys.ENTER).perform();
        bekle(3);

    }

    @Test
    public void actions02() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT," - java",Keys.ENTER);
        bekle(3);


          /*
            Yukarıdaki örnekte action class'ı kullanmadan da istediğim metni büyük küçük harf ile yazdırabilirim.
        ilk yazdığımız Keys.Shift shift tuşuna basılı tutar dolayısıyla büyük harf ile yazar. İkinici yazdığımız
        Keys.Shift ise shift tuşunu serbest bırakır. Klavye tuşlarını pratik olarak yukarıdaki örnekteki gibi
        kullanabilirsiniz.
         */


        /*
        ÖDEV:
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         */
    }
}
