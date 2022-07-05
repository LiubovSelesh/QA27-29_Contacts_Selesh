package com.telran.contacts;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            login();
            addContact();
        }
    }

    @Test
    public void removeContactTest() {
        pause(2000);
        int sizeBefore = sizeOfContacts();
//        System.out.println(sizeBefore);
        removeContact();
        pause(2000);
        int sizeAfter = sizeOfContacts();
//        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}