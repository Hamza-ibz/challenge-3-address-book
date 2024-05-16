package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
