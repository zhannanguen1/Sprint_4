package OrderScooterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AboutRent {

    private By sendDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By orderCountDate = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By orderColour = By.id("black");
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By completeOrder = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private String finaleHeader = "Заказ оформлен";

    private WebDriver driver;
    public AboutRent (WebDriver driver){
        this.driver = driver;
    }

    public void fillSendDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
        String date = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
        driver.findElement(sendDate).sendKeys(date);
        driver.findElement(sendDate).sendKeys(Keys.ENTER);
    }

    public void fillOrderCountDate(){
        driver.findElement(orderCountDate).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[2]")).click();
    }

    public void fillOrderColour(){
        driver.findElement(orderColour).click();
    }

    public void fillComment(String text){
        driver.findElement(comment).sendKeys(text);
    }

    public void clickOnOrderButton(){
        driver.findElement(orderButton).click();
    }

    public void orderScooter(String comment){
        fillSendDate();
        fillOrderCountDate();
        fillOrderColour();
        fillComment(comment);
        clickOnOrderButton();
    }

    public void clickOnCompleteOrderButton(){
        driver.findElement(completeOrder).click();
    }

    public void checkCompleteOrder(){
        assertEquals("Заказ не оформлен",true, driver.findElement(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']")).isDisplayed());
    }

}
