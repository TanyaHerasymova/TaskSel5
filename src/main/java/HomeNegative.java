package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeNegative {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement preloader;

    public HomeNegative(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public HomeNegative Shown() {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        return this;
    }
    public HomeNegative callBtn() {
        WebElement CallbackBtn = driver.findElement(By.className("callback-btn"));
        wait.until(ExpectedConditions.visibilityOf(CallbackBtn));
        CallbackBtn.click();


        WebElement inputField = driver.findElement(By.id("b-contacte__full-name"));
        wait.until(ExpectedConditions.visibilityOf(inputField));
        inputField.sendKeys("");

        WebElement PhoneField = driver.findElement(By.id("b-contacte-phone-tel"));
        wait.until(ExpectedConditions.visibilityOf(PhoneField));
        PhoneField.sendKeys("");
        WebElement SendCall = driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]"));
        wait.until(ExpectedConditions.visibilityOf(SendCall));
        SendCall.click();
        return this;
    }
}
