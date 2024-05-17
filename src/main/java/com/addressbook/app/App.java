package com.addressbook.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("sdf","kajshdf@shdf.com","07989898989");
        Contact contact1 = new Contact("dsf","kajshdf@shdf.com","07989898989");
//        addressBook.addContact(contact);

        try {
            addressBook.addContact(contact);
            addressBook.addContact(contact1);
            System.out.println(addressBook.getContacts());
            System.out.println("New contact has been added");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
