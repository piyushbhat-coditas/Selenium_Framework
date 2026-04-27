package pages;

import DriverRepo.ConfigDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "My account")
    WebElement myAccounts;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutBtn;

    @FindBy(linkText = "Register")
    WebElement register;

    public void verifyHomePageNavigation() {
        try {
            String homePageTitle = ConfigDriver.getDriver().getTitle();
            String expectedTitle = "Your Store";
            Assert.assertEquals(homePageTitle, expectedTitle, "Home page title does not match expected value.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clickMyAccounts() {
        try {
            WebDriverWait wait = new WebDriverWait(ConfigDriver.getDriver(), Duration.ofSeconds(10));

            WebElement myAccounts = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("My account"))
            );
            myAccounts.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void clickRegister() {
        try {
            register.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void logout() {
        try {
            WebDriverWait wait = new WebDriverWait(ConfigDriver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(myAccounts)).click();

            wait.until(ExpectedConditions.visibilityOf(logoutBtn));
            wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
