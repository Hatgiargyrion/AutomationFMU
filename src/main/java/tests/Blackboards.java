package tests;

import driver.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import po.LoginPO;
import po.TeoriaDeSistemasPO;


public class Blackboards {

    private WebDriver driver;
    private WebDriverWait wait;
    private Assertion assertion = new Assertion();

    @BeforeMethod
    public void setUp(@Optional("firefox") String browser){
        this.driver = new DriverHelper().setupDriver(browser,driver);
        this.wait = new WebDriverWait(driver, 10);
    }


    @Test
    @Parameters({"url","email","password"})
    public void marcarPresencaTSI(@Optional("https://portal.fmu.br/") String url,
                      @Optional("2599000@fmu.edu.br") String email,
                      @Optional("Liberdade15") String password){
        TeoriaDeSistemasPO TeoriaDeSistemasPO = new LoginPO(driver)
                .realizarLogin(email,password,url)
                .acessarBlackboard()
                .acessarDisciplina()
                .confirmarPresenca();
        assertion.assertEquals(wait.until(ExpectedConditions.visibilityOf(TeoriaDeSistemasPO
                .lblCurso)).isDisplayed(),true,"Diciplina TSI acessada com sucesso");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


}
