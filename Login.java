package pages;

import DriverRepo.ConfigDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    public Login(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @FindBy(linkText = "My account")
    WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutBtn;

    public void login(String mail, String pass) {
        email.clear();
        password.clear();
        email.sendKeys(mail);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public void logout() {
        myAccount.click();
        WebDriverWait wait = new WebDriverWait(ConfigDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();
    }





}
