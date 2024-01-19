package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        String baslik = driver.getTitle();
        Assert.assertEquals(baslik,"TechPro Education");
        String techProHandle = driver.getWindowHandle();
        bekle(1);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youTubeHandle = driver.getWindowHandle();
        bekle(1);

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedIn = driver.getWindowHandle();
        bekle(1);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techProHandle);
        bekle(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youTubeHandle);
        bekle(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedIn);
        bekle(2);

    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        String baslik = driver.getTitle();
        Assert.assertEquals(baslik,"TechPro Education");
        String techProHandle = driver.getWindowHandle();
        bekle(1);

        //Window 2'de (yeni bir sekme) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youTubeHandle = driver.getWindowHandle();
        bekle(1);

        //Window 3'te (yeni bir sekme) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedIn = driver.getWindowHandle();
        bekle(1);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techProHandle);
        bekle(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youTubeHandle);
        bekle(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedIn);
        bekle(2);

    }

    @Test
    public void test03() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        String baslik = driver.getTitle();
        Assert.assertEquals(baslik,"TechPro Education");
        String techProHandle = driver.getWindowHandle();
        bekle(1);

        //Window 2'de (yeni bir sekme) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youTubeHandle = driver.getWindowHandle();
        bekle(1);

        //Window 3'te (yeni bir sekme) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedIn = driver.getWindowHandle();
        bekle(1);


        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        /*
            Yukarıdaki arrayList sayesinde açılmış olan tüm pencereleri getWindowHandles() methodu sayesinde alıp
        index ile istediğimiz pencereye çok rahat geçişler yapabiliriz
         */


        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(windowHandles.get(0));
        bekle(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(windowHandles.get(1));
        bekle(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(windowHandles.get(2));
        bekle(2);

    }
}
