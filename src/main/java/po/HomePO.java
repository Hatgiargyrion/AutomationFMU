package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Classe que armazena variaveis e metodos da PO Home
 *
 * @author Matheus Santos
 */
public class HomePO extends MasterWebPO {

    @FindBy(xpath = "//div[@class='acesso-rapido-item-title']/span[contains(.,'Blackboard')]")
    WebElement btnBlackboard;

    @FindBy(id = "anonymous_element_6")
    WebElement lblMinhasDisciplinas;


    /**
     * Contrutor das variaveis padroes do projeto
     *
     * @param driver driver a ser inciado
     */
    public HomePO(WebDriver driver) {
        super(driver);
    }

    /**
     * Realizar acesso a opção blackboard
     */
    public BlackboardPO acessarBlackboard(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(btnBlackboard)).click();
        return new BlackboardPO(driver);
    }
}
