package com.telran.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void loginUserPositiveTest() {
//click on Login link
        app.getUser().login();
//assert the button SignOut
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }


}