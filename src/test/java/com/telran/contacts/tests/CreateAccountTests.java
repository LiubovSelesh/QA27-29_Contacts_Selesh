package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase{



//precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @DataProvider
    public Iterator<Object[]> addNewUserFormCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserFormPasswordCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userWrongPassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test
    public void registrationPositiveTest() {
//click on the link "LOGIN"
        app.getUser().registration();
//assert the button "Sign out" displayed
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test (dataProvider = "addNewUserFormCSV")
    public void registrationNegativeTestWithWrongEmail(User user) {

        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));
    }


    @Test (dataProvider = "addNewUserFormPasswordCSV")
    public void registrationNegativeTestWithWrongPassword(User user) {

        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));
    }




//    @AfterMethod(enabled = false)
    @AfterMethod(enabled = false)
    public void postCondition() {
        app.getContact().removeContact();
    }

}


