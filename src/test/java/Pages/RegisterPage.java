package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait webWait;
    String URL="https://automationexercise.com/";
    By signUpLoginIcon= By.xpath("//a[@href='/login']");
    By userName=By.xpath("//*[@data-qa='signup-name']");
    By userEmail=By.xpath("//*[@data-qa='signup-email']");
    By signUpLoginBtn=By.xpath("//*[@data-qa='signup-button']");
    By accountTittle=By.id("uniform-id_gender2");
    By accountPwd=By.id("password");
    By signUpforOurNewsletter = By.xpath("//label[@for='newsletter']");
    By receivespecialOffersFromourPartners = By.xpath("//label[@for='optin']");
    By firstName=By.xpath("//*[@data-qa='first_name']");
    By lasttName=By.xpath("//*[@data-qa='last_name']");
    By company=By.xpath("//*[@data-qa='company']");
    By address1=By.xpath("//*[@data-qa='address']");
    By address2=By.xpath("//*[@data-qa='address2']");
    By state=By.xpath("//*[@data-qa='state']");
    By city=By.xpath("//*[@data-qa='city']");
    By zipcode=By.xpath("//*[@data-qa='zipcode']");
    By mobileNumber=By.xpath("//*[@data-qa='mobile_number']");
    By accountSubmitBtn=By.xpath("//*[@data-qa='create-account']");
    By continueBtn=By.xpath("//*[@data-qa='continue-button']");
    By loggedInLink=By.xpath("//i[contains(@class,'fa-user')]//parent::a");

    By WebsiteUsername=By.xpath("//a[i]/b");
    By deleteBtn=By.xpath("//a[@href='/delete_account']");
    By signuperror=By.xpath("//form[@action='/signup']//p");

    String returnedUsername;
    By deleteLink=By.xpath("//div[@class=\"col-sm-9 col-sm-offset-1\"]/h2/b");
    public RegisterPage(WebDriver webDriver){
        this.driver=  webDriver;
        webWait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    public void navigateOnSignUp(){
        webWait.until(ExpectedConditions.elementToBeClickable(signUpLoginIcon));
        driver.findElement(signUpLoginIcon).click();
    }
    public void enterUsername(String userNameInput){
        driver.findElement(userName).sendKeys(userNameInput);
        returnedUsername=userNameInput;
    }
    public void enterEmail(String emailInput){
        driver.findElement(userEmail).sendKeys(emailInput);
    }
    public String getTestEmail(){
        String testEmail="tuka"+new SimpleDateFormat("MMddyyyyhhmmssSSSS").format(new Date())+"@gmail.com";
        driver.findElement(userEmail).sendKeys(testEmail);
        return testEmail;
    }
    public String getUsername(){
        return returnedUsername;
    }
    public void clickSignUpBtn(){
        webWait.until(ExpectedConditions.elementToBeClickable(signUpLoginBtn));
        driver.findElement(signUpLoginBtn).click();
    }
    public String getHeader(){
        return driver.findElement(By.xpath("//div[@class='signup-form']/h2")).getText();
    }
    public String getAccountCreatedAlert(){
        return driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b")).getText();
    }
    public void signupForm(){
        webWait.until(ExpectedConditions.elementToBeClickable(signUpLoginIcon));
        driver.findElement(accountTittle).click();
        driver.findElement(accountPwd).sendKeys("Hithere@@");
        WebElement accountBirthDay=driver.findElement(By.id("days"));
        Select selectDays = new Select(accountBirthDay);
        WebElement accountMonth=driver.findElement(By.id("months"));
        Select selectMonths = new Select(accountMonth);
        WebElement accountYears=driver.findElement(By.id("years"));
        Select selectYears = new Select(accountYears);
        if(!(accountBirthDay.isEnabled() && accountBirthDay.isDisplayed()))
        {
            System.out.println("accountBirthDay is not enabled");
        }
        selectDays.selectByVisibleText("23");
        selectMonths.selectByVisibleText("July");
        selectYears.selectByVisibleText("1999");
        driver.findElement(signUpforOurNewsletter).click();
        driver.findElement(receivespecialOffersFromourPartners).click();
        driver.findElement(firstName).sendKeys("Tuka");
        driver.findElement(lasttName).sendKeys("Elorabi");
        driver.findElement(company).sendKeys("VOIS");
        driver.findElement(address1).sendKeys("13 Kornich Maadi");
        driver.findElement(address2).sendKeys("2 Haram Egypt");
        WebElement accountCountry=driver.findElement(By.id("country"));
        Select selectCountries = new Select(accountCountry);
        selectCountries.selectByVisibleText("India");
        driver.findElement(state).sendKeys("Haram");
        driver.findElement(city).sendKeys("Cairo");
        driver.findElement(zipcode).sendKeys("0000");
        driver.findElement(mobileNumber).sendKeys("0125847800");
        driver.findElement(accountSubmitBtn).click();
    }
    public String getLoggedinUserAlert(){
        return driver.findElement(loggedInLink).getText();
    }
    public void clickContinue(){
        webWait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        driver.findElement(continueBtn).click();
    }
    public void clickOnDeleteBtn(){
        webWait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        driver.findElement(deleteBtn).click();
    }
    public String getDeletedAccountAlert(){
        return driver.findElement(deleteLink).getText();
    }
    public String getErrorMsgSignUp(){
        return driver.findElement(signuperror).getText();
    }
}
