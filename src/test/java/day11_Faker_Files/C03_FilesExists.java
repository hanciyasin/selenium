package day11_Faker_Files;

import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FilesExists extends TestBase {
    @Test
    public void test01() {
         /*
        Bilgisayarımızdaki bir dosyanın varlığını test edebilmemiz için;
            1-Öncelikle dosyanın yolunu almamız gerekir(Dosya üzerine sağ klik yapıp yol olarak kopyala seçeneği ile
            dosyanın yolunu kopyalayabiliriz. Windows'un alt sürümlerinde sağ klik yaptığınızda yol olarak kopyala
            seçeneği çıkmıyor ise shift tuşuna basılı olarak sağ klik yaparsanız yol olarak kopyala seçeneği çıkar)
            2-Files.exists(Paths.get(dosyaYolu)) Files class'ından exists() methodu ile dosya yolunun
            varlığını test edebiliriz. Yukarıdaki kod bize true veya false döner. Dolayısıyla
            bu kodu direk Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))) şeklinde yazarak
            dosya varsa testim passed yoksa failed olur
         */
        //MasaÜstünde bir dosya oluşturalım
        String dosyaYolu = "C:\\Users\\hanci\\Desktop\\B171.txt.txt";

        //Ve bu dosyanın varlığını doğrulayalım
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void test02() {
        /*
            Ortak çalışmalarda bir server üzerinden bir dosya yolu almak istersek, her kullanıcının bilgisayarının
        ana yolu farklı olabilir ve server daki dosyanın yolu ortaktır. Dolayısıyla System.getProperty(user.home)
        methodu ile bilgisayarımızın ana yolunu alabilir, server daki ortak yol ile bunu birleştirip dosyanın yolunu
        dinamik olarak alabiliriz
         */
        //Test01 methodundaki gibi dosyanın yolunu doğrulayalım

        //"C:\Users\hanci\Desktop\B171.txt.txt"
        String kendiAnaYolum = System.getProperty("user.home");
        String ortakYol = "\\Desktop\\B171.txt.txt";
        String yol = kendiAnaYolum+ortakYol;

        Assert.assertTrue(Files.exists(Paths.get(yol)));





    }
}
