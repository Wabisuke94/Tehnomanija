package selenium_core;



public class DriverManagerFactory {

    public static  DriverManager getDriverManager(String driverType){
        DriverManager driverManager = null;
        switch (driverType){
            case "OPERA":{
                driverManager = new OperaDriverManager();
            }break;
            case "CHROME":{
                driverManager = new ChromeDriverManager();
            }break;
            case "FIREFOX":{
                driverManager = new FirefoxDriverManager();
            }break;
        }
        return driverManager;
    }
}
