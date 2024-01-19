package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {
    @Test
    public void actions01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameIndex(0);  // -->  iframe çıktığı için driver'i iframe'e geçirmem gerekir

        WebElement dragBox = driver.findElement(By.id("draggable"));
        WebElement dropBox= driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragBox,dropBox).perform();
        bekle(2);



    }

    @Test
    public void actions02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameIndex(0);  //-->TestBase'de method ile iframe'e geçiş yaptık

        WebElement dragBox = driver.findElement(By.id("draggable"));
        WebElement dropBox= driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragBox)   //-->Drag webelementini tut ve bekle
                .moveToElement(dropBox)   //-->Drag webelementini tutup drop webelementinin üzerine götürür
                .release()   //-->Basılı tuttuğumuz webelementi serbest bırakır
                .perform();   //-->Action'ı işleme aldık
        bekle(2);



    }

    @Test
    public void actions03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameIndex(0);
        Actions actions = new Actions(driver);

        WebElement dragBox = driver.findElement(By.id("draggable"));
        // WebElement dropBox= driver.findElement(By.id("droppable"));

        actions.clickAndHold(dragBox).moveByOffset(165,25).release().perform();
        bekle(2);


        //ÖDEV : Drag webelementinin drop webelementinin üzerine bırakıldığını test edin



    }
}
