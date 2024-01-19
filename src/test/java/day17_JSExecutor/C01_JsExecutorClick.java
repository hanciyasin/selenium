package day17_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorClick extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //sell linkine tıklayalım
        driver.findElement(By.xpath("//*[.='Sell']")).click();

        /*
          ElementClickInterceptedException; sell webelementinin önünde bir pencere çıktığı için elemente click yapamadı
        */
    }

    @Test
    public void test02() {
        /*
            Js Executor kullanımında öncelikle JavascriptExecutor arayüzünden bir obje oluşturup, TakeScreenShot'taki
        gibi driver'a eşitleriz. Farklı arayüzler olduğu için casting yaparız. Oluşturduğumuz obje ile
        executeScript() methodunu kullanarak bu method içine script kodunu yazarız. Dolayısıyda webDriver ile
        click yapamadığımız webelementini aşağıdaki örnekteki gibi js executor ile click yapabildik.
        */

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        bekle(2);

        //sell linkine tıklayalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sellLinki);
        bekle(2);

    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        bekle(2);

        //sell linkine tıklayalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sellLinki);

    }
}
