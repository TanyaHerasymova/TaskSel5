package test.java;

import main.java.HomeNegative;
import main.java.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

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
                .contacteLoader();
        WebElement tnxTxt = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank hiden']/p"));
        assertTrue(tnxTxt.isDisplayed());
    }

                @Test
                 public static void CheckNegative() throws InterruptedException {
                    homePage.isShown();
                    homeNegative.callBtn();
                    WebElement checkIfFrameIsRed = driver.findElement(By.xpath("//*[@id=\"b-contacte__full-name\"]//.."));
                    assertTrue(checkIfFrameIsRed.isDisplayed());

    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
    public Object[] [] provider() {
        return new Object[][] {
                {"ru-RU"},
                {},
                {}
        };
    }

    }

}


