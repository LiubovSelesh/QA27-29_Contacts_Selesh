package com.telran.contacts.tests;

import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void openHomePage() {
        app.getHomePage().isComponentFormPresent();

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