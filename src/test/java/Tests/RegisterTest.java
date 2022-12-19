package Tests;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    WebDriverWait webWait;
    String URL = "https://automationexercise.com/";
    RegisterPage registerPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
        webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
    }
    //TC:1
    @Test
    public void signUpValidationSuccess() {
        softAssert.assertTrue(registerPage.getPageUrl().contains("https://automationexercise.com"), "URL is not matched");
        registerPage.navigateOnSignUp();
        softAssert.assertEquals(registerPage.getHeader(), "New User Signup!");
        registerPage.enterUsername("Tuka Ibrahim");
        registerPage.getTestEmail();
        registerPage.clickSignUpBtn();
        registerPage.signupForm();
        softAssert.assertEquals(registerPage.getAccountCreatedAlert(), "ACCOUNT CREATED!");
        registerPage.clickContinue();
        softAssert.assertEquals(registerPage.getLoggedinUserAlert(), ("Logged in as " + registerPage.getUsername()));
        registerPage.clickOnDeleteBtn();
        softAssert.assertEquals(registerPage.getDeletedAccountAlert(), "ACCOUNT DELETED!");
        registerPage.clickContinue();
        softAssert.assertAll();
    }
    //TC:5
    @Test
    public void signUpWithExistingEmail() {
        registerPage.navigateOnSignUp();
        softAssert.assertEquals(registerPage.getHeader(), "New User Signup!");
        registerPage.enterUsername("Tuke Ibrahim");
        registerPage.enterEmail("tuka1671287889977@gmail.com");
        registerPage.clickSignUpBtn();
        softAssert.assertEquals(registerPage.getErrorMsgSignUp(),"Email Address already exist!");
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}