package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Random;

public class RegistrationPage extends CommonPage{

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='customer[date_of_birth]']")
    WebElement kalendar;
    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    WebElement mesecRodjenja;
    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    WebElement godinaRodjenja;
    @FindBy(xpath = "//input[@id='title0']")
    WebElement nistaOdNavedenog;
    @FindBy(xpath = "//input[@id='title1']")
    WebElement gospodja;
    @FindBy(css = "#title2")
    WebElement gospodin;
    @FindBy(xpath = "//input[@name='customer[first_name]']")
    WebElement ime;
    @FindBy(xpath = "//input[@name='customer[last_name]']")
    WebElement prezime;
    @FindBy(xpath = "//input[@name='customer[email]']")
    WebElement email;
    @FindBy(xpath = "//input[@name='customer[confirm_email]']")
    WebElement confirmEmail;
    @FindBy(xpath = "//input[@id='customer[password]']")
    WebElement password;
    @FindBy(xpath = "//input[@id='customer[confirm_password]']")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@id='customer[mobile]']")
    WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='accept_terms']")
    WebElement acceptTerms;
    @FindBy(xpath = "//iframe[starts-with(@name, 'a-')and starts-with(@src, 'https://www.google.com/recaptcha')]")
    WebElement iFrame;
    @FindBy(xpath = "//*[@id='recaptcha-anchor']/div[1]")
    WebElement reCaptcha;
    @FindBy(xpath = "//li[@class='one-column']//input[@class='btn register-btn basket']")
    WebElement registracija;
    @FindBy(xpath = "//input[@name='customer[street]']")
    WebElement street;
    @FindBy(xpath = "//input[@name='customer[street_number]']")
    WebElement streetNumber;
    @FindBy(xpath = "//input[@name='customer[floor]']")
    WebElement floorNumber;
    @FindBy(xpath = "//input[@name='customer[flat]']")
    WebElement appartmentNumber;
    @FindBy(xpath = "//input[@name='customer[phone]']")
    WebElement homenumber;
    @FindBy(xpath = "//div[@id='mCSB_1_container']//div[@class='search-result']")
    List<WebElement> pickStreet;
    @FindBy(xpath = "//form[@class='wrapped']")
    WebElement form;


    public void clickNistaOdNavedenog(){
        nistaOdNavedenog.click();
    }

    public void clickGospodja(){
        gospodja.click();
    }

    public void clickGospodin(){
        gospodin.click();
    }

    public void randomTitle(){
        Random random = new Random();
        int low = 1;
        int high = 3;
        int x = random.nextInt(high-low)+low;
        switch (x){
            case 1:{
                clickNistaOdNavedenog();
            }break;
            case 2:{
                clickGospodja();
            }break;
            case 3:{
                clickGospodin();
            }break;
        }
    }

    public void setIme(String string){
        typeText(ime,string);
    }

    public void setPrezime(String string){
        typeText(prezime,string);
    }

    public void setPassword(String string){
        typeText(password,string);
    }

    public void setConfirmPassword(String string){
        typeText(confirmPassword,string);
    }

    public void setEmail(String string){
        typeText(email,string);
    }

    public void setEmailConfimation(String string){
        typeText(confirmEmail,string);
    }

    public void setPhoneNumber(String string){
        typeText(phoneNumber,string);
    }

    public void clickKalendar(){
        clickElement(kalendar);
    }

    public void danRodjenja(String day) throws InterruptedException {
        WebElement calendar = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//tbody"));
        List<WebElement> dani = calendar.findElements(By.tagName("td"));
        for(WebElement dan: dani) {
            if(dan.getText().equals(day)){
                Thread.sleep(100);
                dan.click();
                break;
            }
        }

    }

    public void clickMesecRodjenja(String mesec) throws InterruptedException {
        Select select = new Select(mesecRodjenja);
        select.selectByVisibleText(mesec);
        Thread.sleep(500);
    }

    public void clickGodinaRodjenja(String godina) throws InterruptedException {
        Select select = new Select(godinaRodjenja);
        select.selectByVisibleText(godina);
        Thread.sleep(500);
    }

    public void datumRodjenja(String x, String y, String z) throws InterruptedException {
        clickMesecRodjenja(x);
        clickGodinaRodjenja(y);
        danRodjenja(z);
    }

    public void setStreet(String string) throws InterruptedException {
        typeText(street,string);
        Thread.sleep(300);
    }

    public void pickStreet(int indexToSelect) {

        WebDriverWait wait = new WebDriverWait(driver,30);
            if (indexToSelect < pickStreet.size()) {
                wait.until(ExpectedConditions.visibilityOf(pickStreet.get(indexToSelect)));
                pickStreet.get(indexToSelect).click();
            } else {
                int i = --indexToSelect;
                pickStreet.get(i).click();
            }
    }

    public void setStreetNumber(String string){
        typeText(streetNumber,string);
    }

    public void setFloorNumber(String string){
        typeText(floorNumber,string);
    }

    public void setAppartmentNumber(String string){
        typeText(appartmentNumber,string);
    }

    public void setHomeNumber(String string){
        typeText(homenumber,string);
    }

    public void fillAdditionalInfo(String a,String b,String c,String d,String g, int h) throws InterruptedException {
        setStreet(a);
        pickStreet(h);
        setStreetNumber(b);
        setFloorNumber(c);
        setAppartmentNumber(d);
        setHomeNumber(g);
    }

    public void clickTOS() throws InterruptedException {
        int formHeight = Integer.parseInt(form.getAttribute("scrollHeight"));
        this.scrollBy(0,formHeight);
        acceptTerms.click();
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
            registracija.click();
        }
        else{
            System.out.println("Kraj Testa");
        }
    }
}
