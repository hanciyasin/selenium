package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ExplicitWait_FluentWait extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldTxt = driver.findElement(By.xpath("(//h4)[2]"));

        /*
            Aşağıdaki gibi fluentWait class'ında bir obje oluştururuz. Obje ile önce max. süreyi belirtir
        sonra hangi aralıklarla bekleme yapacaksa onu belirtiriz.
         */
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).
                withMessage("WebElement'i kontrol et");
        fluentWait.until(ExpectedConditions.visibilityOf(helloWorldTxt));

        Assert.assertEquals("Hello World!",helloWorldTxt.getText());

         /*
            Aşağıdaki gibi fluentWait class'ında bir obje oluştururuz. Obje ile önce max. süreyi belirtir
        sonra hangi aralıklarla bekleme yapacaksa onu belirtiriz.
         */

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //Start buttonuna tıkla
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldTxt = driver.findElement(By.xpath("(//h4)[2]"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).
                until(ExpectedConditions.visibilityOf(helloWorldTxt));

        Assert.assertEquals("Hello World!",helloWorldTxt.getText());
    }
}
