package selenium_core;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaDriverManager extends DriverManager{

    @Override
    public void createDriver() {
        System.setProperty("webdriver.opera.driver","src/main/resources/operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.addArguments("start-maximized");
        this.driver = new OperaDriver(options);
    }
}
