package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ActionsTest extends TestBase {
    @Test
    public void actions01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform(); //-->locate ettiğimiz webelemente sağ klik yapar
        //Kullandığımız action'ı işleme alması için perform() methodu kullanmamız gerekiyor

        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        bekle(2);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();


    }
}
