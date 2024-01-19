package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tum class'tan once tek bir sefer calisir");
        System.out.println("***********************************************************");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her methoddan once 'before' bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test01 calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test02 calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test03 calisti");
    }

    @Test
    public void test04() {
        System.out.println("Test04 calisti");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methoddan sonra bir kere 'after' calisir");
        System.out.println("***********************************************************");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Tum class'dan sonra tek bir sefer calisir");
    }
    /*
    Bir class'da 4 tane test methodu 1 tane before 1 tane after methodu varsa class'ta kaç tane method çalışmıştır -->12 = 3 * 4
     */
}
