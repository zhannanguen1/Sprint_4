package answers.on.common.questions.test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.objects.MainPage;

import static org.junit.Assert.assertEquals;

public class PraktikumAnswersOnQuestionsTest {
    private WebDriver driver;

    @Test
    public void checkTextInListFirstQ() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieWindow();
        objMainPage.clickOnFirstQuestion();
        String actual = objMainPage.getTextFirstQuestion();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals("Неверный текст", expected, actual);

    }

    @Test
    public void checkTextInListLastQ() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement element = driver.findElement(By.id("accordion__panel-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieWindow();
        objMainPage.clickOnLastQuestion();
        String actual = objMainPage.getTextLastQuestion();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals("Неверный текст", expected, actual);


    }

    @After
    public void teardown() {
        driver.quit();
    }
}
