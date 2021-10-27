package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

/**
 * Classe que armazena variaveis e metodos da PO Login
 *
 * @author Matheus Santos
 */
public class LoginPO extends MasterWebPO {

    @FindBy(xpath = "//div[@class='form-group']/input[@type='text']")
    WebElement fieldEmail;

    @FindBy(xpath = "//div[@class='form-group']/input[@type='password']")
    WebElement fieldSenha;

    @FindBy(xpath = "//button[contains(.,'ENTRAR')]")
    WebElement btnEntrar;

    @FindBy(xpath = "//span[contains(.,'Bem vindo')]")
    WebElement lblBemVindo;

    @FindBy(linkText = "Aluno")
    WebElement lblAluno;

    @FindBy(linkText = "Área do Aluno - Presencial")
    WebElement lblAreaDoAluno;

    @FindBy(xpath = "//label[contains(.,'E-mail')]")
    WebElement lblEmail;


    /**
     * Contrutor das variaveis padroes do projeto
     *
     * @param driver driver a ser inciado
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public HomePO realizarLogin(String email, String senha, String url){
        setupUrl(url);
        wait.until(ExpectedConditions.visibilityOf(lblAluno));
        wait.until(ExpectedConditions.elementToBeClickable(lblAluno)).click();
        wait.until(ExpectedConditions.visibilityOf(lblAreaDoAluno));
        wait.until(ExpectedConditions.elementToBeClickable(lblAreaDoAluno)).click();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        wait.until(ExpectedConditions.visibilityOf(lblEmail));
        wait.until(ExpectedConditions.elementToBeClickable(fieldEmail)).click();
        fieldEmail.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(fieldSenha)).click();
        fieldSenha.sendKeys(senha);
        wait.until(ExpectedConditions.elementToBeClickable(btnEntrar)).click();
        wait.until(ExpectedConditions.visibilityOf(lblBemVindo));
        return new HomePO(driver);
    }


}
