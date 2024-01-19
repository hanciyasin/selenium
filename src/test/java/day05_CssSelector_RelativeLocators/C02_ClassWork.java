package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        WebElement signInButton = driver.findElement(By.cssSelector("button[id='signin_button']"));
        signInButton.click();


        //Login alanine  “username” yazdirin
        //Password alanine “password” yazdirin
        //Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input[type='text']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();


        //Online Banking altındaki Pay Bills sayfasina gidin
        WebElement onlineBanking = driver.findElement(By.cssSelector("li[id='onlineBankingMenu']"));
        onlineBanking.click();
        Thread.sleep(2000);

        WebElement payBills = driver.findElement(By.cssSelector("span[id='pay_bills_link']"));
        payBills.click();
        Thread.sleep(2000);

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina “2020-09-10” yazdirin
        //Pay buttonuna tiklayin
        WebElement amount = driver.findElement(By.cssSelector("input[name='amount']"));
        amount.sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(3000);


        //“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesage = driver.findElement(By.cssSelector("div[id='alert_content']"));
        String actualMesage = mesage.getText();
        System.out.println(actualMesage);

        String expectedMesage = "The payment was successfully submitted.";

        if (actualMesage.equals(expectedMesage)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //sayfayı kapatınız
        driver.close();

    }
}
