package test_classes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    String URL = "https://www.tehnomanija.rs/";

    public void init(String browser,int time, String URL){
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.get(URL);
    }
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }
    public void takeScreenshot(String fileName) throws IOException, InterruptedException {
        Thread.sleep(1000);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file , new File("src/screenshots/"+fileName+".png"));
    }
    public String randomEmail(){
        Random random = new Random();
        int x = random.nextInt(1000);
        System.out.println("uros.spasic" + x + "@gmail.com");
        return "uros.spasic" + x + "@gmail.com";
    }
    public String randomName(){
        Random random = new Random();
        String[] name = {"Uros", "Nemanja", "Gvozden", "Bojan", "Petar", "Jovan"};
        int x = random.nextInt(6);
        System.out.println(name[x]);
        return name[x];
    }
    public String randomLastName(){
        Random random = new Random();
        String[] lastName = {"Spasic", "Lazic", "Moljkovic", "Aleksic", "Janjic"};
        int x = random.nextInt(5);
        System.out.println(lastName[x]);
        return lastName[x];
    }
    public String randomPassword(){
        Random random = new Random();
        int x = random.nextInt(99);
        return "Wabisuke" + x + "!";
    }
    public String randomPhone(){
        Random random = new Random();
        int x = random.nextInt(900) + 100;
        int y = random.nextInt(900) + 100;
        int z = random.nextInt(10);
        System.out.println("06" + z + "" + x + "" + y);
        return "06" + z + "" + x + "" + y;
    }
    public String randomDays(){
        Random random = new Random();
            int x = random.nextInt(31);
        return ""+ x;
    }
    public String randomMonths(){
        Random random = new Random();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int x = random.nextInt(12);
        return months[x];
    }
    public String randomYear(){
        Random random  = new Random();
        int low = 1921;
        int high = 2021;
        int result = random.nextInt(high-low) + low;
        return "" + result;
    }
    public String randomScreenShotName(){
        Random random  = new Random();
        int low = 1;
        int high = 10;
        int result = random.nextInt(high-low) + low;
        return "ScreenShot" + result;
    }
    public String randomStreetNumber(){
        Random random  = new Random();
        int low = 1;
        int high = 100;
        return "" + random.nextInt(high-low);
    }
    public String randomFloor(){
        Random random = new Random();
        int x = random.nextInt(15);
        return "" + x;
    }
    public String randomFlat(){
        Random random = new Random();
        int low = 1;
        int high = 50;
        return "" + random.nextInt(high-low);
    }
    public String randomHomeNumber(){
        Random random = new Random();
        int x = random.nextInt(900000) + 100000;
        return "0112" + x;
    }
    public String randomStreet(){
        Random random = new Random();
        String[] street = {"Luja Adamica", "Pohorska", "Goce Delceva", "Dzona Kenedija", "Kralja Aleksandra", "Francuska"};
        int x = random.nextInt(6);
        return street[x];
    }
}
