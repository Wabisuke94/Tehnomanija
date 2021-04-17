package pom_classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonPage {
    WebDriver driver;
    int WAIT = 30;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class=\"user-name\"]")
    WebElement prijava;
    @FindBy(xpath = "//div[@class=\"register-links-wrap\"]/a[contains(@href, 'register')]")
    WebElement registrujSe;
    @FindBy(xpath = "//div[@class=\"category-menu js-category-menu\"]")
    WebElement hamburgerMenu;
    @FindBy(xpath = "//div[@class=\"js-category-menu-wrap category-menu-item0 first-level dropdown-menu\"]/div[7]/a")
    WebElement itShop;
    @FindBy(xpath = "//a[@title=\"Svi laptopovi\"]")
    WebElement sviLaptopovi;
    @FindBy(xpath = "//div[@class=\"basket-header js-basket-header\"]")
    WebElement basket;
    @FindBy(xpath = "//a[@class=\"cookie-agree fnc-accept-cookies\"]")
    WebElement cookies;
    @FindBy(xpath = "//div[@class=\"recaptcha-checkbox-border\"]")
    WebElement reCaptchaChecked;

    public void clickConfirmCookie(){
        clickElement(cookies);
    }

    public void moveToElementPrijava(){
        Actions actions = new Actions(driver);
        actions.moveToElement(prijava).build().perform();
    }
    public void clickRegistrujSe(){
        clickElement(registrujSe);
    }
    public void openItShop(){
        Actions actions = new Actions(driver);
        actions.moveToElement(hamburgerMenu).moveToElement(itShop).build().perform();
    }
    public void clickBasket(){
        clickElement(basket);
    }
    public void clickSviLaptopovi(){
        clickElement(sviLaptopovi);
    }
    public void clickElement(WebElement element){
            WebDriverWait wait = new WebDriverWait(driver, WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
    }
    public void typeText(WebElement element, String text){
        try{
            WebDriverWait wait = new WebDriverWait(driver,WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void checkTextInElement(String element, String element2) {
        Assert.assertEquals(element, element2);
    }

    public void scrollBy(int x, int y) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        int scrollIterationX = x/200;
        int scrollIterationY = y/200;
        int scrollIterations = scrollIterationX >= scrollIterationY ? scrollIterationX : scrollIterationY;
        for(int i = 1; i<=scrollIterations; i++){
            int moveX = i <= scrollIterationX ? 200 : 0;
            int moveY = i <= scrollIterationY ? 200 : 0;
            jse.executeScript(String.format("window.scrollBy(%d, %d)",moveX,moveY),"");
            Thread.sleep(100);

        }
        int lefoverX = x-(200*scrollIterationX);
        int lefoverY = y-(200*scrollIterationY);
        jse.executeScript(String.format("window.scrollBy(%d, %d)",lefoverX, lefoverY),"");

    }

}
