package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement preloader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public HomePage isShown() {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        return this;
    }

    public HomePage AskForCall() {
        WebElement CallbackBtn = driver.findElement(By.className("callback-btn"));
        wait.until(ExpectedConditions.visibilityOf(CallbackBtn));
        CallbackBtn.click();


        WebElement inputField = driver.findElement(By.id("b-contacte__full-name"));
        wait.until(ExpectedConditions.visibilityOf(inputField));
        inputField.sendKeys("Test");

        WebElement PhoneField = driver.findElement(By.id("b-contacte-phone-tel"));
        wait.until(ExpectedConditions.visibilityOf(PhoneField));
        PhoneField.sendKeys("0961234567");
        WebElement SendCall = driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]"));
        wait.until(ExpectedConditions.visibilityOf(SendCall));
        SendCall.click();
        return this;


    }
        public HomePage contacteLoader() {
        WebElement loaderHiden = driver.findElement(By.className("b-header-contacte-loader hidden"));
            wait.until(ExpectedConditions.visibilityOf(loaderHiden));
            wait.until(ExpectedConditions.invisibilityOf(loaderHiden));
            return this;
        }
        public boolean thanksText() {
            WebElement tnxtxt = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank hiden']/p"));

            String expectedValue = "Спасибо! Наш менеджер свяжется с вами.";
            String actualValue = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank hiden']/p")).getText();
            return tnxtxt.isDisplayed();

        }

}