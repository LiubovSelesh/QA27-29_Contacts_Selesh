package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import com.telran.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }


    @Test(enabled = false)
    public void registrationPositiveTest() {
        app.getUser().registration();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test (dataProvider = "addNewUserFormCSV", dataProviderClass = DataProviders.class)
    public void registrationNegativeTestWithWrongEmail(User user) {

        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test (dataProvider = "addNewUserFormPasswordCSV", dataProviderClass = DataProviders.class, enabled = false)
    public void registrationNegativeTestWithWrongPassword(User user) {

        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));
    }




    @AfterMethod(enabled = false)
//    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
}


