package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
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

//    @DataProvider
//    public Iterator<Object[]> addNewContact() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Katy", "Killer", "123456789", "killer@gm.com", "Berlin", "Friend"});
//        list.add(new Object[]{"Rok", "Bayar", "185423789", "bayar@gm.com", "Berlin", "Friend"});
//        list.add(new Object[]{"Tim", "Tomson", "123456789", "tomson@gm.com", "Berlin", "Friend"});
//        return list.iterator();
//    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

//    @Test(dataProvider = "addNewContact")
//    public void addContactPositiveTestFromDataProvider(String name, String lastName, String phone, String email, String address, String description) {
//        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
//        app.getContact().fillContactForm(new Contact().setName(name)
//                                                        .setLastName(lastName)
//                                                        .setPhone(phone)
//                                                        .setEmail(email)
//                                                        .setAddress(address)
//                                                        .setDescription(description));
//        app.getContact(). click(By.cssSelector(".add_form__2rsm2 button"));
////        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
//
//    }
    @Test(dataProvider = "addNewContactFromCSV")
    public void addContactPositiveTestFromDataCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(contact);
        app.getContact().click(By.cssSelector(".add_form__2rsm2 button"));
//        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));

    }

    @AfterMethod(enabled = false)
    public void postCondition() {
        app.getContact().removeContact();
    }

}