package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NoSuchElementException:
            Eğer bu exception'i alıyorsanız
                1-Yanliş locate almış olabilirsiniz. Dolayısıyla locate'i düzeltmeniz gerekir
                2-Locate'ni aldığınız webelement iframe içinde olabilir. Dolayısıyla iframe geçiş yapmanız gerekir
                3-Locate etmek istediğimiz webelement sayfanın altında ise bazen bazı sayfalar scroll yapmadan
                bu webelementi göremez. Dolayısıyla driver'a elementi göstermemiz gerekir.
                4-Bir tıklama işleminden sonra yeni bir pencere açıldıysa driver'i o pencereye geçirmezsek bu hatayı
                alırız. Dolayısıyla pencere geçiş yapmamız gerekir
         */

        // TechPro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        WebElement aramaKutusu = driver.findElement(By.xpath("ssdasdasd"));
        aramaKutusu.sendKeys("java");
    }
}
