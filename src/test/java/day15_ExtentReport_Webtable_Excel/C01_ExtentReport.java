package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {

    @Test
    public void test01() {
        rapor("Chrome","Amazon Testi");
        extentTest=extentReport.createTest("Extend Test","Test Raporu");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        extentTest.info("Kullanici Amazon sayfasina gider");

        //Arama kutusunda iphone aratalim
         WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Kullanici arama kutusunun locate'ini alir");

        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        extentTest.info("Kullanici arama kutusunda iphone aratir");

        extentReport.flush();

    }
}
