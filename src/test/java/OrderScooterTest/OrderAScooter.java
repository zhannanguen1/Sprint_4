package OrderScooterTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderAScooter {
    private WebDriver driver;
    // заголовок Для кого самокат
    private By headerOne = By.className("Order_Header__BZXOb");
    // поле Имя
    private final static By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    // поле Фамилия
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    // поле Адрес
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // поле Станция метро
    private By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // поле Телефон
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    // кнопка далее
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By cookieWindow = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");

    public void waitForLoadingPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOne));
    }

    public void fillNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void fillAddressField(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void fillPhoneField(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void inputOrderMetro(int n){
        driver.findElement(metroField).click();
        for(int i = 0; i < n; i++) {
            driver.findElement(metroField).sendKeys(Keys.DOWN);
        }
        driver.findElement(metroField).sendKeys(Keys.ENTER);
    }

    public void clickOnNextButton(){
        driver.findElement(nextButton).click();
    }
    public OrderAScooter (WebDriver driver){
        this.driver = driver;
    }

    public void closeCookieWindow(){
        if(driver.findElement(cookieWindow).isDisplayed()){
            driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        }
    }

    public void inputFirstOrderPageAndGo(String name, String lastName, String address, String phone){
        waitForLoadingPage();
        fillNameField(name);
        fillLastNameField(lastName);
        fillAddressField(address);
        fillPhoneField(phone);
        inputOrderMetro(8);
        closeCookieWindow();
        clickOnNextButton();
    }

}
