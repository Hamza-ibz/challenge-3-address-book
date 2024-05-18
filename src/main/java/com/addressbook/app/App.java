package com.addressbook.app;

import java.util.Arrays;
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
            for(int i = 0; i < addressBook.getContacts().size(); i++) {
                System.out.print(addressBook.getContacts().get(i).getName());
                System.out.print(addressBook.getContacts().get(i).getId()+"\n");
            }
            addressBook.editContact(1,"bob","test@test","0712345");

            for(int i = 0; i < addressBook.getContacts().size(); i++) {
                System.out.print(addressBook.getContacts().get(i).getName());
                System.out.print(addressBook.getContacts().get(i).getId()+"\n");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
