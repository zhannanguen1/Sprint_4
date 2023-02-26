package AnswersOnCommonQuestionsTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PraktikumAnswersOnQuestionsTest {
    private WebDriver driver;
    @Test
    public void checkTextInListFirstQ() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        QuestionsAboutImportant objQuestionsAboutImportant = new QuestionsAboutImportant(driver);
        objQuestionsAboutImportant.closeCookieWindow();
        objQuestionsAboutImportant.clickOnFirstQuestion();
        objQuestionsAboutImportant.checkTextOnFirstQuestion();


    }

    @Test
    public void checkTextInListLastQ() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement element = driver.findElement(By.id("accordion__panel-7"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        QuestionsAboutImportant objQuestionsAboutImportant = new QuestionsAboutImportant(driver);
        objQuestionsAboutImportant.closeCookieWindow();
        objQuestionsAboutImportant.clickOnLastQuestion();
        objQuestionsAboutImportant.checkTextOnLastQuestion();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
