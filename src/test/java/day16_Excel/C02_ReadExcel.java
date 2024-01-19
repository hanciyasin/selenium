package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {
    @Test
    public void test01() throws IOException {
        //BlurentalCar sitesine gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalim
        driver.findElement(By.xpath("(//a)[1]")).click();

        //Excel dosyasındaki herhangi bir kullanıcı ile login olalim
        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        String username = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String pass = workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement input = driver.findElement(By.xpath("//input[@name='email']"));
        input.sendKeys(username, Keys.TAB,pass,Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        driver.findElement(By.id("dropdown-basic-button")).click();
        driver.findElement(By.xpath("//*[@href='/profile']")).click();
        String emailTxt = driver.findElement(By.xpath("//em")).getText();
        Assert.assertEquals(emailTxt,username);


    }
}
