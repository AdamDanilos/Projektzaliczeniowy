package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddAdresPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement inputAlias;

    @FindBy(name = "address1")
    private WebElement inputAddress;

    @FindBy(name = "postcode")
    private WebElement inputPostcode;

    @FindBy(name = "city")
    private WebElement inputCity;

    @FindBy(name = "id_country")
    private WebElement inputCountry;

    @FindBy(name = "phone")
    private WebElement inputPhone;

    @FindBy(name = "id_country")
    private WebElement countryClick;

    @FindBy(css = "button.btn.btn-primary.float-xs-right")
    private WebElement SaveButton;


    public AddAdresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputAddress(String alias,String address, String PostalCode, String city, String country, String phone) {
        inputAlias.sendKeys(alias);
        inputAddress.sendKeys(address);
        inputPostcode.sendKeys(PostalCode);
        inputCity.sendKeys(city);
        inputPhone.sendKeys(phone);
        countryClick.click();
        inputCountry.sendKeys(country);
        countryClick.click();
        if (SaveButton.isEnabled()) {
            SaveButton.click();
        } else {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
        }
    }
}
