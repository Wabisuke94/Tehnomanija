package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaptopPage extends CommonPage {
    WebDriver driver;

    public LaptopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"mCSB_2_container\"]/li")
    List<WebElement> listaProizvodjaca;
    @FindBy(xpath = "//div[@class=\"sort-products js-show-sort\"]")
    WebElement sortBy;
    @FindBy(xpath = "//div[@class=\"sort-products js-show-sort\"]/div[@class=\"sort-select\"]/div")
    List<WebElement> sortByList;
    @FindBy(xpath = "//div[@class=\"products-wrap\"]//a[@class=\"basket grid fnc-add-to-basket\"]")
    List<WebElement> products;
    @FindBy(xpath = "//div[@class=\"products-wrap\"]//a[@class=\"basket grid fnc-add-to-basket\"]/ancestor-or-self::div/div[@class=\"price-wrap-grid\"]//div[@class=\"price\"]")
    List<WebElement> productPrice;
    @FindBy(xpath = "//div[@id=\"price_range\"]/a[1]")
    WebElement slider1;


    public void clickOnManufacturer(int i) {
        if(listaProizvodjaca ==null || i >= listaProizvodjaca.size()){
            return;
        }

        listaProizvodjaca.get(i).click();
    }

    public void clickSortyBy() {
        clickElement(sortBy);
    }

    public void clickOnSortByList(int i) {
        if(sortByList ==null || i >= sortByList.size()){
            return;
        }

        sortByList.get(i).click();
    }

    public void clickOnProduct(int i) {
        if(products ==null || i >= products.size()){
             return;
         }

        products.get(i).click();
    }

    public String getProductPrice(int i) {
        if(products ==null || i >= products.size()){
            return "Out of scope";
        }

        return productPrice.get(i).getText().replace("RSD","");
    }

    public void moveSlider1(){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider1,30,0).build().perform();
    }
}
