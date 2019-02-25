package gmailCheckDeleteTest.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailPageObject {

    @FindBy(xpath = "//span[@aria-label and @role='button']//following::td[@jscontroller]//div[@role]")
    private List<WebElement> importants;

    @FindBy(xpath = "//td[@class = 'oZ-x3 xY']//div[@role='checkbox']")
    private List<WebElement> checkBoxs;

    @FindBy(xpath = "//div[@role='button' and @act='10']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//span[@class='aT']//span[@class='bAq']")
    private WebElement mgisDelete;

    public GmailPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkImportans() {
        importants.stream()
                .limit(3)
                .forEach(importants -> importants.click());
    }

    public void checkBox() {
        checkBoxs.stream()
                .limit(3)
                .forEach(checkBoxs -> checkBoxs.click());
    }

    public void deleteMessage() {
        buttonDelete.click();
    }
}