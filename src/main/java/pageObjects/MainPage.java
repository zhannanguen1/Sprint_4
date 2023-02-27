package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final By FIRST_QUESTION = By.id("accordion__heading-0");
    private final By LAST_QUESTION = By.id("accordion__heading-7");
    private final By COOKIE_WINDOW = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");
    private final By ANSWER_TEXT_FIRST = By.id("accordion__panel-0");
    private final By ANSWER_TEXT_LAST = By.id("accordion__panel-7");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFirstQuestion() {
        driver.findElement(FIRST_QUESTION).click();
    }

    public String getTextFirstQuestion() {
        return driver.findElement(ANSWER_TEXT_FIRST).getText();
    }

    public void clickOnLastQuestion() {
        driver.findElement(LAST_QUESTION).click();
    }

    public String getTextLastQuestion() {
        return driver.findElement(ANSWER_TEXT_LAST).getText();
    }

    public void closeCookieWindow() {
        if (driver.findElement(COOKIE_WINDOW).isDisplayed()) {
            driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        }
    }

}
