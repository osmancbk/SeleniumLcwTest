package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    By cartPrice = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[2]");
    By addProductButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/a[2]");
    By productQuantityField = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/input");
    By premoveProductButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div/a[1]/i");
    By confirmButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/a[1]");
    By emptyCartId = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div/div/p[1]");

    public CartPage(WebDriver driver){ super(driver); }

    public CartPage fiyatKontrol(){

        WebElement w = webDriver.findElement(cartPrice);
        String val = w.getText();
        Assertions.assertEquals(productPrice,val);
        logger.info("Prices are equal");
        return this;

    }

    public CartPage urunEkle(){

        click(addProductButton);
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        return this;

    }

    public CartPage adetKontrol(){

        WebElement w = webDriver.findElement(productQuantityField);
        String val = w.getAttribute("data-quantity");
        Assertions.assertEquals("2",val);
        logger.info("Correct number of product");
        return this;

    }

    public CartPage urunSil(){

        click(premoveProductButton);
        click(confirmButton);
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        return this;

    }

    public CartPage sonKontrol(){
        WebElement w = webDriver.findElement(emptyCartId);
        String val = w.getText();
        Assertions.assertEquals("Basket is empty....",val);
        logger.info("Basket is empty");
        return this;
    }

}
