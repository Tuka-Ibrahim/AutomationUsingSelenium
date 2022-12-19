package Tests;

import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class ProductsTest {
    WebDriver driver;
    WebDriverWait webWait;
    String URL="https://automationexercise.com/";
    SoftAssert softAssert = new SoftAssert();
    ProductsPage productsPage;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
        webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productsPage=new ProductsPage(driver);
        driver.manage().window().maximize();
    }
    //TC:9
    @Test
    public void searchProductsValidation() {
        softAssert.assertTrue(productsPage.getPageUrl().contains("https://automationexercise.com"), "URL is not matched");
        softAssert.assertEquals(productsPage.getPageTittle(), "Automation Exercise");
        productsPage.navigateOnProductsPage();
        softAssert.assertEquals(productsPage.getALLPRODUCTSSign(), "ALL PRODUCTS");
        productsPage.search("Top");
        //Iterator<WebElement> iteratorallProducts = productsPage.getProductsList().iterator();
        for (WebElement product: productsPage.getProductsList()){
            //product=iteratorallProducts.next();
            //System.out.println(product.getText());
            softAssert.assertTrue(product.getText().contains("Top"),"Search results has unrelated items");
        }
        softAssert.assertEquals(productsPage.getSearchedProductsSign(), "SEARCHED PRODUCTS");
        softAssert.assertAll();
    }
    //TC:12
    @Test
    public void addProductsInCartValidation(){
        softAssert.assertTrue(productsPage.getPageUrl().contains("https://automationexercise.com"), "URL is not matched");
        productsPage.navigateOnProductsPage();
        productsPage.addToCartProcess();
        softAssert.assertEquals(productsPage.getProduct1(),"Blue Top");
        softAssert.assertEquals(productsPage.getProduct2(),"Men Tshirt");
        softAssert.assertEquals(productsPage.getProduct1Price(),"Rs. 500");
        softAssert.assertEquals(productsPage.getProduct2Price(),"Rs. 400");
        softAssert.assertEquals(productsPage.getProduct1Qty(),"1");
        softAssert.assertEquals(productsPage.getProduct2Qty(),"1");
        softAssert.assertEquals(productsPage.getProduct1TotalPrice(),"Rs. 500");
        softAssert.assertEquals(productsPage.getProduct2TotalPrice(),"Rs. 400");
        softAssert.assertAll();
    }
    @AfterMethod
    public void returntohome(){
        driver.get(URL);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
