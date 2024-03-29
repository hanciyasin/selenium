package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();  //Bos bir browser acacak

        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");  //-->get() methodu gibi string olaran girilen url'e gider
        Thread.sleep(3000);  //-->Java dan gelen bekleme

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);  //-->Java dan gelen bekleme

        //Tekrar YouTube’sayfasina donelim
        driver.navigate().back();  //--> Sayfada geri dönme işlemi yapar
        Thread.sleep(3000);

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();  //--> Sayfada ileri gitme işlemi yapar
        Thread.sleep(3000);

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();  //--> Sayfayı yeniler
        Thread.sleep(3000);

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();


         /*
        navigate() methodları ile sayfada ileri geri yapmak isteyebiliriz back ve forward methodları ile
        bunu yapabiliriz. Bu methodları kullanırken get() yada navigate().to() methodu ile sayfaya gidebilirz.
         */
    }
}
