package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);


        //Arama Kutusuna Java yazdiralim
        driver.findElement(By.xpath("//*[@id='searchHeaderInput']")).sendKeys("Java");

    }
}
