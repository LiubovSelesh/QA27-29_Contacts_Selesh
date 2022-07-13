package com.telran.contacts.tests;

import com.telran.contacts.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    //    @AfterMethod(enabled = false)
    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}