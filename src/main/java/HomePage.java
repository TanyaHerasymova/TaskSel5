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
        WebElement CallbackBtn = driver.findElement(By.className("Callback-btn"));
        wait.until(ExpectedConditions.visibilityOf(CallbackBtn));
        CallbackBtn.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));
        By input = By.id("b-contacte__full-name");
        WebElement inputField = driver.findElement(input);
        inputField.sendKeys("Test");
        wait.until(ExpectedConditions.visibilityOf(inputField));
        By inputTel = By.id("b-contacte-phone-tel");
        WebElement PhoneField = driver.findElement(inputTel);
        PhoneField.sendKeys("0961234567");
        WebElement SendCall = driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]"));
        CallbackBtn.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b-header-contacte-loader hidden"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("b-header-contacte-loader hidden"))));
        return this;

    }

    public HomePage ThanksText() {
        WebElement tnxText = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank hiden']/p"));
        String expextedValue = "Спасибо! Наш менеджер свяжется с вами.";
        String actualValue = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank hiden']/p")).getText();

        assertEquals(expextedValue, actualValue);
    }

}