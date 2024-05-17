package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if(contact.getName() == null || contact.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(contact.getEmail() == null || contact.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(contact.getPhoneNumber() == null || contact.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(phoneNumberAlreadyExists(contact.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is a duplicate");
        }
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public boolean phoneNumberAlreadyExists(String phoneNumber) {
        for(Contact contact : contacts) {
            if(contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
