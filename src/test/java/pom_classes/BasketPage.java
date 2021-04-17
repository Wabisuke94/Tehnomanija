package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage extends CommonPage{
    WebDriver driver;

    public BasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name=\"order[first_name]\"]")
    WebElement firstName;
    @FindBy(xpath = "//input[@name=\"order[last_name]\"]")
    WebElement lastName;
    @FindBy(xpath = "//input[@name=\"order[email]\"]")
    WebElement email;
    @FindBy(xpath = "//input[@name=\"order[mobile]\"]")
    WebElement mobileNumber;
    @FindBy(xpath = "//input[@name=\"order[street_number]\"]")
    WebElement streetNumber;
    @FindBy(xpath = "//input[@name=\"order[street]\"]")
    WebElement street;
    @FindBy(xpath = "//input[@name=\"order[floor]\"]")
    WebElement floorNumber;
    @FindBy(xpath = "//input[@name=\"order[flat]\"]")
    WebElement flatNumber;
    @FindBy(xpath = "//div[@class=\"recaptcha-checkbox-border\"]")
    WebElement reCaptcha;
    @FindBy(xpath = "//iframe[starts-with(@name, 'a-')and starts-with(@src, 'https://www.google.com/recaptcha')]")
    WebElement iFrame;
    @FindBy(xpath = "//input[@name=\"order[accept_terms]\"]")
    WebElement termsOfService;
    @FindBy(xpath = "//div[@class=\"price js-gross\"]")
    WebElement totalPrice;
    @FindBy(xpath = "//textarea[@name=\"order[notes]\"]")
    WebElement notes;
    @FindBy(xpath = "//input[@class=\"basket\"]")
    WebElement checkOut;
    @FindBy(xpath = "//div[@class=\"search-result\"]")
    List<WebElement> streetList;

    public void setFirstName(String string){
        typeText(firstName, string);
    }

    public void setLastName(String string){
        typeText(lastName, string);
    }

    public void setEmail(String string){
        typeText(email, string);
    }

    public void setMobileNumber(String string){
        typeText(mobileNumber, string);
    }

    public void setStreet(String string) throws InterruptedException {
        typeText(street, string);
        Thread.sleep(300);
    }

    public void setStreetNumber(String string){
        typeText(streetNumber,string);
    }

    public void pickStreet(int indexToSelect) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        if(indexToSelect<streetList.size()) {
            wait.until(ExpectedConditions.visibilityOf(streetList.get(indexToSelect)));
            streetList.get(indexToSelect).click();
        }
        else {
            int i = --indexToSelect;
            streetList.get(i).click();
        }
    }

    public void setFlatNumber(String string){
        typeText(flatNumber, string);
    }

    public void setFloorNumber(String string){
        typeText(floorNumber, string);
    }

    public void setNotes(String string){
        typeText(notes, string);
    }

    public void fillShippingInfo(String a, String b, String c, String d, String e, int i, String f, String g, String h, String k) throws InterruptedException {
        setFirstName(a);
        setLastName(b);
        setEmail(c);
        setMobileNumber(d);
        setStreet(e);
        pickStreet(i);
        setStreetNumber(f);
        setFlatNumber(g);
        setFloorNumber(h);
        setNotes(k);
    }

    public void clickReCaptcha(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        wait.until(ExpectedConditions.elementToBeClickable(reCaptcha));
        reCaptcha.click();
    }

    public void checkReCaptcha(){
        reCaptchaChecked.getAttribute("style");
        if(reCaptchaChecked.getAttribute("style").equals("none")){
            checkOut.click();
        }
        else{
            System.out.println("Kraj Testa");
        }
    }

    public void clickTermsOfService(){
        termsOfService.click();
    }

    public String getTotalPrice(){
        return totalPrice.getText().replace(",00 RSD"," ");
    }
}
