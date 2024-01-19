package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();  //Bos bir browser acacak

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin olculeri: " + driver.manage().window().getSize());
        System.out.println("Sayfanin konumu: " + driver.manage().window().getPosition());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanin maximize olculeri: " + driver.manage().window().getSize());
        System.out.println("Sayfanin maximize konumu: " + driver.manage().window().getPosition());
        Thread.sleep(3000);

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanin fullscreen olculeri: " + driver.manage().window().getSize());
        System.out.println("Sayfanin fullscreen konumu: " + driver.manage().window().getPosition());
        Thread.sleep(3000);

        //Sayfayi kapatin
        driver.close();


    }
}
