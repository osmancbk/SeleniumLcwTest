package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    String baseURL = "https://www.lcwaikiki.com/";
    By loginButtonClass = By.className("dropdown-toggle");
    By loginStatusId = By.className("dropdown-label");
    By searchBoxId = By.id("search_input");

    public HomePage(WebDriver driver){ super(driver); }

    public HomePage anasayfayaGit(){
        logger.info("Website start...");
        webDriver.get(baseURL);
        return this;
    }

    public HomePage anasayfaKontrol(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver ;
        String ready = (String) js.executeScript("return document.readyState");
        Assertions.assertEquals("complete",ready);
        logger.info("HomePage control başarılı.");
        return this;
    }

    public LoginPage girisSayfasinaGit(){
        logger.info("LoginPage açılıyor...");
        click(loginButtonClass);
        return new LoginPage(webDriver);
    }

    public HomePage girisKontrol(){

        Assertions.assertEquals(true,isDisplayed(loginStatusId));
        logger.info("Login başarılı");
        return this;

    }

    public SearchPage aramaYap(String text){

        writeText(searchBoxId, text);
        return new SearchPage(webDriver);

    }

}
