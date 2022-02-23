package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressPageCheck {

    @FindBy(xpath = "//*[@id=\"content\"]")
    private WebElement addedNewAddressConfirm;




    public YourAddressPageCheck(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public boolean isAddNewAddressSuccess(String check) {
        return addedNewAddressConfirm.getText().contains(check);
    }
}
