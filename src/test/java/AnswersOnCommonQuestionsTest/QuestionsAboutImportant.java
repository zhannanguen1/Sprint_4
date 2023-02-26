package AnswersOnCommonQuestionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class QuestionsAboutImportant {
    private WebDriver driver;
    private By firstQuestion = By.id("accordion__heading-0");
    private By lastQuestion = By.id("accordion__heading-7");
    private By cookieWindow = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");

    public void clickOnFirstQuestion(){
        Assert.assertTrue(driver.findElement(firstQuestion).isEnabled());
        driver.findElement(firstQuestion).click();
    }

    public void checkTextOnFirstQuestion(){
        String expected = driver.findElement(By.xpath(".//p")).getText();
        assertEquals("Неверный текст", expected, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }

    public void clickOnLastQuestion(){
        Assert.assertTrue(driver.findElement(lastQuestion).isEnabled());
        driver.findElement(lastQuestion).click();
    }

    public void checkTextOnLastQuestion(){
        String expected = driver.findElement(By.xpath(".//p[text() = 'Да, обязательно. Всем самокатов! И Москве, и Московской области.']")).getText();
        assertEquals("Неверный текст", expected, "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    public void closeCookieWindow(){
        if(driver.findElement(cookieWindow).isDisplayed()){
            driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        }
    }

    public QuestionsAboutImportant (WebDriver driver){
        this.driver = driver;
    }

}
