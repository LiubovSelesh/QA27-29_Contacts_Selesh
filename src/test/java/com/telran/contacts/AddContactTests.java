package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginLinkPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        } else {
            login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        type(By.cssSelector("input:nth-child(1)"), "Max" + i);
        type(By.cssSelector("input:nth-child(2)"), "Miller");
        type(By.cssSelector("input:nth-child(3)"), "+1234567" + i);
        type(By.cssSelector("input:nth-child(4)"), "max" + i + "@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "Friend");
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(isContactCreated("Max"));
    }

}