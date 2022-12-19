package Tests;

import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class LoginTest {
    WebDriver driver;
    WebDriverWait webWait;
    String URL="https://automationexercise.com/";
    RegisterPage registerPage;
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage;
    String testEmail;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.get(URL);
        webWait =new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        registerPage=new RegisterPage(driver);
        loginPage=new LoginPage(driver);
        registerPage.navigateOnSignUp();
        registerPage.enterUsername("Tuka Ibrahim");
        testEmail=registerPage.getTestEmail();
        registerPage.clickSignUpBtn();
        registerPage.signupForm();
        registerPage.clickContinue();
        loginPage.logout();
    }
    //TC:2
    @Test
    public void loginValidationSuccess(){
     loginPage.navigateOnSignIn();
     softAssert.assertTrue(loginPage.getPageUrl().contains("https://automationexercise.com"),"URL is not matched");
     softAssert.assertEquals(loginPage.getHeader(),"Login to your account");
     loginPage.LoginForm(testEmail,"Hithere@@");
     loginPage.clickLoginBtn();
     registerPage.getUsername();
     softAssert.assertEquals(loginPage.getLoggedinUserAlert(),("Logged in as " + registerPage.getUsername()));
     loginPage.clickOnDeleteBtn();
     softAssert.assertEquals(loginPage.getDeletedAccountAlert(),"ACCOUNT DELETED!");
     loginPage.clickContinue();
     softAssert.assertAll();
    }
    //TC:3
    @Test
    public void loginValidationFail(){
        loginPage.navigateOnSignIn();
        softAssert.assertTrue(loginPage.getPageUrl().contains("https://automationexercise.com"),"URL is not matched");
        softAssert.assertEquals(loginPage.getHeader(),"Login to your account");
        loginPage.LoginForm(testEmail,"wrong@@");
        loginPage.clickLoginBtn();
        softAssert.assertEquals(loginPage.getErrorBtn(),"Your email or password is incorrect!");
        softAssert.assertAll();
    }
    //TC:4
    @Test
    public void logoutValidation(){
        loginPage.navigateOnSignIn();
        softAssert.assertTrue(loginPage.getPageUrl().contains("https://automationexercise.com"),"URL is not matched");
        softAssert.assertEquals(loginPage.getHeader(),"Login to your account");
        //I can't use the testEmail here because it got deleted in the loginFunction, instead I will use an email exists already
        loginPage.LoginForm("tuka1671287889977@gmail.com", "Hithere@@");
        loginPage.clickLoginBtn();
        registerPage.getUsername();
        softAssert.assertEquals(loginPage.getLoggedinUserAlert(),("Logged in as " + registerPage.getUsername()));
        loginPage.logout();
        softAssert.assertTrue(registerPage.getPageUrl().contains("https://automationexercise.com/login"),"URL is not matched");
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
