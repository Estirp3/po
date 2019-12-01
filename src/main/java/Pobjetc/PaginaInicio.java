package Pobjetc;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaInicio extends BasePage {
    public PaginaInicio (WebDriver driver){
        super(driver);
    }
    WebDriver driver;

    @FindBy(id = "searchQuestionSolr")
    WebElement buscador;

    @FindBy (xpath = "//div[contains(@class,'HamburgerIcon_hamburgerContain__1BOAJ')]")
    WebElement menuAmbuergesa;
    @FindBy(xpath = "//ul[contains(@class,'Menu-module_firstCategories__1v_O9')]//li[contains(@class,'FirstLevelItems_menuElementsDesktop__1sVQZ')]")
    WebElement producto;
    @FindBy (xpath = "//div[li[contains(@class,'ThirdLevelItems_listElements__ZcR7D')]]//a[contains(text(),'Smartphones')]")
    WebElement subProd;

    public void inicio(){
        Log("Se ingresa en fallabella");
        waitForElementToAppear(buscador);
        buscador.clear();
        waitFor(1);
        buscador.sendKeys("Pendrive Cruzer Blade 32GB");
        buscador.sendKeys(Keys.RETURN);
    }
    public void menuInicio(){
        Log("Se presiona menu inicial");
        waitForElementToAppear(menuAmbuergesa);
        menuAmbuergesa.click();
        waitForElementToAppear(producto);
        String prod = producto.getText();
        Log(prod);
        producto.click();
        waitForElementToAppear(subProd);
        String spro = subProd.getText();
        subProd.click();



    }


}
