package day15_ExtentReport_Webtable_Excel;

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WebTable extends TestBase {
    /*
        Eğer bir sayfada içinde dataların bulunduğu bir tablo ile karşılaşırsak;
           1-<table> tag'ı ile başlıyorsa bu tag bize tüm tabloyu verir. xpath ile //table yazarak
           sayfada kaç tane tablo olduğunu tespit eder birden fazla tablo varsa (//table)[index] ile
           istediğimiz tabloyu bu şekilde locate edip getText() methodu ile yazdırabiliriz.

           2-<thead> table tag'ından sonra bu tag var ise, tablodaki başlıkları thead tag'ı ile alabiliriz
           <thead> tag'îndan sonra <tr>(table row) tag'ı başlıktaki satır'ı, <th> tag'i ise başlıktaki
           her bir hücreyi temsil eder.

           3-<tbody> thead tag'ından sonra tbody tag'ı ile tablodaki başlık altındaki verileri alabiliriz.
           tbody tag'ından sonra <tr> tag'i body içindeki satırları, <td> tag'ı ise body içindeki hücreleri
           temsil eder.
     */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println(table1.getText());

        System.out.println("------------------------------------------------------------------------------------------");

        //Task 2 : 3. Row’(satır) datalarını print edin
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[3]"));
        System.out.println("Ucuncu Satir Verileri : "+ucuncuSatir.getText());

        //Task 3 : Son row daki dataları print edin
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        /*
            Xpath kullanımında eğer bir webtable'da son satır bilgisi istenirse yukarıdaki örnekteki gibi
        satır içindeki index yerine last() function'ı kullanabilirisiniz
         */
        System.out.println("Son Satir Verileri : " + sonSatir.getText());
        System.out.println("------------------------------------------------------------------------------------------");

        //Task 4 : 5. Column(sütun) datalarini print edin
        WebElement besinciSutunBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("Besinci Sutun Basligi = " + besinciSutunBaslik.getText());

        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(e-> System.out.println(e.getText()));

        System.out.println("------------------------------------------------------------------------------------------");

        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

        printData(4,5);

        List<WebElement> sutunOrnek = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position() >= 1 and position() <= 2]"));
        sutunOrnek.forEach(e-> System.out.println(e.getText()));




    }

    private void printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());

    }

     /*
    ÖDEV:
        3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız. //-->position()>=1 and position()<=2
     */
}
