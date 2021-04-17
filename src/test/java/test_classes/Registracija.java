package test_classes;

import listeners.AllureTestNGListener;
import org.testng.annotations.*;
import pom_classes.CommonPage;
import pom_classes.RegistrationPage;

import java.io.IOException;

@Listeners(AllureTestNGListener.class)
public class Registracija extends BaseTest{

    RegistrationPage registrationPage;
    CommonPage commonPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser){
        init(browser, 30, URL);
    }

    @AfterMethod
    public void testClose(){
        closeDriver();
    }

    @Test
    public void registracijaFizickogLica() throws IOException, InterruptedException {
        String email = randomEmail();
        String password = randomPassword();
        registrationPage = new RegistrationPage(driver);
        commonPage = new CommonPage(driver);

        commonPage.clickConfirmCookie();
        commonPage.moveToElementPrijava();
        commonPage.clickRegistrujSe();


        registrationPage.randomTitle();
        registrationPage.setIme(randomName());
        registrationPage.setPrezime(randomLastName());
        registrationPage.setEmail(email);
        registrationPage.setEmailConfimation(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.setPhoneNumber(randomPhone());
        registrationPage.clickKalendar();
        registrationPage.datumRodjenja(randomMonths(),randomYear(),randomDays());
        registrationPage.fillAdditionalInfo(randomStreet(), randomStreetNumber(),randomFloor(),randomFlat(),randomHomeNumber(), 1);
        registrationPage.clickTOS();
        registrationPage.clickReCaptcha();
        registrationPage.checkReCaptcha();

        takeScreenshot(randomScreenShotName());
    }
}
