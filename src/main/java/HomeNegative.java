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

    public HomeNegative callBtn() {
        WebElement CallBtn = driver.findElement(By.className("callback-btn"));
        wait.until(ExpectedConditions.visibilityOf(CallBtn));
        CallBtn.click();


        WebElement inputField = driver.findElement(By.id("b-contacte__full-name"));
        wait.until(ExpectedConditions.visibilityOf(inputField));
        inputField.sendKeys("");

        WebElement PhField = driver.findElement(By.id("b-contacte-phone-tel"));
        wait.until(ExpectedConditions.visibilityOf(PhField));
        PhField.sendKeys("");
        WebElement Call = driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]"));
        wait.until(ExpectedConditions.visibilityOf(Call));
        Call.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));
        return this;
    }

}
