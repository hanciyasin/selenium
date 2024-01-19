package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_WindowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String anasayfaHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String anasayfaTxt = driver.findElement(By.xpath("//h3")).getText();
        String expectedTxt = "Opening a new window";

        Assert.assertEquals(anasayfaTxt,expectedTxt);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String anasayfaTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals(anasayfaTitle,expectedTitle);

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//*[@href='/windows/new']"));
        clickHere.click();
        bekle(2);

        Set<String> pencereler = driver.getWindowHandles();
        for (String w:pencereler){              //Tikladigimiz link yeni bir sekme aciyor ise driver otomatik olarak o sekmeyi acar fakat o sekmeye gecis yapmaz
            if(!w.equals(anasayfaHandle)){      //o sekmeye gecis yapmamiz icin switchTo() methodunu kullanmaliyiz
                driver.switchTo().window(w);    //driver henuz acilan sekmeye gecis yapmadigi icin bu sekilde windowHandle aliyoruz
            }
        }

         /*
            Handle değeri ilk sayfaya eşit olmayana geçiş yap diyerek kontrolümüz dışında açılan penceye driver'i geçirip
        aşağıdaki gibi bir string değişkene assing ettik
         */

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        Assert.assertEquals("New Window",driver.getTitle());
        String ikinciSayfaHandle = driver.getWindowHandle();


        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(anasayfaHandle);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        bekle(2);



        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(anasayfaHandle);
        bekle(2);

    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String anasayfaTxt = driver.findElement(By.xpath("//h3")).getText();
        String expectedTxt = "Opening a new window";

        Assert.assertEquals(anasayfaTxt,expectedTxt);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String anasayfaTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals(anasayfaTitle,expectedTitle);

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//*[@href='/windows/new']"));
        clickHere.click();
        bekle(2);

        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());  
        /*
        acilan tum sayfalarin window handle degerlerini bir listte topluyoruz bu listeden 
        driver.switchTo().window(list.get(index)) methodunu kullarak pencereler arasi gecis yapariz   
        */
        
        
        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        driver.switchTo().window(pencereler.get(1));
        Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        bekle(2);



        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
        bekle(2);

    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String anasayfaTxt = driver.findElement(By.xpath("//h3")).getText();
        String expectedTxt = "Opening a new window";

        Assert.assertEquals(anasayfaTxt,expectedTxt);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String anasayfaTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals(anasayfaTitle,expectedTitle);

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//*[@href='/windows/new']"));
        clickHere.click();
        bekle(2);


        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        bekle(2);



        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);

    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String anasayfaTxt = driver.findElement(By.xpath("//h3")).getText();
        String expectedTxt = "Opening a new window";

        Assert.assertEquals(anasayfaTxt,expectedTxt);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String anasayfaTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals(anasayfaTitle,expectedTitle);

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//*[@href='/windows/new']"));
        clickHere.click();
        bekle(2);


        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        window(1);
        Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        window(0);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        bekle(2);



        //  ikinci sayfaya tekrar geçin.
        window(1);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        window(0);
        bekle(2);

    }
}
