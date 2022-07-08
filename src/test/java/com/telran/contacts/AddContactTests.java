package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Max"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}