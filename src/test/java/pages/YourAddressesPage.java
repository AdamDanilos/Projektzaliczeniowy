package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {

    private WebDriver driver;



    @FindBy(css = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address")
    private WebElement addedNewAddressConfirm;




    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isAddNewAddressSuccess(String check) {

        return addedNewAddressConfirm.getText().contains(check);
    }
    public String  driverGetNewAddress () {
        driver.findElement(By.cssSelector("/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address")).getText();
        return driver.findElement(By.cssSelector("/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address")).getText();
    }
}
