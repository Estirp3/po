package Pobjetc;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductoPO extends BasePage {
    public ProductoPO (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class,'fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn')]")
    WebElement contenedor;

    @FindBy (xpath = "//div[contains(@class,'fb-inline-dropdown__link')]//span[contains(text(),'Por Favor Selecciona')]")
    WebElement seleccion;
    @FindBy (xpath = "//a[contains(text(),'Liberado')]")
    WebElement seleccionL;
    @FindBy (xpath = "//button[contains(@class,'fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn')]")
    WebElement carroCompraOp;


    @FindBy(xpath = "//img[contains(@id,'testId-pod-image')]")
    WebElement producto;

    @FindBy (xpath = "(//div[contains(@class,'fb-price-list fb-product-cta__prices')]//p)[1]")
    WebElement precio;
    @FindBy(xpath = "//button[contains(@class,'fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn')]")
    WebElement CarroCompra;
    @FindBy (xpath = "(//div[contains(@class,'fb-added-to-basket__product')])[2]")
    WebElement penPUp;

    public void BuscarProducto(){

        Log("Se verifica si existe producto");
        if(isVisible(producto)){
            Log("El producto es visible");
            producto.click();
        }else {
            Log("El producto no es visible - verificar si existe en la pagina ");
        }
    }

    public void valores(){
        waitForElementToAppear(precio);
        String Valores = precio.getText();
        Log( "el precios es : " + Valores);
    }
    public void carro(){
        waitForElementToAppear(CarroCompra);
        waitFor(1);
        CarroCompra.click();
        if(isVisible(penPUp))
        {
            Log("El prodcuto sera agregado a el carro");
            //
            String Valores = precio.getText();
            Log(Valores);
            Assert.assertEquals(Valores,"$ 4.990 (Oferta)");
        }
    }

    public void carroObsiones(){
        waitForElementToAppear(seleccion);
        seleccion.click();
        waitForElementToAppear(seleccionL);
        seleccionL.click();
        waitFor(1);
        waitFor(1);
        waitForElementToAppear(carroCompraOp);
        carroCompraOp.click();
        if(isVisible(penPUp))
        {
            Log("El prodcuto sera agregado a el carro");
            //
            String Valores = precio.getText();
            Log(Valores);
            Assert.assertEquals(Valores,"$ 359.990");
        }
    }
}
