package gmailMainTest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmailCheckDeleteTest.businessObjects.GmailBusinessObject;
import gmailCheckDeleteTest.pageObject.GmailPageObject;
import gmailCheckDeleteTest.pageObject.LogginPageObject;
import gmailCheckDeleteTest.pageObject.WaitPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class StepDefinition {

    private static final Logger logger = LogManager.getLogger(GmailBusinessObject.class);

    @BeforeClass
    public void driverSetting() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    WebDriver driver = new ChromeDriver();
    LogginPageObject logginPageObject = new LogginPageObject(driver);
    GmailPageObject gmailPageObject = new GmailPageObject(driver);
    WaitPageObject waitPageObject = new WaitPageObject(driver);

    @Given("^I'm a Gmail user$")
    @When("^I have logging page in Gmail$")
    public void goToGmail() {
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com/");
    }

    @Then("^I enter \"(@gmail.com)\" and press button next$")
    public void enterLogin(String mail) {
        logginPageObject.login(mail);
        logginPageObject.loginNext();
        new WebDriverWait(driver, 35).until(dr -> dr.findElement(By.id("profileIdentifier")).getText().equalsIgnoreCase(mail));
    }

    @Then("^I enter password$")
    public void enterPassword(String password) {
        logginPageObject.password(password);
        //@When("^I enter password as \"(.*)\"$")
    }

    @And("^Press button Next for password$")
    public void pressButtonPasswordNext() {
        logginPageObject.passwordNext();
    }

    @When("^I have home page in Gmail$")
    public void homePage() {
        new WebDriverWait(driver, 35).until(dr -> dr.findElement(By.xpath("//img[@class='gb_0a']")).isDisplayed());
    }

    @Then("^I check 3 message as important$")
    public void checkImportantMessage() {
        gmailPageObject.checkImportans();
    }

    @Then("^I check 3 message using the CheckBox$")
    public void checkUsingCheckBox() {
        gmailPageObject.checkBox();
        new WebDriverWait(driver, 35).until(dr -> dr.findElement(By.xpath("//div[@role='button' and @act='10']")).isDisplayed());
    }

    @And("^Press button \"Delete\"$")
    public void deletingMessage() {
        gmailPageObject.deleteMessage();
    }
    @Then("^I check is messages is deleted$")
    public boolean isDeletingMessage() {
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
