import Methods.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.LoginPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class sweater {

    private WebDriver driver;


    @Given("user is on a login site")
    public void userIsOnALoginSite() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }
    @When("user entered {string},{string} and click sing in buttons")
    public void userEnteredAndClickSingInButtons(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @And("user click CLOTHES button")
    public void userClickCLOTHESButton() {
        driver.findElement(By.xpath("//*[@id=\"category-3\"]/a")).click();
    }
    @And("user click  on a Hummingbird Printed Sweater")
    public void userClickOnAHummingbirdPrintedSweater() {
        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img")).click();
    }

    @And("user click size {string}")
    public void userClickSize (String size){
        driver.findElement(By.id("group_1")).sendKeys(size + Keys.ENTER);
    }
    @And("user add quantity {string}")
    public void userAddQuantity (String quantity){
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys(quantity);
    }

    @And("user click ADD TO CART button")
    public void userClickADDTOCARTButton () {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
    }

    @And("user click PROCEED TO CHECKOUT")
    public void userClickPROCEEDTOCHECKOUT () {
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
    }

    @And("user click proceed to checkout")
    public void userClickProceedToCheckout () {
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
    }

    @And("user click Continue")
    public void userClickContinue () {
        driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")).click();
    }

    @And("user click second time continue")
    public void userClickSecondTimeContinue () {
        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();
    }

    @And("user click Pay by Check")
    public void userClickPayByCheck () {
        driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]")).click();
    }

    @And("user click check box")
    public void userClickCheckBox () {
        driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();
    }

    @And("user click order with an obligation to pay")
    public void userClickOrderWithAnObligationToPay () {
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
    }

    @And("user is on Your order is confirmed take screen shot")
    public void userIsOnYourOrderIsConfirmedTakeScreenShot () throws Exception {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./screenshots/Screen.png"));
            System.out.println("the ScreenShot is taken");

    }

    @When("user click signed user button")
    public void userClickSignedUserButton () {
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).click();
    }

    @And("user click Order history and details")
    public void userClickOrderHistoryAndDetails () {
        driver.findElement(By.xpath("//*[@id=\"history-link\"]")).click();
    }

    @Then("user check status and price")
    public void userCheckStatusAndPrice () {
        driver.quit();
    }
}

