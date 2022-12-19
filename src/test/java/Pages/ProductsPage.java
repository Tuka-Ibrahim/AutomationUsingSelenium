package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait webWait;
    Actions action ;
    By productsIcon= By.xpath("//a[@href='/products']");
    By allProductsSign=By.xpath("//div[@class='features_items']/h2");
    By searchInput=By.id("search_product");
    By submitSearchBtn=By.id("submit_search");
    By searchedProductsSign=By.xpath("//div[@class='features_items']/h2");
    By allProducts=By.xpath("//div[@class='productinfo text-center']/p");
    //List<WebElement> elementsAppearedInSearch= new ArrayList<>();
    //int expectedCounter = 0;
    //int actualCounter=0;
    By firstProduct=By.xpath("(//div[@class='single-products'])[1]");
    By secondProduct=By.xpath("(//div[@class='single-products'])[2]");
    By firstProductTittle=By.xpath("//a[@href='/product_details/1']");
    By secondProductTittle=By.xpath("//a[@href='/product_details/2']");
    By firstProductPrice= By.xpath("(//td[@class='cart_price'])[1]");
    By secondProductPrice= By.xpath("(//td[@class='cart_price'])[2]");
    By firstProductQty=By.xpath("(//td[@class='cart_quantity'])[1]");
    By secondProductQty=By.xpath("(//td[@class='cart_quantity'])[2]");
    By firstProductTotalPrice=By.xpath("(//td[@class='cart_total'])[1]");
    By secondProductTotalPrice=By.xpath("(//td[@class='cart_total'])[2]");
    By addToCartBtnFirstProduct=By.xpath("//a[@data-product-id='1']");
    By addToCartBtnSecondProduct=By.xpath("//a[@data-product-id='2']");
    By cartIcon= By.xpath("//a[@href='/view_cart']");
    By continueShoppingBtn=By.xpath("//*[@class='modal-footer']/button");
    public ProductsPage(WebDriver webDriver){
        this.driver=  webDriver;
        webWait =new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(webDriver);
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    public String getPageTittle(){
        return driver.getTitle();
    }
    public void navigateOnProductsPage(){
        webWait.until(ExpectedConditions.elementToBeClickable(productsIcon));
        driver.findElement(productsIcon).click();
    }
    public String getALLPRODUCTSSign(){
        return driver.findElement(allProductsSign).getText();
    }
    public void search (String searchedProduct){
        webWait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        webWait.until(ExpectedConditions.elementToBeClickable(submitSearchBtn));
        driver.findElement(searchInput).sendKeys(searchedProduct);
        driver.findElement(submitSearchBtn).click();
    }
    public String getSearchedProductsSign(){
        return driver.findElement(searchedProductsSign).getText();
    }
    public List<WebElement> getProductsList(){
        List <WebElement> searchedProducts = driver.findElements(allProducts);
        return searchedProducts;
    }
    public Iterator<WebElement> getSearchedIterator(){
        Iterator<WebElement> iteratorallProducts = getProductsList().iterator();
        return iteratorallProducts;
    }
    public void addToCartProcess(){
        action.moveToElement(driver.findElement(firstProduct)).perform();
        driver.findElement(addToCartBtnFirstProduct).click();
        webWait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        driver.findElement(continueShoppingBtn).click();
        action.moveToElement(driver.findElement(secondProduct)).perform();
        driver.findElement(addToCartBtnSecondProduct).click();
        webWait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        driver.findElement(continueShoppingBtn).click();
        webWait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        driver.findElement(cartIcon).click();
    }
    public String getProduct1(){
        return driver.findElement(firstProductTittle).getText();
    }
    public String getProduct2(){
        return driver.findElement(secondProductTittle).getText();
    }
    public String getProduct1Price(){
        return driver.findElement(firstProductPrice).getText();
    }
    public String getProduct2Price(){
        return driver.findElement(secondProductPrice).getText();
    }
    public String getProduct1Qty(){
        return driver.findElement(firstProductQty).getText();
    }
    public String getProduct2Qty(){
        return driver.findElement(secondProductQty).getText();
    }
    public String getProduct1TotalPrice(){
        return driver.findElement(firstProductTotalPrice).getText();
    }
    public String getProduct2TotalPrice(){
        return driver.findElement(secondProductTotalPrice).getText();
    }


//    public String getTextResults() {
//        List<WebElement> searchedProducts = driver.findElements(allProducts);
//        Iterator<WebElement> iteratorallProducts = searchedProducts.iterator();
//        if (iteratorallProducts.hasNext()) {
//            for (WebElement product : searchedProducts) {
//                product = iteratorallProducts.next();
//                System.out.println(product.getText());
//                return product.getText();
//            }
//        }
//        return null;
//    }
    //fkret el manual search:
    //1-hktb esm el searched word
    //2-hkhod kol ely fl list bt-contain el asm eli ana ktbaha
    //3-hqraen b2a el result eli tl3le nfs el rkm wla la2
    int actualCounter=0;
    public int getActualSizeOfRelatedProducts(String searchedProduct){
        if (driver.findElements(allProducts).contains(searchedProduct)) {
            actualCounter++;
        }
        return actualCounter;
        //elementsAppearedInSearch = driver.findElements(getAllProducts);
        //return elementsAppearedInSearch.size();
    }
//    public int getExpectedSizeOfRelatedProducts() {
//        List<WebElement> allProductsRleaved = driver.findElements(getAllProducts);
//        Iterator<WebElement> iteratorAllProducts = allProductsRleaved.iterator();
//        while (iteratorAllProducts.hasNext()) {
//            expectedCounter++;
//        }
//        return expectedCounter;
//    }




}
