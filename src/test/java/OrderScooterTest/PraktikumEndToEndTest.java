package OrderScooterTest;

import OrderScooterTest.AboutRent;
import OrderScooterTest.MainPage;
import OrderScooterTest.OrderAScooter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


@RunWith(Parameterized.class)
public class PraktikumEndToEndTest {
    private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String comment;

    public PraktikumEndToEndTest(String name, String lastName, String address, String phone, String comment){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] { {"Гарри", "Поттер", "Хогвартс", "89267374774", ""},
                {"Рон", "Уизли", "Дом Нора", "00777777777", "Домофон не работает"},
                {"Северус", "Снейп", "Улица", "12347777789", "12321"}};
    }

    @Test
    public void orderAScooterTest(){
        System.setProperty("webdriver.gecko.driver","C:/Users/User/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.goToCheckoutPage();

        OrderAScooter objOrderAScooter = new OrderAScooter(driver);
        objOrderAScooter.inputFirstOrderPageAndGo(name, lastName, address, phone);

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.orderScooter(comment);
        objAboutRent.clickOnCompleteOrderButton();

        objAboutRent.checkCompleteOrder();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
