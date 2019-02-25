package gmailCheckDeleteTest.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gmailCheckDeleteTest.pageElements.Input;

public class LogginPageObject {
    @FindBy(name = "identifier")
    private WebElement elementMail;
    //private Input elementMail;

    @FindBy(id = "identifierNext")
    private WebElement buttonNext;

    @FindBy(name = "password")
    private WebElement elementPassword;

    @FindBy(id = "passwordNext")
    private WebElement buttonPasswordNext;

    public LogginPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String login) {
        elementMail.sendKeys(login);
        //elementMail.sendKeysClear(login);
    }

    public void loginNext() {
        buttonNext.click();
    }

    public void password(String password) {
        elementPassword.sendKeys(password);
    }

    public void passwordNext() {
        buttonPasswordNext.click();
    }
}
