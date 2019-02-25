package gmailCheckDeleteTest.pageElements;

import org.openqa.selenium.WebElement;

public class Input extends Element {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void sendKeysClear(String keys) {
        super.clear();
        super.sendKeys(keys);
    }
}
