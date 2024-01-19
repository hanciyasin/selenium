package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class C02_FakerTest extends TestBase {
    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        Faker faker = new Faker();

        //“firstName” giris kutusuna bir isim yazin
        //“lastname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        String fakeMail = faker.internet().emailAddress();
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,fakeMail);
        bekle(2);
        firstName.sendKeys(     Keys.TAB,Keys.TAB,Keys.TAB,fakeMail,Keys.TAB,faker.internet().password(),
                Keys.TAB, Keys.TAB,"25",Keys.TAB,"May",Keys.TAB,"2001",Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT,Keys.ENTER);
        bekle(5);

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@type='radio'])[2]")).isSelected());

    }
}
