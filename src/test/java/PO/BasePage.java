package PO;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class BasePage {
    private static Logger LOGGER = Logger.getLogger("Falabella");
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void waitForElementToAppear(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void waitForTextToDisappear(WebElement locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
    }
    protected  void waitForClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected boolean isVisible(WebElement webElement){
        boolean isVisible;
        try {
            isVisible = webElement.isDisplayed();
        }catch (NoSuchElementException e){
            isVisible=false;
        }
        return isVisible;
    }
    protected void waitFor(int segundos){
        try {
            Thread.sleep(segundos*1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void Log(String ms) {
        LOGGER.info(ms);
    }
}
