package gmailCheckDeleteTest.businessObjects;

import gmailCheckDeleteTest.pageObject.LogginPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginBusinessObject {
    private LogginPageObject logginPageObject;
    private String threadName;
    private static final Logger logger = LogManager.getLogger(LoginBusinessObject.class);
    private WebDriver driver;

    public LoginBusinessObject(WebDriver driverChrome) {
        logginPageObject = new LogginPageObject(driverChrome);
        threadName = Thread.currentThread().getName();
        driver = driverChrome;
    }

    public void logIn(String email, String password) {
        logger.info("User log in success");
        logginPageObject.login(email);
        logginPageObject.loginNext();
        new WebDriverWait(driver, 35).until(dr -> dr.findElement(By.id("profileIdentifier")).getText().equalsIgnoreCase(email));
        logginPageObject.password(password);
        logginPageObject.passwordNext();
        new WebDriverWait(driver, 35).until(dr -> dr.findElement(By.xpath("//img[@class='gb_0a']")).isDisplayed());
    }
}
