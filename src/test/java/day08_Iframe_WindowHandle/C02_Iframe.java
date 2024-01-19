package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void iframe() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        WebElement baslik = driver.findElement(By.xpath("//h3"));
        String editor = "Editor";

        Assert.assertTrue(baslik.getText().contains(editor));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        bekle(2);
        Assert.assertTrue(textBox.getText().isEmpty());

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);


        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elemantalSelenium = driver.findElement(By.xpath("//*[@style='text-align: center;']"));

        Assert.assertTrue(elemantalSelenium.getText().contains("Elemental Selenium"));



    }
}
