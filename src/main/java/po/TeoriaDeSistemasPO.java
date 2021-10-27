package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena variaveis e metodos da PO Teoria de Sistemas
 *
 * @author Matheus Santos
 */

public class TeoriaDeSistemasPO extends MasterWebPO {

    @FindBy(id = "courseLink_762657_1")
    public WebElement btnTeoriaDeSistemas;

    @FindBy(xpath = "//ul[@id='module-list-_18514758_1']/li/a/i")
    public List<WebElement> btnPresenca;

    @FindBy(xpath = "//h1[contains(.,Teoria)]")
    public WebElement lblCurso;

    /**
     * Contrutor das variaveis padroes do projeto
     *
     * @param driver driver a ser inciado
     */
    public TeoriaDeSistemasPO(WebDriver driver) {
        super(driver);
    }

    public TeoriaDeSistemasPO confirmarPresenca() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTeoriaDeSistemas)).click();

        for(int i=0;i<btnPresenca.size();i++){
            btnPresenca.get(i).click();
        }
        //for(WebElement element:btnPresenca){
        //    element.click();
        //}
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        wait.until(ExpectedConditions.visibilityOf(lblCurso));
        return this;
    }
}
