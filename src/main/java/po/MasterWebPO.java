package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MasterWebPO {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Contrutor das variaveis padroes do projeto
     *
     * @param driver driver a ser inciado
     */
    public MasterWebPO(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,15);
    }



    /**
     * Realiza a abertura da url passa
     *
     * @param url url a ser acessada
     */
    public void setupUrl(String url){
        driver.get(url);
    }



}
