package day15_ExtentReport_Webtable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.SheetBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel {
    @Test
    public void test01() throws IOException {
        /*
            Eğer projemizde excel dosyasından veri almak istiyorsak öncelikle mvnrepository.com adresinden arama çubuğuna
        poi yazarak apache poi ve poi_ooxml dependency'lerini pom.xml dosyamıza kopyalamamız gerekir. Her iki dependency
        nin de versiyonları aynı olmalı.
         */

        //1- Projemize resources package'ı altına koyduğumuz excel dosyamızın yolunu alırız
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        //2- Dosyayı okuyabilmemiz için javada akışa almamız gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3- Java ortamında bir excel dosyası oluşturabilmek için
        Workbook workbook = WorkbookFactory.create(fis);

        //4- Oluşturduğumuz excel dosyasında sayfa seçmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5- Belirttiğimiz sayfadaki satır bilgisini seçmemiz gerekir
        Row row = sheet.getRow(0);

        //6- Belirttiğimiz satırdaki hücre bilgisini seçmemiz gerekir
        Cell cell = row.getCell(0);

        //Sout içinde cell bilgisini yazdırdığımızda 1. satır 1. hücredeki bilgiyi verir
        System.out.println(cell);  // --> COUNTRY

         /*
        NOT: Excel dosyanız açıkken işlem yapmayınız
            Excel dosyasında herhangi bir hücrede değişiklik yaptıysanız excel'i kapatırken kaydetmeyiniz
         */

    }

    @Test
    public void test02() throws IOException {
        //***Pratic Çözüm
        //1. Satir ve 1. Sütun bilgisini yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

    }

}
