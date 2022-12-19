package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait webWait;
//    public String getTestEmail(){
//        return "tuka"+ +new Date().getTime()+"@gmail.com";
//    }
    By signUpLoginIcon= By.xpath("//a[@href='/login']");
    By accountEmail=By.xpath("//*[@data-qa='login-email']");
    By accountPwd=By.xpath("//*[@data-qa='login-password']");
    //By loginBtn=By.xpath("//*[@data-qa='login-button']");
    By loggedInLink=By.xpath("//i[contains(@class,'fa-user')]//parent::a");
    String returnedUsername;
    By deleteLink=By.xpath("//*[@data-qa='account-deleted']");
    By logoutBtn = By.xpath("//a[@href='/logout']");
    By signInbutton=By.xpath("//*[@data-qa='login-button']");
    By errorLink=By.xpath("//form[@action='/login']//p");
    By deleteBtn=By.xpath("//a[@href='/delete_account']");
    By continueBtn=By.xpath("//*[@data-qa='continue-button']");
    public LoginPage(WebDriver webDriver){
        this.driver=  webDriver;
        webWait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    public void navigateOnSignIn(){
        driver.findElement(signUpLoginIcon).click();
    }
    public String getHeader(){
        return driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
    }
    public void LoginForm(String emailInput, String password){
        driver.findElement(accountEmail).sendKeys(emailInput);
        driver.findElement(accountPwd).sendKeys(password);
    }
    public void clickLoginBtn(){
        webWait.until(ExpectedConditions.elementToBeClickable(signInbutton));
        driver.findElement(signInbutton).click();
    }
    public String getLoggedinUserAlert(){
        return driver.findElement(loggedInLink).getText();
    }
    public void clickOnDeleteBtn(){
        driver.findElement(deleteBtn).click();
    }
    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
    public String getDeletedAccountAlert(){
        return driver.findElement(deleteLink).getText();
    }
    public void logout(){
        webWait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        driver.findElement(logoutBtn).click();
    }
    public String getErrorBtn(){
        return driver.findElement(errorLink).getText();
    }

}
