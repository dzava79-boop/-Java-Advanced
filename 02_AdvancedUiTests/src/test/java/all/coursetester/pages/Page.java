package all.coursetester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String subUrl;

    public Page(WebDriver driver, WebDriverWait wait, String subUrl) {
        this.driver = driver;
        this.wait = wait;
        this.subUrl = subUrl;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://qa.skillbox.ru/module16/" + subUrl);
    }
}


