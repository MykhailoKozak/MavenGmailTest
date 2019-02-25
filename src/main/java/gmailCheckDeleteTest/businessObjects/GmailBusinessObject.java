package gmailCheckDeleteTest.businessObjects;

import gmailCheckDeleteTest.pageObject.GmailPageObject;
import gmailCheckDeleteTest.pageObject.WaitPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailBusinessObject {
    private String threadName;
    private GmailPageObject gmailPageObject;
    private WaitPageObject waitPageObject;
    private static final Logger logger = LogManager.getLogger(GmailBusinessObject.class);
    private WebDriver driver;

    public GmailBusinessObject(WebDriver driverChrome) {
        gmailPageObject = new GmailPageObject(driverChrome);
        waitPageObject = new WaitPageObject(driverChrome);
        threadName = Thread.currentThread().getName();
        driver = driverChrome;
    }

    public void emailImportant() {
        logger.info("Check important emails");
        gmailPageObject.checkImportans();
    }

    public void emailCheckBox() {
        logger.info("Check 3 emails");
        gmailPageObject.checkBox();
        new WebDriverWait(driver, 35).until(dr -> dr.findElement(By.xpath("//div[@role='button' and @act='10']")).isDisplayed());
    }

    public void emailDelete() {
        logger.info("Deleting 3 emails");
        gmailPageObject.deleteMessage();
    }

    public boolean isMessagesDelete() {
        logger.info("Check: is message is delete");
        boolean isDelete = false;
        if (waitPageObject.isMessageDelete(driver)) {
            logger.info("Message is delete");
            isDelete = true;
        } else {
            logger.info("Message isn't delete");
            isDelete = false;
        }
        return isDelete;
    }
}
