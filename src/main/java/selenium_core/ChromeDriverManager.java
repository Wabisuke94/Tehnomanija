package selenium_core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{

    @Override
    protected void createDriver() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver(options);
    }
}
