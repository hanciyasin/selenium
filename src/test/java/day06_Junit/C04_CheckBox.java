package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {
      /*
    Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        Checkbox1 ve checkbox2 elementlerini locate edin.
        Checkbox1 seçili değilse onay kutusunu tıklayın
        Checkbox2 seçili değilse onay kutusunu tıklayın
     */
    WebDriver driver;

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBox() throws InterruptedException {
        //Checkbox1 ve checkbox2 elementlerini locate edin.
       WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
       WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
       Thread.sleep(2000);

        //Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){ //-->Seçili değilse
            checkBox1.click();
        }
        Thread.sleep(2000);

        //Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){ //-->Seçili değilse
            checkBox2.click();
        }

    }

}
