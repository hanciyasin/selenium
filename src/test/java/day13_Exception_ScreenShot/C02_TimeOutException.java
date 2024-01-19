package day13_Exception_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
      TIMEOUTEXCEPTION
         Eğer timeOutexception alıyorsanız;
           1-Kullanılan explicitWait'teki max. süreyi kontrol etmemiz gerekir
           2-explicit wait ile kullandığımız elementin locatini kontrol etmemiz gerekir
           3-explicit wait ile kullandığımız methodu doğru seçmemiz gerekir
    */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloTxt = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //-->TimeOutException almak için (Duration.ofSeconds(2)) max. süreyi 2 saniye yaptık
        wait.until(ExpectedConditions.visibilityOf(helloTxt));
        Assert.assertEquals("Hello World!",helloTxt);

    }
    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloTxt = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Wait içinde yanlis locate de bize TimeOutException verir
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlis locate")));
        Assert.assertEquals("Hello World!",helloTxt);

        //NOT: Eğer yanlis LOCATOR(örn:xpath yerine css gibi) kullanırsanız InvalidSelectorException alırsınız

    }
}
