package com.addressbook.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("test First","test@test.com","07123456734");
        Contact contact1 = new Contact("Test Mate","Test@Gmail.com","07123456789");
//        addressBook.addContact(contact);

        try {
            addressBook.addContact(contact);
            addressBook.addContact(contact1);
            addressBook.searchByName("Test");
            System.out.println("New contact has been added");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
