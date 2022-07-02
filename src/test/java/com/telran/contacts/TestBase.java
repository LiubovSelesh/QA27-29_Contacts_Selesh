package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isComponentFormPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By loc) {
        try {
            driver.findElement(loc);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod(enabled = false)
//    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void login() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        type(By.cssSelector("[placeholder='Email']"), "ron+19@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Ro1234567$");
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickWithAction(By save) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);

        actions.moveToElement(element).perform();
        element.click();
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}