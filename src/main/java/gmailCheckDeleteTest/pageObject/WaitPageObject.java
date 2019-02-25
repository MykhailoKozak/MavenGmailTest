package gmailCheckDeleteTest.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaitPageObject {

    @FindBy(xpath = "//span[@class='aT']//span[@class='bAq']")
    private WebElement mgisDelete;

    public WaitPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMessageDelete(WebDriver driver) {
        boolean isDelete = false;
        isDelete = mgisDelete.isDisplayed();
        return isDelete;
    }
}
