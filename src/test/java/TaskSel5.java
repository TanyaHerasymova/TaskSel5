package test.java;

import main.java.HomeNegative;
import main.java.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskSel5 {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static HomeNegative homeNegative;




    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "E:\\ITEA\\Task Sel5\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homeNegative = new HomeNegative(driver);



    }

    @Test
    public static void mainTest() throws InterruptedException {
        homePage.isShown()
                .AskForCall()
                .ThanksText();

    }

}


