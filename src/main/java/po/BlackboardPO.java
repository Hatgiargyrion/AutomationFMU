package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Classe que armazena variaveis e metodos da PO Blackboard
 *
 * @author Matheus Santos
 */
public class BlackboardPO extends MasterWebPO {

    @FindBy(id = "anonymous_element_6")
    public WebElement lblMinhasDisciplinas;

    @FindBy(xpath = "//h1[contains(.,'Avaliação Institucional')]")
    public WebElement lblAvalicaoInstitucional;

    @FindBy(className = "close-icon")
    public WebElement btnClosePopUp;

    @FindBy(id = "agree_button")
    public WebElement btnAgreeCookies;

    @FindBy(className = "shepherd-cancel-link")
    public WebElement btnCloseTour;


    /**
     * Contrutor das variaveis padroes do projeto
     *
     * @param driver driver a ser inciado
     */
    public BlackboardPO(WebDriver driver) {
        super(driver);
    }

    public TeoriaDeSistemasPO acessarDisciplina() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAgreeCookies)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnCloseTour)).click();
        wait.until((ExpectedConditions.elementToBeClickable(btnClosePopUp))).click();
        return new TeoriaDeSistemasPO(driver);
    }
}
