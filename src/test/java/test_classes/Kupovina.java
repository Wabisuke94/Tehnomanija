package test_classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.BasketPage;
import pom_classes.CommonPage;
import pom_classes.LaptopPage;
import pom_classes.RegistrationPage;

import java.io.IOException;

public class Kupovina extends BaseTest{

    CommonPage commonPage;
    LaptopPage laptopPage;
    RegistrationPage registrationPage;
    BasketPage basketPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser){
        init(browser,30,URL);
    }
    @AfterMethod
    public void testClose(){
        closeDriver();
    }
    @Test
    public void KupovinaLaptopa() throws IOException, InterruptedException {
        commonPage = new CommonPage(driver);
        laptopPage = new LaptopPage(driver);
        registrationPage = new RegistrationPage(driver);
        basketPage = new BasketPage(driver);

        commonPage.clickConfirmCookie();
        commonPage.openItShop();
        commonPage.clickSviLaptopovi();


        laptopPage.moveSlider1();
        laptopPage.clickOnManufacturer(0);
        laptopPage.clickSortyBy();
        laptopPage.clickOnSortByList(1);
        String cena = laptopPage.getProductPrice(1);
        laptopPage.clickOnProduct(1);
        laptopPage.clickBasket();

        commonPage.checkTextInElement(basketPage.getTotalPrice(), cena);

        basketPage.fillShippingInfo(randomName(),randomLastName(),randomEmail(),randomPhone(), randomStreet(), 1, randomStreetNumber(),randomFlat(),randomFloor(), "Test");
        basketPage.clickTermsOfService();
        basketPage.clickReCaptcha();
        basketPage.checkReCaptcha();
        takeScreenshot(randomScreenShotName());


    }
}
