package TesT;



import Pobjetc.BasePage;
import Pobjetc.PaginaInicio;
import Pobjetc.ProductoPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestInicio {
    WebDriver driver;


    PaginaInicio pa;
    ProductoPO prod;
    BasePage base;

    /**
     * Inicio de pruebas
     */
    @Before
    public void inicio(){
        BasicConfigurator.configure();// log4g

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.falabella.com/falabella-cl/");


        this.pa = new PaginaInicio(this.driver);
        this.prod = new ProductoPO(driver);
        this.base = new BasePage(driver);
    }



    @Test
    public void test_01() {
      pa.inicio();
      prod.BuscarProducto();
      prod.valores();
      prod.carro();
    }

    @Test
    public void Test_02(){
        pa.menuInicio();
        prod.BuscarProducto();
        prod.valores();
        prod.carroObsiones();

    }

    @After
    public void cerrar(){
        driver.close();
    }
}
