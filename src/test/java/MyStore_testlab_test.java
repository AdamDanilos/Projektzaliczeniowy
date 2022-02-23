import Methods.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddAdresPage;
import pages.LoginPage;
import pages.YourAddressPageCheck;
import pages.YourAddressesPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStore_testlab_test {

    private WebDriver driver;
    private YourAddressPageCheck yourAddressPage;


    @Given("user is on Sing in page")
    public void userIsOnSingInPage() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
            driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("user entered {string},{string} and click sing in button")
    public void userEntered(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email,password);
    }

    @And("user click at the ADD FIRST ADDRESS button")
    public void userClickAtTheADDFIRSTADDRESSButton() {
        driver.findElement(By.xpath("//*[@id=\"address-link\"]/span/i")).click();
    }

    @And("user entered {string}, {string}, {string}, {string}, {string}, {string} click SAVE button")
    public void userEntered(String alias, String address,String PostalCode, String city, String country, String phone) {
        AddAdresPage addAdresPage = new AddAdresPage(driver);
        addAdresPage.inputAddress(alias,address,PostalCode,city,country,phone);
    }

    @Then("user is on Your addresses site added address is visible {string}, {string}, {string}, {string}, {string}, {string}")
    public void userIsOnYourAddressesSiteAddedAddressIsVisible(String alias, String address,String PostalCode, String city, String country, String phone) {
        yourAddressPage = new YourAddressPageCheck(driver);
        assertTrue(yourAddressPage.isAddNewAddressSuccess(alias));
        assertTrue(yourAddressPage.isAddNewAddressSuccess(address));
        assertTrue(yourAddressPage.isAddNewAddressSuccess(PostalCode));
        assertTrue(yourAddressPage.isAddNewAddressSuccess(city));
        assertTrue(yourAddressPage.isAddNewAddressSuccess(country));
        assertTrue(yourAddressPage.isAddNewAddressSuccess(phone));
    }

    @And("user click delete")
    public void userClickDelete() {

        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span")).click();
    }

    @And("added address disappear")
    public void addedAddressDisappear() {
        WebElement idd = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
        if(idd.isDisplayed()) {
            System.out.println("Napis: Address successfully deleted! jest widoczny");
        }else {
            Assert.fail();
        }
        driver.quit();
    }
}
