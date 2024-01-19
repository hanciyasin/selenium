package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        //Add Element butonuna basin
        WebElement addElement = driver.findElement(By.xpath("//*[text()='Add Element']"));
        addElement.click();
        Thread.sleep(2000);


        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete']")); //text yerine "." koyduk
        if (deleteButton.isDisplayed()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //Delete tusuna basin
        deleteButton.click();


        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYazi = driver.findElement(By.xpath("//*[.='Add/Remove Elements']")); // --> "//h3" kullanarakta bulabiliriz (sayfada baska h3 olmadigi icin)
        if (addRemoveYazi.isDisplayed()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //sayfayı kapatınız
        driver.close();


    }
}
