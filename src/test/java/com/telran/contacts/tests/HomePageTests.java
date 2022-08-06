package com.telran.contacts.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void openHomePage() {
        System.out.println("Site opened!!!");

        app.getHomePage().isComponentFormPresent();
//        System.out.println("Component Form: " + isComponentFormPresent());
//        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
//        isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
    }
    @Test
    public void LogoPhonebookPresent() {
        app.getHeader().isLogoPhonebookPresent();
        app.getHeader().isLogoHomePresent();
        app.getHeader().isLogoAboutPresent();
    }

    @Test
    public void LogoHomePresent() {
        app.getHeader().isLogoHomePresent();
    }

    @Test
    public void LogoAboutPresent() {
        app.getHeader().isLogoAboutPresent();
    }


}