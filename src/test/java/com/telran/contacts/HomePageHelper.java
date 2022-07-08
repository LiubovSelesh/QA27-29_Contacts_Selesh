package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isComponentFormPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size() > 0;
    }
}
