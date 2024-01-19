package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git  “Account” secenegine tikla
        WebElement acountList = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(acountList).perform();//-->Mouse'u Locate ettiğimiz webelementin üzerine götürdük
        bekle(2);
        driver.findElement(By.xpath("//span[.='Account']")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertEquals("Your Account",driver.getTitle());

    }
}
