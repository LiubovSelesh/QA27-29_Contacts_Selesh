package com.telran.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }
    public boolean isLogoPhonebookPresent() {
        return isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]"));
    }

    public boolean isLogoHomePresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'HOME')]"));
    }

    public boolean isLogoAboutPresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'ABOUT')]"));

    }
}
