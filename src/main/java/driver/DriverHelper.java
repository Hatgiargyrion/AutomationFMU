package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {

    /**
     * Inicializa o driver
     *
     * @param browser browser a ser utilizado
     * @return retorna o driver com o driver do navegador instanciado
     */
    public WebDriver setupDriver(String browser, WebDriver driver){

        System.setProperty("webdriver.gecko.driver", "c:/autodrivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:/autodrivers/chromedriver.exe");

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
