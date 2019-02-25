package gmailMainTest;

import com.opencsv.CSVReader;
import gmailCheckDeleteTest.businessObjects.GmailBusinessObject;
import gmailCheckDeleteTest.businessObjects.LoginBusinessObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGmailCheckDeleteOperations {

    @BeforeClass
    public void driverSetting() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @Test(dataProvider = "user-data")
    public void gmailEnterTest(String login, String password) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com/");
        LoginBusinessObject loginBusinessObject = new LoginBusinessObject(driver);
        loginBusinessObject.logIn(login, password);

        GmailBusinessObject gmailBusinessObject = new GmailBusinessObject(driver);
        gmailBusinessObject.emailImportant();
        gmailBusinessObject.emailCheckBox();
        gmailBusinessObject.emailDelete();

        Assert.assertTrue(gmailBusinessObject.isMessagesDelete());
        driver.quit();
    }

    @DataProvider(name = "user-data", parallel = true)
    public Object[][] loginData() {
        String csvFile = "src/test/resources/users.csv";
        List<Object[]> list = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[list.size()][];

        return list.toArray(data);
    }
}